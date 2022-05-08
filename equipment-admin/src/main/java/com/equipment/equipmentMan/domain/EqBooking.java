package com.equipment.equipmentMan.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 预约信息对象 eq_booking
 * 
 * @author cdy
 * @date 2022-05-05
 */
public class EqBooking extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约id */
    private Long id;

    /** 预约编号 */
    @Excel(name = "预约编号")
    private String bookingName;

    /** 申请人id */
    private Long bookingPeo;

    /** 申请人姓名 */
    @Excel(name = "申请人")
    private String nickName;



    /** 审核状态（0待审核 1处理中 2通过,3拒绝） */
    @Excel(name = "审核状态", readConverterExp = "0=待审核,1=处理中,2=通过,3拒绝")
    private String bookingStatus;

    /** 预约日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookingDate;

    /** 课节 */
    @Excel(name = "课节")
    private String   classTime;

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /** 教室id */
    private Long classroomId;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String className;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date bookingApplyDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBookingName(String bookingName) 
    {
        this.bookingName = bookingName;
    }

    public String getBookingName() 
    {
        return bookingName;
    }
    public void setBookingPeo(Long bookingPeo) 
    {
        this.bookingPeo = bookingPeo;
    }

    public Long getBookingPeo() 
    {
        return bookingPeo;
    }
    public void setBookingStatus(String bookingStatus) 
    {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingStatus() 
    {
        return bookingStatus;
    }
    public void setBookingDate(Date bookingDate) 
    {
        this.bookingDate = bookingDate;
    }

    public Date getBookingDate() 
    {
        return bookingDate;
    }
    public void setClassroomId(Long classroomId) 
    {
        this.classroomId = classroomId;
    }

    public Long getClassroomId() 
    {
        return classroomId;
    }
    public void setBookingApplyDate(Date bookingApplyDate) 
    {
        this.bookingApplyDate = bookingApplyDate;
    }

    public Date getBookingApplyDate() 
    {
        return bookingApplyDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bookingName", getBookingName())
            .append("bookingPeo", getBookingPeo())
            .append("bookingStatus", getBookingStatus())
            .append("bookingDate", getBookingDate())
            .append("classroomId", getClassroomId())
            .append("bookingApplyDate", getBookingApplyDate())
            .append("remark", getRemark())
            .append("classTime",getClassTime())
            .toString();
    }
}
