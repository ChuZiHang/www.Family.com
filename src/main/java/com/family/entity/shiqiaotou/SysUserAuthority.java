package com.family.entity.shiqiaotou;

/**
 * Created by cunxing on 10/11/2017.
 */
@Entity
@Table(name = "sys_user_authority", schema = "ds3", catalog = "")
public class SysUserAuthority {

    private Long id;

    private Long userId;

    private Long authorityId;

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
    @Column(name = "authority_id")
    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        SysUserAuthority that = (SysUserAuthority)o;

        if(id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if(userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if(authorityId != null ? !authorityId.equals(that.authorityId) : that.authorityId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (authorityId != null ? authorityId.hashCode() : 0);
        return result;
    }
}
