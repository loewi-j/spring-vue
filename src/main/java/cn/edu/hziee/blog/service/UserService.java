package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.dao.UserMapper;
import cn.edu.hziee.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id) {

        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User user) {

        return userMapper.insert(user);
    }

    public int insertSelective(User user) {

        return userMapper.insertSelective(user);
    }

    public User selectByPrimaryKey(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    public int updateByPrimaryKeySelective(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int updateByPrimaryKey(User user) {

        return userMapper.updateByPrimaryKey(user);
    }

//    @Override
//    public User findUserByLoginName(String name) {
//        // TODO Auto-generated method stub
//        return userMapper.findUserByLoginName(name);
//    }

}
