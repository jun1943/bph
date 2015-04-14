package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.basicdata.Police;
import com.tianyi.bph.domain.system.CardPoint;
import com.tianyi.bph.domain.system.CardPointCamera;
import com.tianyi.bph.domain.system.CardPointHead;
import com.tianyi.bph.domain.system.CircleLayer;
import com.tianyi.bph.query.system.CardPointQuery;

/**
 * 卡点
 * 
 * @author Administrator
 *
 */
@MyBatisRepository
public interface CardPointDAO {
	
    int deleteByPrimaryKey(Integer id);

    int insert(CardPoint record);

    int insertSelective(CardPoint record);

    CardPoint selectByPrimaryKey(Integer id);
    
    CardPoint selectById(Integer id);

    int updateByPrimaryKeySelective(CardPoint record);

    int updateByPrimaryKey(CardPoint record);
    
    //根据条件查询总数
    int getUniqueCountByQuery(CardPointQuery cardPointQuery);
    
    //根据子机构总数
    int getChildCount(Integer parentId);
    
    //查询排序号
    int getSortNo(Integer parentId);
    
    //分页查询
    List<CardPoint> findByPage(CardPointQuery cardPointQuery);
    
    //分页总条数
    int findCount(CardPointQuery cardPointQuery);
    
    //条件查询
    List<CardPoint> findByQuery(CardPointQuery cardPointQuery);
    
    //客户端查询接口
  	public List<CardPoint> queryCardPointList(int organId);
   
    //修改指定字段
    int updateByMySelective(CardPoint record);
    
    int queryCardPointTotal();
    
    // 添加卡点负责人
    void addCardPointHead(CardPointHead cardPointHead);
    
    //清除卡点负责人
    void deleteCardPointHead(int cardPointHead);
    
    //清除卡点天网
    void deleteCardPointCamera(int cardPoint);
    
    // 查询卡点负责人
    public List<CardPointHead> getCardPointHead(int cardPointId);
    
    public List<CardPointCamera> getCardPointCamera(int cardPointId);
    
    public void addCardPointCamera(CardPointCamera camera);
    
    // 圈层查询
    public List<CircleLayer> getCircleLayerList();
    
    public int modifyCardPointCoordinate(CardPoint cardPoint);
}