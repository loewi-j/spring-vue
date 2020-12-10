package cn.edu.hziee.blog.controller;

import cn.edu.hziee.blog.model.Visitor;
import cn.edu.hziee.blog.service.VisitorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("visitor")
@CrossOrigin
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    //按照不同时间查询访客的数量
    @RequestMapping(value = "/findVisitorsByDate", method = RequestMethod.GET)
    public Map<String, Object> findVisitorsByDate(/*@RequestParam(value="format") */String format,
                                                    /*@RequestParam(value="startTime") */String startTime,
                                                    /*@RequestParam(value="endTime") */String endTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //传入参数
        if (format != "" && format != null) {
            map.put("format", format);
        }
        if (startTime != "" && startTime != null) {
            map.put("startTime", startTime);
        }
        if (endTime != "" && endTime != null) {
            map.put("endTime", endTime);
        }
        List<?> list = visitorService.selectVisitListByDate(map);
        if (list.size() > 0) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        map.put("list", list);
        return map;
    }

    //模糊组合分页查询访客信息
    @RequestMapping(value = "/findVisitorsByPage")
    public Map<String, Object> selectLikeVisitListByPage(Visitor visitor,
                                                         @RequestParam(value = "startTime") String startTime,
                                                         @RequestParam(value = "endTime") String endTime,
                                                         @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
                                                         @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (startTime != "" && startTime != null) {
            map.put("startTime", startTime);
        }
        if (endTime != "" && endTime != null) {
            map.put("endTime", endTime);
        }
        if (visitor.getVisitorip() != null && visitor.getVisitorip() != "") {
            map.put("visitorIP", visitor.getVisitorip());
        }
        if (visitor.getVisitoraddress() != null && visitor.getVisitoraddress() != "") {
            map.put("visitorAddress", visitor.getVisitoraddress());
        }
        if (visitor.getVisitorbrowser() != null && visitor.getVisitorbrowser() != "") {
            map.put("visitorBrowser", visitor.getVisitorbrowser());
        }
        if (visitor.getVisitoros() != null && visitor.getVisitoros() != "") {
            map.put("visitorOS", visitor.getVisitoros());
        }
        //分页显示
        PageHelper.startPage(page, pageSize);
        List<Visitor> visitList = visitorService.selectLikeVisitListByPage(map);
        PageInfo<Visitor> pageInfo = new PageInfo<Visitor>(visitList);

        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (visitList.size() > 0) {
            returnMap.put("status", 200);
        } else {
            returnMap.put("status", 500);
        }
        returnMap.put("visitList", visitList);
        returnMap.put("pageInfo", pageInfo);
        return returnMap;
    }


    //模糊组合分页查询访客信息
    @RequestMapping(value = "/findVisitorsGroupByIp")
    @ResponseBody
    public Map<String, Object> selectLikeVisitListGroupByIp(Visitor visitor,
                                                            @RequestParam(value = "startTime") String startTime,
                                                            @RequestParam(value = "endTime") String endTime,
                                                            @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
                                                            @RequestParam(value = "pageSize", required = true, defaultValue = "9") Integer pageSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (startTime != "" && startTime != null) {
            map.put("startTime", startTime);
        }
        if (endTime != "" && endTime != null) {
            map.put("endTime", endTime);
        }
        if (visitor.getVisitorip() != null && visitor.getVisitorip() != "") {
            map.put("visitorIP", visitor.getVisitorip());
        }
        if (visitor.getVisitoraddress() != null && visitor.getVisitoraddress() != "") {
            map.put("visitorAddress", visitor.getVisitoraddress());
        }
        if (visitor.getVisitorbrowser() != null && visitor.getVisitorbrowser() != "") {
            map.put("visitorBrowser", visitor.getVisitorbrowser());
        }
        if (visitor.getVisitoros() != null && visitor.getVisitoros() != "") {
            map.put("visitorOS", visitor.getVisitoros());
        }
        //分页显示
        PageHelper.startPage(page, pageSize);
        List<?> visitList = visitorService.selectLikeVisitListGroupByIp(map);
        PageInfo pageInfo = new PageInfo(visitList);

        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (visitList.size() > 0) {
            returnMap.put("status", 200);
        } else {
            returnMap.put("status", 500);
        }
        returnMap.put("visitList", visitList);
        returnMap.put("pageInfo", pageInfo);
        return returnMap;
    }


//    @RequestMapping(value = "/selectVisitListByIp", method = RequestMethod.POST)
//    public Map<String, Object> selectVisitListByIp() throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<?> list = visitorService.selectVisitListByIp(map);
//        if (list.size() > 0) {
//            map.put("status", 200);
//        } else {
//            //500表示：返回值为Null
//            map.put("status", 500);
//        }
//        map.put("list", list);
//        return map;
//    }

//    //更新访客功能
//    @RequestMapping(value = "/updateVisit", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> updateVisit(Visit visit) throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (visitService.updateByPrimaryKeySelective(visit) != 0) {
//            map.put("status", 200);
//        } else {
//            //0表示：更新失败
//            map.put("status", 0);
//        }
//        return map;
//    }

}
