package cn.edu.hziee.blog.dao;

import cn.edu.hziee.blog.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);


    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    //根据id查询
    Article selectByPrimaryKey(Integer id);

    //获取上一篇博客
    Article selectPrevArticle(Integer id);

    //获取下一篇一篇博客
    Article selectNextArticle(Integer id);

    //安分类查找最后一条博客
    Article selectArticleLastByCategories(String categories);

    //按不同条件组合 分页查询博客
    List<Article> selectArticleListByPage(Map<String, Object> map);

    //获取博客信息，根据类别分组查询
    List<Article> selectArticleListByArticleCategories(String category);

    //关键字分类查询
    List<Article> selectArticleListByKeyAndCategories(Map<String, Object> map);

    //根据状态和id查询
    List<?> selectArticleCountByArticleStateAndId(Integer id);

    /**
     *  获取博客信息，根据日期月份分组查询
     */
//    List<?> selectArticleListByDate(Map<String, Object> map);

    //根据状态分组查询 返回数量
    List<?>  selectArticleListByArticleState();


//    List<?> selectArticleByClick();


    /**
     * 模糊分页查询博客
     */
    List<Article> selectLikeArticleListByPage(Map<String, Object> map);

    /**
     * 模糊分页组合查询博客 (不含内容)
     */

//    List<Article> selectGroupLikeArticleListByPage(Map<String, Object> map);

    /**
     * 取得每个类别下的前N条记录
     */
//    List<Article> selectArticleByAllType();

    /**
     * 模糊分页组合查询博客 含内容
     */
    List<Article> selectLikeArticleListByPageWithBlobs(Map<String, Object> map);
    /**
     *  根据组合条件获取Article条数
     */
    Long selectArticleCount(Map<String, Object> map);


//    int updateArticleSelective(Article record);


    int updateArticleWithBLOBs(Article record);


    int updateArticle(Article record);
}