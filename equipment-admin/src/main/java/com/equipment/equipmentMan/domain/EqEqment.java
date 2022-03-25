package com.equipment.equipmentMan.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 设备信息对象 eq_eqment
 * 
 * @author cdy
 * @date 2022-03-19
 */
public class EqEqment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String eqmentName;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String eqmentNumber;

    /** 状态（0使用中 1停用） */
    @Excel(name = "状态", readConverterExp = "0=使用中,1=停用")
    private String eqmentStatus;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String eqmentType;

    /** 教室id */
    @Excel(name = "教室id")
    private Long classroomId;

    /** 出厂日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proDate;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyDate;

    /** 教室信息信息 */
    private List<EqClass> eqClassList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEqmentName(String eqmentName) 
    {
        this.eqmentName = eqmentName;
    }

    public String getEqmentName() 
    {
        return eqmentName;
    }
    public void setEqmentNumber(String eqmentNumber) 
    {
        this.eqmentNumber = eqmentNumber;
    }

    public String getEqmentNumber() 
    {
        return eqmentNumber;
    }
    public void setEqmentStatus(String eqmentStatus) 
    {
        this.eqmentStatus = eqmentStatus;
    }

    public String getEqmentStatus() 
    {
        return eqmentStatus;
    }
    public void setEqmentType(String eqmentType) 
    {
        this.eqmentType = eqmentType;
    }

    public String getEqmentType() 
    {
        return eqmentType;
    }
    public void setClassroomId(Long classroomId) 
    {
        this.classroomId = classroomId;
    }

    public Long getClassroomId() 
    {
        return classroomId;
    }
    public void setProDate(Date proDate) 
    {
        this.proDate = proDate;
    }

    public Date getProDate() 
    {
        return proDate;
    }
    public void setBuyDate(Date buyDate) 
    {
        this.buyDate = buyDate;
    }

    public Date getBuyDate() 
    {
        return buyDate;
    }

    public List<EqClass> getEqClassList()
    {
        return eqClassList;
    }

    public void setEqClassList(List<EqClass> eqClassList)
    {
        this.eqClassList = eqClassList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("eqmentName", getEqmentName())
            .append("eqmentNumber", getEqmentNumber())
            .append("eqmentStatus", getEqmentStatus())
            .append("eqmentType", getEqmentType())
            .append("classroomId", getClassroomId())
            .append("proDate", getProDate())
            .append("buyDate", getBuyDate())
            .append("remark", getRemark())
            .append("eqClassList", getEqClassList())
            .toString();
    }
}
