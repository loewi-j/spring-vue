package cn.edu.hziee.blog.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * article
 * @author 
 */
public class Article implements Serializable {
    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章作者
     */
    private Integer author;

    /**
     * 文章名
     */
    private String articletitle;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private String publishdate;

    /**
     * 最后一次修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private String updatedate;

    /**
     * 文章内容
     */
    private String articlecontent;

    /**
     * 文章标签
     */
    private String articletags;

    /**
     * 文章类型
     */
    private String articletype;

    /**
     * 博客分类
     */
    private String articlecategories;

    /**
     * 文章摘要
     */
    private String articleabstract;

    /**
     * 上一篇文章id
     */
    private Integer lastarticleid;

    /**
     * 下一篇文章id
     */
    private Integer nextarticleid;

    /**
     * 博客状态
     */
    private Integer articlestate;

    /**
     * 点击次数
     */
    private Integer click;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

//    public Date getPublishdate() {
//        return publishdate;
//    }
//
//    public void setPublishdate(Date publishdate) {
//        this.publishdate = publishdate;
//    }
//
//    public Date getUpdatedate() {
//        return updatedate;
//    }
//
//    public void setUpdatedate(Date updatedate) {
//        this.updatedate = updatedate;
//    }


    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent;
    }

    public String getArticletags() {
        return articletags;
    }

    public void setArticletags(String articletags) {
        this.articletags = articletags;
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype;
    }

    public String getArticlecategories() {
        return articlecategories;
    }

    public void setArticlecategories(String articlecategories) {
        this.articlecategories = articlecategories;
    }

    public String getArticleabstract() {
        return articleabstract;
    }

    public void setArticleabstract(String articleabstract) {
        this.articleabstract = articleabstract;
    }

    public Integer getLastarticleid() {
        return lastarticleid;
    }

    public void setLastarticleid(Integer lastarticleid) {
        this.lastarticleid = lastarticleid;
    }

    public Integer getNextarticleid() {
        return nextarticleid;
    }

    public void setNextarticleid(Integer nextarticleid) {
        this.nextarticleid = nextarticleid;
    }

    public Integer getArticlestate() {
        return articlestate;
    }

    public void setArticlestate(Integer articlestate) {
        this.articlestate = articlestate;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getArticletitle() == null ? other.getArticletitle() == null : this.getArticletitle().equals(other.getArticletitle()))
            && (this.getPublishdate() == null ? other.getPublishdate() == null : this.getPublishdate().equals(other.getPublishdate()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getArticlecontent() == null ? other.getArticlecontent() == null : this.getArticlecontent().equals(other.getArticlecontent()))
            && (this.getArticletags() == null ? other.getArticletags() == null : this.getArticletags().equals(other.getArticletags()))
            && (this.getArticletype() == null ? other.getArticletype() == null : this.getArticletype().equals(other.getArticletype()))
            && (this.getArticlecategories() == null ? other.getArticlecategories() == null : this.getArticlecategories().equals(other.getArticlecategories()))
            && (this.getArticleabstract() == null ? other.getArticleabstract() == null : this.getArticleabstract().equals(other.getArticleabstract()))
            && (this.getLastarticleid() == null ? other.getLastarticleid() == null : this.getLastarticleid().equals(other.getLastarticleid()))
            && (this.getNextarticleid() == null ? other.getNextarticleid() == null : this.getNextarticleid().equals(other.getNextarticleid()))
            && (this.getArticlestate() == null ? other.getArticlestate() == null : this.getArticlestate().equals(other.getArticlestate()))
            && (this.getClick() == null ? other.getClick() == null : this.getClick().equals(other.getClick()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getArticletitle() == null) ? 0 : getArticletitle().hashCode());
        result = prime * result + ((getPublishdate() == null) ? 0 : getPublishdate().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getArticlecontent() == null) ? 0 : getArticlecontent().hashCode());
        result = prime * result + ((getArticletags() == null) ? 0 : getArticletags().hashCode());
        result = prime * result + ((getArticletype() == null) ? 0 : getArticletype().hashCode());
        result = prime * result + ((getArticlecategories() == null) ? 0 : getArticlecategories().hashCode());
        result = prime * result + ((getArticleabstract() == null) ? 0 : getArticleabstract().hashCode());
        result = prime * result + ((getLastarticleid() == null) ? 0 : getLastarticleid().hashCode());
        result = prime * result + ((getNextarticleid() == null) ? 0 : getNextarticleid().hashCode());
        result = prime * result + ((getArticlestate() == null) ? 0 : getArticlestate().hashCode());
        result = prime * result + ((getClick() == null) ? 0 : getClick().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", author=").append(author);
        sb.append(", articletitle=").append(articletitle);
        sb.append(", publishdate=").append(publishdate);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", articlecontent=").append(articlecontent);
        sb.append(", articletags=").append(articletags);
        sb.append(", articletype=").append(articletype);
        sb.append(", articlecategories=").append(articlecategories);
        sb.append(", articleabstract=").append(articleabstract);
        sb.append(", lastarticleid=").append(lastarticleid);
        sb.append(", nextarticleid=").append(nextarticleid);
        sb.append(", articlestate=").append(articlestate);
        sb.append(", click=").append(click);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}