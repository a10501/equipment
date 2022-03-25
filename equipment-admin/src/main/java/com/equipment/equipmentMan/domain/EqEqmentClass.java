package com.equipment.equipmentMan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 设备和教室关联对象 eq_eqment_class
 * 
 * @author cdy
 * @date 2022-03-19
 */
public class EqEqmentClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备id */
    private Long eqmentId;

    /** 教室id */
    private Long classId;

    public void setEqmentId(Long eqmentId) 
    {
        this.eqmentId = eqmentId;
    }

    public Long getEqmentId() 
    {
        return eqmentId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eqmentId", getEqmentId())
            .append("classId", getClassId())
            .toString();
    }
}
