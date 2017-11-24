package com.family.entity.shiqiaotou;

/**
 * Created by cunxing on 10/11/2017.
 */
@Entity
@Table(name = "sys_authority", schema = "ds3", catalog = "")
public class SysAuthority {

    private Long id;

    private String name;

    private String expression;

    private String description;

    private Integer priority;

    private Integer status;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "expression")
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        SysAuthority that = (SysAuthority)o;

        if(id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if(name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if(expression != null ? !expression.equals(that.expression) : that.expression != null)
            return false;
        if(description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if(priority != null ? !priority.equals(that.priority) : that.priority != null)
            return false;
        if(status != null ? !status.equals(that.status) : that.status != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
