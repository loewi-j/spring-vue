package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.annotation.RecordLog;
import cn.edu.hziee.blog.dao.ArticleMapper;
import cn.edu.hziee.blog.model.Article;
import cn.edu.hziee.blog.util.RecordUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    //查询博客
//    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.USERTYPE_USER)
    public Article selectArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    //查询前一个
//    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.USERTYPE_USER)
    public Article selectPrevArticle(Integer id) {
        return articleMapper.selectPrevArticle(id);
    }

    //查询后一个
//    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.USERTYPE_USER)
    public Article selectNextArticle(Integer id) {
        return articleMapper.selectNextArticle(id);
    }

    //按分类查询博客（全部）
    public List<Article> selectArticleListByArticleCategories(String category) {

        return articleMapper.selectArticleListByArticleCategories(category);
    }

    //按分类查找最后一个博客
    public Article selectArticleLastByCategories(String category) {
        return articleMapper.selectArticleLastByCategories(category);
    }

    //模糊分页查询
    public PageInfo selectLikeArticleListByPage(Map<String, Object> map) {
        //分页显示
        PageHelper.startPage((int)map.get("page"), (int)map.get("pageSize"));
        List<Article> list = articleMapper.selectArticleListByPage(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //关键字分类分页查询
//    @RecordLog(operateDesc = RecordUtil.ARTICLE_SELECT, userType=RecordUtil.ARTICLE_FIND)
    public PageInfo selectArticleListByKeyAndCategories(Map<String, Object> map) {
        //分页显示
        PageHelper.startPage((int)map.get("page"), (int)map.get("pageSize"));
        List<Article> list = articleMapper.selectArticleListByKeyAndCategories(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //根据状态和id查询
    public List<?> selectArticleListByArticleStateAndId(Integer id) {
        return articleMapper.selectArticleCountByArticleStateAndId(id);
    }

    //根据状态
    public List<?> selectArticleListByArticleState() {
        return articleMapper.selectArticleListByArticleState();
    }


    //增加博客（选择 但标题不得为空 同时为上一个博客添加指向）
    public int insertArticleSelective(Article article) {
        if (article.getArticletitle() == null)
            return 0;
        //查找上一个博客
        Article last = this.selectArticleLastByCategories(article.getArticlecategories());
        article.setLastarticleid(last.getId());

        if (articleMapper.insertSelective(article) > 0) {
            last.setNextarticleid(article.getId());
            articleMapper.updateByPrimaryKeySelective(last);
            return 1;
        }
        return 0;
    }

    public int deleteArticleById(Integer id) {

        return articleMapper.deleteByPrimaryKey(id);

    }

    //根据主键修改数据(选择)
    public int updateArticleSelective(Article article) {

        if (articleMapper.updateByPrimaryKeySelective(article) > 0) {
            return 1;
        }

        return 0;
    }


    //模糊分页分组查询
    public List<Article> selectGroupLikeArticleListByPage(Map<String, Object> map) {
        return null;
    }

    //根据类别分类查询
    public Map<String, List<Article>> selectArticleByAllType() {
        return null;
    }

    //根据点击量查询
    public List<?> selectArticleByClick() {
        return null;
    }

    //根据分类id查询
    public List<Article> selectArticleByTypeId(Integer id) {
        return null;
    }

    //根据时间查询
    public List<?> selectArticleListByDate(Map<String, Object> map) {
        return null;
    }

    //模糊查询数量
    public Long selectArticleCount(Map<String, Object> map) {
        return null;
    }

    //根据状态查询
    public List<?> selectArticleListByStatus() {
        return null;
    }
}
