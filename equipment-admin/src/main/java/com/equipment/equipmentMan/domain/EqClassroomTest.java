package com.equipment.equipmentMan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.TreeEntity;

/**
 * 教室信息测试对象 eq_classroom
 * 
 * @author cdy
 * @date 2022-03-23
 */
public class EqClassroomTest extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 教室id */
    private Long id;

    /** 教室状态（0未使用 1使用中） */
    @Excel(name = "教室状态", readConverterExp = "0=未使用,1=使用中")
    private String status;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String className;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("ancestors", getAncestors())
            .append("status", getStatus())
            .append("className", getClassName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
