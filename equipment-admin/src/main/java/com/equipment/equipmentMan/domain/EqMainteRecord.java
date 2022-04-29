package com.equipment.equipmentMan.domain;

import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 维修信息对象 eq_mainte_record
 * 
 * @author cdy
 * @date 2022-04-12
 */
public class EqMainteRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 维修id */
    private Long id;

    /** 设备名称 */
    private String recordName;

    /** 故障说明 */
    @Excel(name = "故障说明")
    private String recordStat;

    public Long getRecordPeo() {
        return recordPeo;
    }

    public void setRecordPeo(Long recordPeo) {
        this.recordPeo = recordPeo;
    }

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String nickName;

    public String getnickName() {
        return nickName;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String phonenumber;

    /** 负责人id */
    @Excel(name = "负责人id")
    private Long recordPeo;

    /** 审核状态（0待审核 1处理中 2通过） */
    @Excel(name = "审核状态", readConverterExp = "0=待审核,1=处理中,2=通过")
    private String recordExamineStatus;

    /** 维修状态（0待维修 1处理中 2已完成 3拒绝） */
    @Excel(name = "维修状态", readConverterExp = "0=待维修,1=处理中,2=已完成,3=拒绝")
    private String recordStatus;

    /** 维修日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "维修日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date recordDate;

    /** 教室id */
    @Excel(name = "教室id")
    private Long classroomId;

    /** 设备id */
    @Excel(name = "设备id")
    private Long eqmentId;

    public Long getEqmentId() {
        return eqmentId;
    }

    public void setEqmentId(Long eqmentId) {
        this.eqmentId = eqmentId;
    }

    /** 教室名称 */
    private String className;

    /** 设备名称 */
    private String eqmentName;

    public String getEqmentName() {
        return eqmentName;
    }

    public void setEqmentName(String eqmentName) {
        this.eqmentName = eqmentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /** 申报日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "申报日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date recordApplyDate;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordName(String recordName) 
    {
        this.recordName = recordName;
    }

    public String getRecordName() 
    {
        return recordName;
    }
    public void setRecordStat(String recordStat) 
    {
        this.recordStat = recordStat;
    }

    public String getRecordStat() 
    {
        return recordStat;
    }

    public void setRecordExamineStatus(String recordExamineStatus) 
    {
        this.recordExamineStatus = recordExamineStatus;
    }

    public String getRecordExamineStatus() 
    {
        return recordExamineStatus;
    }
    public void setRecordStatus(String recordStatus) 
    {
        this.recordStatus = recordStatus;
    }

    public String getRecordStatus() 
    {
        return recordStatus;
    }
    public void setRecordDate(Date recordDate) 
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate() 
    {
        return recordDate;
    }
    public void setClassroomId(Long classroomId) 
    {
        this.classroomId = classroomId;
    }

    public Long getClassroomId() 
    {
        return classroomId;
    }
    public void setRecordApplyDate(Date recordApplyDate) 
    {
        this.recordApplyDate = recordApplyDate;
    }

    public Date getRecordApplyDate() 
    {
        return recordApplyDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordName", getRecordName())
            .append("recordStat", getRecordStat())
            .append("recordPeo", getRecordPeo())
            .append("recordExamineStatus", getRecordExamineStatus())
            .append("recordStatus", getRecordStatus())
            .append("recordDate", getRecordDate())
            .append("classroomId", getClassroomId())
            .append("eqmentId",getEqmentId())
            .append("recordApplyDate", getRecordApplyDate())
            .append("remark", getRemark())
            .toString();
    }
}
