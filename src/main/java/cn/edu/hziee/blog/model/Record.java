package cn.edu.hziee.blog.model;

import java.io.Serializable;
import java.util.Date;

/**
 * record
 * @author 
 */
public class Record implements Serializable {
    private Integer id;

    /**
     * 操作者id
     */
    private Integer userid;

    /**
     * 操作者名字
     */
    private String username;

    /**
     * 操作者类型
     */
    private Integer usertype;

    /**
     * 操作类型
     */
    private Integer operatetype;

    /**
     * 操作描述
     */
    private String operatedesc;

    /**
     * 请求参数
     */
    private String requestparam;

    /**
     * 操作时间
     */
    private Date recordtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Integer operatetype) {
        this.operatetype = operatetype;
    }

    public String getOperatedesc() {
        return operatedesc;
    }

    public void setOperatedesc(String operatedesc) {
        this.operatedesc = operatedesc;
    }

    public String getRequestparam() {
        return requestparam;
    }

    public void setRequestparam(String requestparam) {
        this.requestparam = requestparam;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
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
        Record other = (Record) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUsertype() == null ? other.getUsertype() == null : this.getUsertype().equals(other.getUsertype()))
            && (this.getOperatetype() == null ? other.getOperatetype() == null : this.getOperatetype().equals(other.getOperatetype()))
            && (this.getOperatedesc() == null ? other.getOperatedesc() == null : this.getOperatedesc().equals(other.getOperatedesc()))
            && (this.getRequestparam() == null ? other.getRequestparam() == null : this.getRequestparam().equals(other.getRequestparam()))
            && (this.getRecordtime() == null ? other.getRecordtime() == null : this.getRecordtime().equals(other.getRecordtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUsertype() == null) ? 0 : getUsertype().hashCode());
        result = prime * result + ((getOperatetype() == null) ? 0 : getOperatetype().hashCode());
        result = prime * result + ((getOperatedesc() == null) ? 0 : getOperatedesc().hashCode());
        result = prime * result + ((getRequestparam() == null) ? 0 : getRequestparam().hashCode());
        result = prime * result + ((getRecordtime() == null) ? 0 : getRecordtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", usertype=").append(usertype);
        sb.append(", operatetype=").append(operatetype);
        sb.append(", operatedesc=").append(operatedesc);
        sb.append(", requestparam=").append(requestparam);
        sb.append(", recordtime=").append(recordtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}