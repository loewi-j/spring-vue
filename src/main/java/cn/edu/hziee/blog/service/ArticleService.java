package cn.edu.hziee.blog.service;

import cn.edu.hziee.blog.dao.ArticleMapper;
import cn.edu.hziee.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    //查询博客
    public Article selectArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    //查询前一个
    public Article selectPrevArticle(Integer id) {
        return articleMapper.selectPrevArticle(id);
    }

    //查询后一个
    public Article selectNextArticle(Integer id) {
        return articleMapper.selectNextArticle(id);
    }

    //增加博客（全部）
    public int insertArticle(Article article) {
        if (articleMapper.insert(article) > 0) {
            return 1;
        }
        return 0;
    }

    //增加博客（选择 但标题不得为空）
    public int insertArticleSelective(Article article) {
        if (article.getArticletitle() == null)
            return 0;

        if (articleMapper.insertSelective(article) > 0) {
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

    //分页查询
    public List<Article> selectArticleListByPage(Map<String, Object> map) {
        return null;
    }

    //模糊分页查询
    public List<Article> selectLikeArticleListByPage(Map<String, Object> map) {
        return null;
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
