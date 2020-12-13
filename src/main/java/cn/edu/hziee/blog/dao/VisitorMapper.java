package cn.edu.hziee.blog.dao;

import cn.edu.hziee.blog.model.Visitor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface VisitorMapper {
    int insert(Visitor record);

    int insertSelective(Visitor record);

    //根据ip查询
    Visitor selectVisitByIp(String ip);

    //模糊查询
    List<Visitor> selectLikeVisitListByPage(Map<String, Object> map);

    //模糊查询 分组显示
    List<?> selectLikeVisitListGroupByIp(Map<String, Object> map);

    //根据日期月份 分组查询
    List<?>  selectVisitListByDate(Map<String, Object> map);

    //根据IP分组查询
    List<?>  selectVisitListByIp(Map<String, Object> map);
}