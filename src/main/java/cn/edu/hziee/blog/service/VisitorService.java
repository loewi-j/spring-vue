package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.dao.VisitorMapper;
import cn.edu.hziee.blog.model.Visitor;
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


    public List<Visitor> selectLikeVisitListByPage(Map<String, Object> map) {
        return visitorMapper.selectLikeVisitListByPage(map);
    }

    public List<?> selectVisitListByIp(Map<String, Object> map) {
        return visitorMapper.selectVisitListByIp(map);
    }

    public List<?> selectLikeVisitListGroupByIp(Map<String, Object> map) {
        return visitorMapper.selectLikeVisitListGroupByIp(map);
    }

}
