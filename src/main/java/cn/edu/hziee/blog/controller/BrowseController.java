package cn.edu.hziee.blog.controller;

import cn.edu.hziee.blog.model.Article;
import cn.edu.hziee.blog.model.Browse;
import cn.edu.hziee.blog.service.ArticleService;
import cn.edu.hziee.blog.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("browse")
@CrossOrigin
public class BrowseController {

    @Autowired
    private BrowseService browseService;
    @Autowired
    private ArticleService articleService;

    //增加或更新访客
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> addOrUpdateBrowse(Browse browse) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        browse.setBrowsetime(sdf.format(new Date()));

        map.put("browseTime", browse.getBrowsetime());
        map.put("id", browse.getId());

        //更新文章点击次数
        Article article = articleService.selectArticleById(browse.getId());
        article.setClick(article.getClick() + 1);
        articleService.updateArticleSelective(article);

        //已有记录在
        if (browseService.selectBrowseSelective(map).size() != 0) {
            //直接更新
            browseService.updateByIdAndTime(browse);
            map.put("msg", "更新记录");
            map.put("status", 200);
        } else {
            //创建新纪录
            browseService.insertSelective(browse);

            map.put("msg", "创建记录");
            map.put("status", 500);
        }
        return map;
    }

    //按照博客id或时间查询访客数量
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> findBrowseByIdAndTime(Browse browse, @RequestParam(value="startTime", defaultValue = "") String startTime,
                                                     @RequestParam(value="endTime", defaultValue = "") String endTime) {
        Map<String, Object> map = new HashMap<String, Object>();

        //传入参数
        if (startTime != "" && startTime != null) {
            map.put("startTime", startTime);
        }
        if (endTime != "" && endTime != null) {
            map.put("endTime", endTime);
        }
        if (browse.getBrowsetime() != "" && browse.getBrowsetime() != null) {
            map.put("browseTime", browse.getBrowsetime());
        }
        if (browse.getId() != null) {
            map.put("id", browse.getId());
        }

        List<Browse> list = browseService.selectBrowseSelective(map);
        if(list!=null){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        map.put("list", list);

        return map;
    }


}
