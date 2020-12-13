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
     * 操作者IP
     */
    private String userip;

    /**
     * 操作者类型
     */
    private String usertype;

    /**
     * 操作类型
     */
    private String operatetype;

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
    private String recordtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userid) {
        this.userip = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(String operatetype) {
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

    public String getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(String recordtime) {
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
            && (this.getUserip() == null ? other.getUserip() == null : this.getUserip().equals(other.getUserip()))
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
        result = prime * result + ((getUserip() == null) ? 0 : getUserip().hashCode());
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
        sb.append(", userid=").append(userip);
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