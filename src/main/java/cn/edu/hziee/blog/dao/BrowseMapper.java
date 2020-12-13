package cn.edu.hziee.blog.dao;

import cn.edu.hziee.blog.model.Browse;
import cn.edu.hziee.blog.model.Visitor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BrowseMapper {
    int insert(Browse record);

    int insertSelective(Browse record);

    //根据时间或id查询
    List<Browse> selectBrowseSelective(Map<String, Object> map);

    //根据时间id更新
    void updateByIdAndTime(Browse record);



}