package com.equipment.equipmentMan.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 设备报修信息对象 eq_badinfo
 * 
 * @author cdy
 * @date 2022-03-19
 */
public class EqBadinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备报修id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String badinfoName;

    /** 故障说明 */
    @Excel(name = "故障说明")
    private String badinfoStat;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String className;

    /** 申请人 */
    @Excel(name = "申请人")
    private String badinfoPeo;

    /** 审核状态（0待审核 1处理中 2通过） */
    @Excel(name = "审核状态", readConverterExp = "0=待审核,1=处理中,2=通过,3=拒绝")
    private String badinfoStatus;

    /** 教室id */
    private Long classroomId;

    /** 设备id */
    private Long eqmentId;

    /** 申报日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "申报日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date badinfoDate;


    public Long getEqmentId() {
        return eqmentId;
    }

    public void setEqmentId(Long eqmentId) {
        this.eqmentId = eqmentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBadinfoName(String badinfoName) 
    {
        this.badinfoName = badinfoName;
    }

    public String getBadinfoName() 
    {
        return badinfoName;
    }
    public void setBadinfoStat(String badinfoStat) 
    {
        this.badinfoStat = badinfoStat;
    }

    public String getBadinfoStat() 
    {
        return badinfoStat;
    }
    public void setBadinfoPeo(String badinfoPeo) 
    {
        this.badinfoPeo = badinfoPeo;
    }

    public String getBadinfoPeo() 
    {
        return badinfoPeo;
    }
    public void setBadinfoStatus(String badinfoStatus) 
    {
        this.badinfoStatus = badinfoStatus;
    }

    public String getBadinfoStatus() 
    {
        return badinfoStatus;
    }
    public void setClassroomId(Long classroomId) 
    {
        this.classroomId = classroomId;
    }

    public Long getClassroomId() 
    {
        return classroomId;
    }
    public void setBadinfoDate(Date badinfoDate) 
    {
        this.badinfoDate = badinfoDate;
    }

    public Date getBadinfoDate() 
    {
        return badinfoDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("badinfoName", getBadinfoName())
            .append("badinfoStat", getBadinfoStat())
            .append("badinfoPeo", getBadinfoPeo())
            .append("badinfoStatus", getBadinfoStatus())
            .append("classroomId", getClassroomId())
            .append("eqmentId",getEqmentId())
            .append("badinfoDate", getBadinfoDate())
            .append("remark", getRemark())
            .toString();
    }
}
