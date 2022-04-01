package com.equipment.equipmentMan.domain;

import java.util.Date;

import com.equipment.common.annotation.Excels;
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

    public String getResponsiblePeo() {
        return responsiblePeo;
    }

    public void setResponsiblePeo(String responsible_peo) {
        this.responsiblePeo = responsible_peo;
    }

    /** 负责人 */
    @Excel(name = "负责人")
    private String responsiblePeo;

    /** 教室id */
    @Excel(name = "教室id")
    private Long classroomId;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String className;

//    public EqClassroom getClassroom() {
//        return classroom;
//    }
//
//    public void setClassroom(EqClassroom classroom) {
//        this.classroom = classroom;
//    }

    public EqClassroom getClassroom() {
        return classroom;
    }

    public void setClassroom(EqClassroom classroom) {
        this.classroom = classroom;
    }

    /**
     * 教室对象
     */
//    @Excels({
//            @Excel(name = "教室名称", targetAttr = "className", type = Excel.Type.EXPORT)
//    })
//    private EqClassroom classroom;
    @Excels({
            @Excel(name = "教室名称", targetAttr = "className", type = Excel.Type.EXPORT),
            @Excel(name = "教室状态", targetAttr = "status", type = Excel.Type.EXPORT)
    })
    private EqClassroom classroom;

    /** 出厂日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proDate;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyDate;

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
            .append("classroom", getClassroom())
            .append("responsiblePeo",getResponsiblePeo())
            .toString();
    }
}
