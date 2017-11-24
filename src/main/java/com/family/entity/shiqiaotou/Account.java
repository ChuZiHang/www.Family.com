package com.family.entity.shiqiaotou;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by cunxing on 10/11/2017.
 */
@Entity
public class Account {

    private Long userId;

    private String userName;

    private String password;

    private String mobile;

    private String email;

    private String fullName;

    private String nickname;

    private Integer gender;

    private String avatar;

    private String lastIp;

    private LocalDateTime lastTime;

    private Integer isLock;

    private String authority;

    private LocalDateTime createDate;

    private Integer status;

    private String salt;

    @Id
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "last_ip")
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Basic
    @Column(name = "last_time")
    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    @Basic
    @Column(name = "is_lock")
    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    @Basic
    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "create_date")
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        Account account = (Account)o;

        if(userId != null ? !userId.equals(account.userId) : account.userId != null)
            return false;
        if(userName != null ? !userName.equals(account.userName) : account.userName != null)
            return false;
        if(password != null ? !password.equals(account.password) : account.password != null)
            return false;
        if(mobile != null ? !mobile.equals(account.mobile) : account.mobile != null)
            return false;
        if(email != null ? !email.equals(account.email) : account.email != null)
            return false;
        if(fullName != null ? !fullName.equals(account.fullName) : account.fullName != null)
            return false;
        if(nickname != null ? !nickname.equals(account.nickname) : account.nickname != null)
            return false;
        if(gender != null ? !gender.equals(account.gender) : account.gender != null)
            return false;
        if(avatar != null ? !avatar.equals(account.avatar) : account.avatar != null)
            return false;
        if(lastIp != null ? !lastIp.equals(account.lastIp) : account.lastIp != null)
            return false;
        if(lastTime != null ? !lastTime.equals(account.lastTime) : account.lastTime != null)
            return false;
        if(isLock != null ? !isLock.equals(account.isLock) : account.isLock != null)
            return false;
        if(authority != null ? !authority.equals(account.authority) : account.authority != null)
            return false;
        if(createDate != null ? !createDate.equals(account.createDate) : account.createDate != null)
            return false;
        if(status != null ? !status.equals(account.status) : account.status != null)
            return false;
        if(salt != null ? !salt.equals(account.salt) : account.salt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
        result = 31 * result + (isLock != null ? isLock.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }
}
