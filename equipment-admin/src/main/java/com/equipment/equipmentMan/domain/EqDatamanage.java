package com.equipment.equipmentMan.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 多媒体教室数据分析对象 eq_datamanage
 * 
 * @author cdy
 * @date 2022-04-08
 */
public class EqDatamanage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据分析id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String dataName;

    /** 用户 */
    @Excel(name = "用户")
    private String dataUseName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date dataStartTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date dataEndTime;

    /** 使用时间 */
    @Excel(name = "使用时间")
    private String dataUseTime;

    /** 事件类型 */
    @Excel(name = "事件类型")
    private String dataEventType;

    public String getDataLocName() {
        return dataLocName;
    }

    public void setDataLocName(String dataLocName) {
        this.dataLocName = dataLocName;
    }

    /** 楼栋名称 */
    @Excel(name = "楼栋名称")
    private String dataLocName;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDataName(String dataName) 
    {
        this.dataName = dataName;
    }

    public String getDataName() 
    {
        return dataName;
    }
    public void setDataUseName(String dataUseName) 
    {
        this.dataUseName = dataUseName;
    }

    public String getDataUseName() 
    {
        return dataUseName;
    }
    public void setDataStartTime(Date dataStartTime) 
    {
        this.dataStartTime = dataStartTime;
    }

    public Date getDataStartTime() 
    {
        return dataStartTime;
    }
    public void setDataEndTime(Date dataEndTime) 
    {
        this.dataEndTime = dataEndTime;
    }

    public Date getDataEndTime() 
    {
        return dataEndTime;
    }
    public void setDataUseTime(String dataUseTime) 
    {
        this.dataUseTime = dataUseTime;
    }

    public String getDataUseTime() 
    {
        return dataUseTime;
    }
    public void setDataEventType(String dataEventType) 
    {
        this.dataEventType = dataEventType;
    }

    public String getDataEventType() 
    {
        return dataEventType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dataName", getDataName())
            .append("dataUseName", getDataUseName())
            .append("dataStartTime", getDataStartTime())
            .append("dataEndTime", getDataEndTime())
            .append("dataUseTime", getDataUseTime())
            .append("dataEventType", getDataEventType())
            .append("dataLocName",getDataLocName())
            .toString();
    }
}
