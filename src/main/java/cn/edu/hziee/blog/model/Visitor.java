package cn.edu.hziee.blog.model;

import java.io.Serializable;
import java.util.Date;

/**
 * visitor
 * @author 
 */
public class Visitor implements Serializable {
    private Integer userId;

    /**
     * 访客名字
     */
    private String visitorname;

    /**
     * 真实IP
     */
    private String visitorip;

    /**
     * 地理位置
     */
    private String visitoraddress;

    /**
     * 浏览器
     */
    private String visitorbrowser;

    /**
     * 操作系统
     */
    private String visitoros;

    /**
     * 访问时间
     */
    private String visittime;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userId;
    }

    public void setUserid(Integer id) {
        this.userId = id;
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname;
    }

    public String getVisitorip() {
        return visitorip;
    }

    public void setVisitorip(String visitorip) {
        this.visitorip = visitorip;
    }

    public String getVisitoraddress() {
        return visitoraddress;
    }

    public void setVisitoraddress(String visitoraddress) {
        this.visitoraddress = visitoraddress;
    }

    public String getVisitorbrowser() {
        return visitorbrowser;
    }

    public void setVisitorbrowser(String visitorbrowser) {
        this.visitorbrowser = visitorbrowser;
    }

    public String getVisitoros() {
        return visitoros;
    }

    public void setVisitoros(String visitoros) {
        this.visitoros = visitoros;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
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
        Visitor other = (Visitor) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getVisitorname() == null ? other.getVisitorname() == null : this.getVisitorname().equals(other.getVisitorname()))
            && (this.getVisitorip() == null ? other.getVisitorip() == null : this.getVisitorip().equals(other.getVisitorip()))
            && (this.getVisitoraddress() == null ? other.getVisitoraddress() == null : this.getVisitoraddress().equals(other.getVisitoraddress()))
            && (this.getVisitorbrowser() == null ? other.getVisitorbrowser() == null : this.getVisitorbrowser().equals(other.getVisitorbrowser()))
            && (this.getVisitoros() == null ? other.getVisitoros() == null : this.getVisitoros().equals(other.getVisitoros()))
            && (this.getVisittime() == null ? other.getVisittime() == null : this.getVisittime().equals(other.getVisittime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getVisitorname() == null) ? 0 : getVisitorname().hashCode());
        result = prime * result + ((getVisitorip() == null) ? 0 : getVisitorip().hashCode());
        result = prime * result + ((getVisitoraddress() == null) ? 0 : getVisitoraddress().hashCode());
        result = prime * result + ((getVisitorbrowser() == null) ? 0 : getVisitorbrowser().hashCode());
        result = prime * result + ((getVisitoros() == null) ? 0 : getVisitoros().hashCode());
        result = prime * result + ((getVisittime() == null) ? 0 : getVisittime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(userId);
        sb.append(", visitorname=").append(visitorname);
        sb.append(", visitorip=").append(visitorip);
        sb.append(", visitoraddress=").append(visitoraddress);
        sb.append(", visitorbrowser=").append(visitorbrowser);
        sb.append(", visitoros=").append(visitoros);
        sb.append(", visittime=").append(visittime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}