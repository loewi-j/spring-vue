package cn.edu.hziee.blog.dao;

import cn.edu.hziee.blog.model.Visitor;

public interface VisitorMapper {
    int insert(Visitor record);

    int insertSelective(Visitor record);
}