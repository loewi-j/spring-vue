package cn.edu.hziee.blog.controller;

import cn.edu.hziee.blog.model.Article;
import cn.edu.hziee.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //根据ID查询
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> findArticleById(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();

        Article article = articleService.selectArticleById(id);

        if(article!=null){
            map.put("status", 200);
        }else{
            //500表示：返回值为Null
            map.put("status", 500);
        }
        map.put("data", article);

        return map;
    }

    //查询前一个
    @RequestMapping(value = "prev", method = RequestMethod.GET)
    public Map<String, Object> findPrevArticle(Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        Article article = articleService.selectPrevArticle(id);

        if(article!=null){
            map.put("status", 200);
        }else{
            //返回值为Null
            map.put("status", 500);
        }
        map.put("data", article);

        return map;
    }

    //查询后一个
    @RequestMapping(value = "next", method = RequestMethod.GET)
    public Map<String, Object> findNextArticle(Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        Article article = articleService.selectNextArticle(id);

        if(article!=null){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        map.put("data", article);

        return map;
    }

    //选择插入(标题不得为空)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> addArticle(Article article){
        Map<String, Object> map=new HashMap<String, Object>();

        if (articleService.insertArticleSelective(article) != 0) {
            map.put("status", 200);
        } else {
            // 0表示：插入失败
            map.put("status", 0);
        }

        return map;
    }

    //根据id修改 id由前端隐式输入
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> editArticle(Article article){
        Map<String, Object> map=new HashMap<String, Object>();

        if (articleService.updateArticleSelective(article) != 0) {
            map.put("status", 200);
            map.put("msg", "更新成功");
        } else {
            // 更新失败
            map.put("status", 0);
            map.put("msg", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteArticle(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();

        if (articleService.deleteArticleById(id) != 0) {
            map.put("status", 200);
            map.put("msg", "删除成功");
        } else {
            // 删除失败
            map.put("status", 0);
            map.put("msg", "删除失败");
        }

        return map;
    }



}
