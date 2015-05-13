package com.tianyi.bph.service.impl.system;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.tianyi.bph.dao.system.GBDeviceMapper;
import com.tianyi.bph.dao.system.GBOrganMapper;
import com.tianyi.bph.dao.system.OrganDAO;
import com.tianyi.bph.dao.system.OrganGBOrganMapper;
import com.tianyi.bph.domain.system.GBDevice;
import com.tianyi.bph.domain.system.GBOrgan;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.domain.system.OrganGBOrganKey;
import com.tianyi.bph.exception.RestException;
import com.tianyi.bph.query.system.GBDeviceExample;
import com.tianyi.bph.query.system.GBOrganExample;
import com.tianyi.bph.query.system.OrganGBOrganExample;
import com.tianyi.bph.service.system.GBPlatFormService;

@Service
public class GBPlatFormServiceImpl implements GBPlatFormService {

	@Resource
	private GBOrganMapper organMapper;
	@Resource
	private OrganDAO organDao;
	@Resource
	private OrganGBOrganMapper organGBOrganMapper;
	@Resource
	private GBDeviceMapper deviceMapper;

	@Override
	public GBOrgan getOrganTree(int organId) {
		List<GBOrgan> list = organMapper.selectByExample(new GBOrganExample());
		if (list != null && !list.isEmpty()) {
			List<Integer> keys = organGBOrganMapper
					.selectGBOrganIdByOrganId(organId);
			if (!keys.isEmpty()) {
				for (Integer key : keys) {
					for (GBOrgan organ : list) {
						if (organ.getId().equals(key)) {
							organ.setChecked(true);
						}
					}
				}
			}
			return new Tree(list).buildTree();
		}
		return null;
	}

	class Tree {
		private Iterator<GBOrgan> it;
		final private List<GBOrgan> nodes;

		public Tree(List<GBOrgan> nodes) {
			this.nodes = nodes;
		}

		@Cacheable(cacheName = cacheName)
		public GBOrgan buildTree() {
			GBOrgan parent = null;
			it = nodes.iterator();
			while (it.hasNext()) {
				GBOrgan node = it.next();
				if (node.getParentId() == null) {
					parent = node;
					parent.setExpanded(true);
					it.remove();
					build(node);
				}
			}
			return parent;
		}

		private void build(GBOrgan node) {
			List<GBOrgan> children = getChildren(node);
			if (children != null && !children.isEmpty()) {
				for (GBOrgan child : children) {
					build(child);
				}
			}
		}

		private List<GBOrgan> getChildren(GBOrgan node) {
			Integer id = node.getId();
			it = nodes.iterator();
			boolean exp = false;
			while (it.hasNext()) {
				GBOrgan child = it.next();
				if (id.equals(child.getParentId())) {
					if (child.isChecked()) {
						exp = true;
					}
					node.addChild(child);
					it.remove();
				}
			}
			node.setExpanded(exp);
			return node.getItems();
		}
	}

	@Override
	public void addGBPermission(Integer organId, List<OrganGBOrganKey> list) {
		OrganGBOrganExample example = new OrganGBOrganExample();
		example.createCriteria().andOrganIdEqualTo(organId);
		organGBOrganMapper.deleteByExample(example);
		for (OrganGBOrganKey key : list) {
			organGBOrganMapper.insert(key);
		}
	}

	@Override
	@Cacheable(cacheName = cacheName)
	public List<GBDevice> getGBDeviceListByOrganId(Integer organId) {
		List<GBDevice> list = null;
		if (organId != null) {
			GBDeviceExample example = new GBDeviceExample();
			List<Integer> GBIds = organGBOrganMapper
					.selectGBOrganIdByOrganId(organId);
			if (!GBIds.isEmpty()) {
				example.createCriteria().andGbOrganIdIn(GBIds);
				list = deviceMapper.selectByExample(example);
			}
		}
		return list;
	}

	final private static String cacheName = "GB_BASE_DATA";// 国标缓存对象名

	@Override
	public List<OrganGBOrganKey> queryOrganGBOrganKey(Integer organId) {
		Organ organ = organDao.selectByPrimaryKey(organId);
		if (organ == null) {
			throw new RestException("机构不存在!");
		}
		return organGBOrganMapper.selectByOrganId(organ.getPath());
	}

	@Override
	public List<GBDevice> queryAllGbDevice() {
		return deviceMapper.queryAllGbDevice();
	}

	@Override
	public GBDevice getGBDeviceById(Integer gbDeviceId) {
		return deviceMapper.selectByPrimaryKey(gbDeviceId);
	}

	@Override
	public List<GBOrgan> loadGbOrgan(Integer organId, Integer parentId) {
		List<GBOrgan> list = organMapper.selectByGBOrganId(parentId);
		if (!list.isEmpty()) {
			List<Integer> keys = organGBOrganMapper
					.selectGBOrganIdByOrganId(organId);
			if (!keys.isEmpty()) {
				for (Integer key : keys) {
					for (GBOrgan organ : list) {
						if (organ.getId().equals(key)) {
							organ.setChecked(true);
						}
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<GBDevice> getGBDeviceListByGBOrganId(Integer gbOrganId) {
		GBDeviceExample example = new GBDeviceExample();
		example.createCriteria().andGbOrganIdEqualTo(gbOrganId);
		return deviceMapper.selectByExample(example);
	}
}
