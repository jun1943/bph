package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.common.Constants;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.annotation.MQDataInterceptor;
import com.tianyi.bph.dao.system.BayonetDao;
import com.tianyi.bph.dao.system.BayonetInfoMapper;
import com.tianyi.bph.domain.system.Bayonet;
import com.tianyi.bph.domain.system.BayonetInfo;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.exception.RestException;
import com.tianyi.bph.query.system.BayonetQuery;
import com.tianyi.bph.service.system.BayonetService;
/**
 * 
* @Title: BayonetService.java
* @Package com.tianyi.bph.service.base
* @Description: TODO(卡口业务处理类)
* @author wangxing  
* @date 2015年2月3日 上午9:43:50
* @version V1.0
 */
@Service
public class BayonetServiceImpl implements BayonetService{
	private static final Logger log=LoggerFactory.getLogger(BayonetServiceImpl.class);
	
	//@Autowired BayonetDao bayonetDao;
	@Autowired BayonetInfoMapper bayonetDao;
	
	/**
	 * 通过机构id 获取 卡口列表信息
	 * @param query
	 * @return
	 */
	public List<BayonetInfo> getPageList(BayonetQuery query){
		return bayonetDao.findByPage(query);
	}
	
	/**
	 * 通过id删除卡口信息
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return bayonetDao.deleteByPrimaryKey(id);
	}
	/**
	 * 插入卡口数据
	 * @param record
	 * @return
	 */
	public int insert(Bayonet record){
		
		BayonetQuery query=new BayonetQuery();
		query.setName(record.getBayonetName());
		query.setCode(record.getBayonetCode());
		//验证卡口信息是否重复
		int count=bayonetDao.getUniqueCountByQuery(query);
		if(count >0){
			return 0;	
		}
		return bayonetDao.insert(record);
	}
	/**
	 * 插入卡口数据
	 * @param record
	 * @return
	 */
	public int insertSelective(Bayonet record){
		return bayonetDao.insert(record);
	}
	/**
	 * 通过id查询卡口信息
	 * @param id
	 * @return
	 */
	public Bayonet selectByPrimaryKey(Integer id){
		//return bayonetDao.selectByPrimaryKey(id);
		return null;
	}
   /**
    * 更新卡口信息
    * @param record
    * @return
    */
    public int updateByPrimaryKeySelective(Bayonet record){
    	return bayonetDao.updateByPrimaryKeySelective(record);
    }

	@Override
	@MQDataInterceptor(type = Constants.MQ_TYPE_CARDKOU, operate = Constants.MQ_OPERATE_UPDATE)
	public BayonetInfo updateByPrimaryKey(BayonetInfo record) {
		if(record == null){
			throw new RestException("对象不能为空");
		}
		int i=0;
		BayonetInfo info=bayonetDao.selectByPrimaryKey(record.getBayonetId());
		
		if(info ==null){
			return null;
		}
		bayonetDao.updateByPrimaryKey(record);
		// TODO Auto-generated method stub
		return record;
	}
}
