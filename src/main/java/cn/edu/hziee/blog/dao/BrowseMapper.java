package cn.edu.hziee.blog.dao;

import cn.edu.hziee.blog.model.Browse;

public interface BrowseMapper {
    int insert(Browse record);

    int insertSelective(Browse record);
}