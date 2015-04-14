package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.Bayonet;
import com.tianyi.bph.domain.system.BayonetInfo;
import com.tianyi.bph.query.system.BayonetQuery;
/**
 * 
* @Title: BayonetService.java
* @Package com.tianyi.bph.service.base
* @Description: TODO(卡口业务处理类)
* @author wangxing  
* @date 2015年2月3日 上午9:43:50
* @version V1.0
 */
public interface BayonetService {
	/**
	 * 通过机构id 获取 卡口列表信息
	 * @param query
	 * @return
	 */
	public List<BayonetInfo> getPageList(BayonetQuery query);
	
	/**
	 * 通过id删除卡口信息
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id);
	/**
	 * 插入卡口数据
	 * @param record
	 * @return
	 */
	public int insert(Bayonet record);
	/**
	 * 插入卡口数据
	 * @param record
	 * @return
	 */
	public int insertSelective(Bayonet record);
	/**
	 * 通过id查询卡口信息
	 * @param id
	 * @return
	 */
	public Bayonet selectByPrimaryKey(Integer id);
   /**
    * 更新卡口信息
    * @param record
    * @return
    */
    public int updateByPrimaryKeySelective(Bayonet record);
    /**
     * 更新卡口信息
     * @param record
     * @return
     */
    public BayonetInfo updateByPrimaryKey(BayonetInfo record);
}
