package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.dao.VisitorMapper;
import cn.edu.hziee.blog.model.Visitor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;

    public int insert(Visitor visitor) {
        return visitorMapper.insert(visitor);
    }

    public int insertSelective(Visitor record) {
        return visitorMapper.insertSelective(record);
    }

    public Visitor selectVisitByIp(String ip) {
        return visitorMapper.selectVisitByIp(ip);
    }

    public List<?> selectVisitListByDate(Map<String, Object> map) {
        return visitorMapper.selectVisitListByDate(map);
    }


    public PageInfo selectLikeVisitListByPage(Map<String, Object> map) {
        //分页显示
        PageHelper.startPage((int)map.get("page"), (int)map.get("pageSize"));
        List<Visitor> list = visitorMapper.selectLikeVisitListByPage(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public List<?> selectVisitListByIp(Map<String, Object> map) {
        return visitorMapper.selectVisitListByIp(map);
    }

    public PageInfo selectLikeVisitListGroupByIp(Map<String, Object> map) {
        //分页显示
        PageHelper.startPage((int)map.get("page"), (int)map.get("pageSize"));
        List<?> list = visitorMapper.selectLikeVisitListGroupByIp(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
