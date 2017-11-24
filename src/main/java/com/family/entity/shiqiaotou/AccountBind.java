package com.family.entity.shiqiaotou;

import java.time.LocalDateTime;

/**
 * Created by cunxing on 10/11/2017.
 */
@Entity
@Table(name = "account_bind", schema = "ds3", catalog = "")
public class AccountBind {

    private Long id;

    private Long userId;

    private String source;

    private String openId;

    private String unionId;

    private LocalDateTime createDate;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "open_id")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "union_id")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Basic
    @Column(name = "create_date")
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        AccountBind that = (AccountBind)o;

        if(id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if(userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if(source != null ? !source.equals(that.source) : that.source != null)
            return false;
        if(openId != null ? !openId.equals(that.openId) : that.openId != null)
            return false;
        if(unionId != null ? !unionId.equals(that.unionId) : that.unionId != null)
            return false;
        if(createDate != null ? !createDate.equals(that.createDate) : that.createDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (unionId != null ? unionId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
