package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.dao.RecordMapper;
import cn.edu.hziee.blog.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    @Autowired
    RecordMapper recordMapper;

    public int deleteByPrimaryKey(Integer id) {
        return recordMapper.deleteByPrimaryKey(id);
    };

    public int insert(Record record) {
        return recordMapper.insert(record);

    };

    public int insertSelective(Record record) {
        return recordMapper.insertSelective(record);

    };

    public Record selectByPrimaryKey(Integer id) {
        return recordMapper.selectByPrimaryKey(id);

    };

    public int updateByPrimaryKeySelective(Record record) {
        return recordMapper.updateByPrimaryKeySelective(record);

    };

    public int updateByPrimaryKey(Record record) {
        return recordMapper.updateByPrimaryKey(record);

    };

}
