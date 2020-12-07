package cn.edu.hziee.blog.model;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 个人简介
     */
    private String personalbrief;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最后登录时间
     */
    private Date recentlylanded;

    /**
     * 头像地址
     */
    private String avatarimgurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPersonalbrief() {
        return personalbrief;
    }

    public void setPersonalbrief(String personalbrief) {
        this.personalbrief = personalbrief;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRecentlylanded() {
        return recentlylanded;
    }

    public void setRecentlylanded(Date recentlylanded) {
        this.recentlylanded = recentlylanded;
    }

    public String getAvatarimgurl() {
        return avatarimgurl;
    }

    public void setAvatarimgurl(String avatarimgurl) {
        this.avatarimgurl = avatarimgurl;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getPersonalbrief() == null ? other.getPersonalbrief() == null : this.getPersonalbrief().equals(other.getPersonalbrief()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getRecentlylanded() == null ? other.getRecentlylanded() == null : this.getRecentlylanded().equals(other.getRecentlylanded()))
            && (this.getAvatarimgurl() == null ? other.getAvatarimgurl() == null : this.getAvatarimgurl().equals(other.getAvatarimgurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPersonalbrief() == null) ? 0 : getPersonalbrief().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRecentlylanded() == null) ? 0 : getRecentlylanded().hashCode());
        result = prime * result + ((getAvatarimgurl() == null) ? 0 : getAvatarimgurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", personalbrief=").append(personalbrief);
        sb.append(", email=").append(email);
        sb.append(", recentlylanded=").append(recentlylanded);
        sb.append(", avatarimgurl=").append(avatarimgurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}