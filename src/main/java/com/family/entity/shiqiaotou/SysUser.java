package com.family.entity.shiqiaotou;

import java.time.LocalDateTime;

/**
 * Created by cunxing on 10/11/2017.
 */
@Entity
@Table(name = "sys_user", schema = "ds3", catalog = "")
public class SysUser {

    private Long id;

    private String userName;

    private String password;

    private Integer isManager;

    private String fullName;

    private String mobile;

    private String email;

    private String lastIp;

    private LocalDateTime lastTime;

    private Integer isLock;

    private LocalDateTime createDate;

    private Integer status;

    private String salt;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "is_manager")
    public Integer getIsManager() {
        return isManager;
    }

    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
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

        SysUser sysUser = (SysUser)o;

        if(id != null ? !id.equals(sysUser.id) : sysUser.id != null)
            return false;
        if(userName != null ? !userName.equals(sysUser.userName) : sysUser.userName != null)
            return false;
        if(password != null ? !password.equals(sysUser.password) : sysUser.password != null)
            return false;
        if(isManager != null ? !isManager.equals(sysUser.isManager) : sysUser.isManager != null)
            return false;
        if(fullName != null ? !fullName.equals(sysUser.fullName) : sysUser.fullName != null)
            return false;
        if(mobile != null ? !mobile.equals(sysUser.mobile) : sysUser.mobile != null)
            return false;
        if(email != null ? !email.equals(sysUser.email) : sysUser.email != null)
            return false;
        if(lastIp != null ? !lastIp.equals(sysUser.lastIp) : sysUser.lastIp != null)
            return false;
        if(lastTime != null ? !lastTime.equals(sysUser.lastTime) : sysUser.lastTime != null)
            return false;
        if(isLock != null ? !isLock.equals(sysUser.isLock) : sysUser.isLock != null)
            return false;
        if(createDate != null ? !createDate.equals(sysUser.createDate) : sysUser.createDate != null)
            return false;
        if(status != null ? !status.equals(sysUser.status) : sysUser.status != null)
            return false;
        if(salt != null ? !salt.equals(sysUser.salt) : sysUser.salt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isManager != null ? isManager.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
        result = 31 * result + (isLock != null ? isLock.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }
}
