package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.dao.BrowseMapper;
import cn.edu.hziee.blog.model.Browse;
import cn.edu.hziee.blog.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrowseService {

    @Autowired
    BrowseMapper browseMapper;

    public int insert(Browse record) {
        return browseMapper.insert(record);
    };

    public int insertSelective(Browse record) {
        return browseMapper.insertSelective(record);
    };

    //根据时间和id查询
    public List<Browse> selectBrowseSelective(Map<String, Object> map) {
        return browseMapper.selectBrowseSelective(map);
    };

    //根据时间id更新
    public void updateByIdAndTime(Browse record) {
        browseMapper.updateByIdAndTime(record);
    };


}
