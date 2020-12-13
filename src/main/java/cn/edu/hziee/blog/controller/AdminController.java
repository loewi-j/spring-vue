package cn.edu.hziee.blog.controller;

import cn.edu.hziee.blog.annotation.RecordLog;
import cn.edu.hziee.blog.model.Article;
import cn.edu.hziee.blog.service.ArticleService;
import cn.edu.hziee.blog.util.RecordUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    ArticleService articleService;

    //根据ID查询
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.USERTYPE_ADMIN)
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
    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.USERTYPE_ADMIN)
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
    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.USERTYPE_ADMIN)
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

    //分类查询
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public Map<String, Object> findArticleByCategories(@RequestParam(value = "category", defaultValue = "") String category,
                                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "pageSize", defaultValue = "6") int pageSize){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("articleCategories", category);
        map.put("page", page);
        map.put("pageSize", pageSize);
        PageInfo pageInfo = articleService.selectLikeArticleListByPage(map);

        if(pageInfo!=null){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        map.put("list", pageInfo);
        return map;
    }

    //关键字查询
    @RequestMapping(value = "key", method = RequestMethod.GET)
    @RecordLog(operateDesc = RecordUtil.ARTICLE_FIND, userType=RecordUtil.USERTYPE_ADMIN)
    public Map<String, Object> findArticleByKeyAndCategories(@RequestParam(value = "key", defaultValue = "") String key,
                                                             @RequestParam(value = "category", defaultValue = "") String category,
                                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                                             @RequestParam(value = "pageSize", defaultValue = "6") int pageSize){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("key", key);
        map.put("articleCategories", category);
        map.put("page", page);
        map.put("pageSize", pageSize);
        PageInfo pageInfo = articleService.selectArticleListByKeyAndCategories(map);

        if(pageInfo!=null){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        map.put("list", pageInfo);
        return map;
    }

    //根据状态和id查询
    @RequestMapping(value = "stateCount", method = RequestMethod.GET)
    public Map<String, Object> findArticleByStateAndId(@RequestParam(value = "id", defaultValue = "") Integer id){
        Map<String, Object> map=new HashMap<String, Object>();

        List<?> list = articleService.selectArticleListByArticleState();

        if(list!=null){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        map.put("list", list);
        return map;
    }

    //选择插入(标题不得为空)
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RecordLog(operateDesc = RecordUtil.ARTICLE_ADD, userType=RecordUtil.USERTYPE_ADMIN)
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
    @RecordLog(operateDesc = RecordUtil.ARTICLE_UPDATE, userType=RecordUtil.USERTYPE_ADMIN)
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
    @RecordLog(operateDesc = RecordUtil.ARTICLE_DELETE, userType=RecordUtil.USERTYPE_ADMIN)
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
