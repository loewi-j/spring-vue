package cn.edu.hziee.blog.controller;

import cn.edu.hziee.blog.dao.VisitorMapper;
import cn.edu.hziee.blog.model.User;
import cn.edu.hziee.blog.model.Visitor;
import cn.edu.hziee.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private VisitorMapper visitorMapper;
    private Visitor visitor;
    private User user;

    //增加
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> add(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userService.insertSelective(user) != 0) {
            map.put("status", 200);
            map.put("msg", "添加成功");
            map.put("username", user.getUsername());
        } else {
            // 0表示：插入失败
            map.put("status", 0);
            map.put("msg", "添加失败");
        }
        return map;
    }

    //批量删除
//    @RequestMapping(value = "", method = RequestMethod.DELETE)
//    public Map<String, Object> delete(int[] ids) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        int flag = 0;
//        if (ids != null) {//批量删除
//            for (int id : ids) {
//                flag += userService.deleteByPrimaryKey(id);
//            }
//        }
//        return flag;
//    }

    //单个删除
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userService.deleteByPrimaryKey(id) != 0) {
            map.put("status", 200);
            map.put("msg", "删除成功");
        } else {
            // 删除失败
            map.put("status", 0);
            map.put("msg", "删除失败");
        }
        return map;
    }

    //查找
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> getById(@PathVariable int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.selectByPrimaryKey(id);//从数据库找到id对应的对象
        if(user!=null){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        map.put("data", user);
        return map;
    }

    //修改
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> edit(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userService.updateByPrimaryKeySelective(user) != 0) {
            map.put("status", 200);
            map.put("msg", "更新成功");
        } else {
            // 更新失败
            map.put("status", 0);
            map.put("msg", "更新失败");
        }
        return map;
    }

//    //分页查询
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public Page<User> getPage(@RequestParam(defaultValue = "1") int currentPage,
//                              String username,Integer age,String gender,String birthday,String phone) {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("username",username);
//        map.put("age",age);
//        map.put("gender",gender);
//        map.put("birthday",birthday);
//        map.put("phone",phone);
//        Page<User> page = userService.findByPage(currentPage,map);
//        return page;
//    }

    //登录验证
    @RequestMapping("/checkLogin")
    public Map<String, Object> login(String username, String password, HttpSession session,
                                     String visitorIP, String visitorAddress, String visitorBrowser , String visitorOS) throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        visitor = new Visitor();
        System.out.println(username + " " + password);

        //保存数据至session
        if (session.getAttribute("username") != null) {
            map.put("status", 200);
            map.put("msg", "登录成功");
            return map;
        }

        boolean result = false;
        List<User> users = userService.selectByUsername(username);

        for (User user : users) {
            if (user.getPassword().equals(password)) {

                long now = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(new Date());//当前时间

                //当前时间  距离当天凌晨  秒数
                long overTime = (now - (sdf.parse(sdf.format(now)).getTime()))/1000;

                session.setMaxInactiveInterval((int)overTime);//以秒为单位
                session.setAttribute("username", username);

                visitor.setUserid(user.getId());
                visitor.setVisitorname(user.getUsername());
                visitor.setVisittime(time);
                visitor.setVisitorip(visitorIP);
                visitor.setVisitoraddress(visitorAddress);
                visitor.setVisitorbrowser(visitorBrowser);
                visitor.setVisitoros(visitorOS);
                visitorMapper.insertSelective(visitor);//添加访问记录

                map.put("status", 200);
                map.put("msg", "验证成功");
                map.put("username", session.getAttribute("username"));
                result = true;
                break;
            }
        }

        if (!result) {
            map.put("status", 0);
            map.put("msg", "验证失败");
        }

        return map;
    }

    //注册
    @RequestMapping("/register")
    public Map<String, Object> register(String username, String password, HttpSession session,
                                     String visitorIP, String visitorAddress, String visitorBrowser , String visitorOS) throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        visitor = new Visitor();
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.insertSelective(user);

        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());//当前时间

        //当前时间  距离当天凌晨  秒数
        long overTime = (now - (sdf.parse(sdf.format(now)).getTime()))/1000;

        session.setMaxInactiveInterval((int)overTime);//以秒为单位
        session.setAttribute("username", username);

        visitor.setUserid(user.getId());
        visitor.setVisitorname(user.getUsername());
        visitor.setVisittime(time);
        visitor.setVisitorip(visitorIP);
        visitor.setVisitoraddress(visitorAddress);
        visitor.setVisitorbrowser(visitorBrowser);
        visitor.setVisitoros(visitorOS);
        visitorMapper.insertSelective(visitor);//添加访问记录

        map.put("status", 200);
        map.put("msg", "注册成功");
        map.put("username", session.getAttribute("username"));

        return map;
    }

    //退出
    @RequestMapping(value = "/logout")
    public void logout(HttpSession session, SessionStatus sessionStatus) {
        session.removeAttribute("username");
        sessionStatus.setComplete();
    }


}
