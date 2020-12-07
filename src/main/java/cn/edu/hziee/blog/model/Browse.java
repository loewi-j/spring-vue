package cn.edu.hziee.blog.model;

import java.io.Serializable;
import java.util.Date;

/**
 * browse
 * @author 
 */
public class Browse implements Serializable {
    private Integer id;

    /**
     * 博客名
     */
    private String articlename;

    /**
     * 浏览人数
     */
    private Integer browsenum;

    /**
     * 浏览时间
     */
    private Date browsetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public Integer getBrowsenum() {
        return browsenum;
    }

    public void setBrowsenum(Integer browsenum) {
        this.browsenum = browsenum;
    }

    public Date getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(Date browsetime) {
        this.browsetime = browsetime;
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
        Browse other = (Browse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getArticlename() == null ? other.getArticlename() == null : this.getArticlename().equals(other.getArticlename()))
            && (this.getBrowsenum() == null ? other.getBrowsenum() == null : this.getBrowsenum().equals(other.getBrowsenum()))
            && (this.getBrowsetime() == null ? other.getBrowsetime() == null : this.getBrowsetime().equals(other.getBrowsetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getArticlename() == null) ? 0 : getArticlename().hashCode());
        result = prime * result + ((getBrowsenum() == null) ? 0 : getBrowsenum().hashCode());
        result = prime * result + ((getBrowsetime() == null) ? 0 : getBrowsetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articlename=").append(articlename);
        sb.append(", browsenum=").append(browsenum);
        sb.append(", browsetime=").append(browsetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}