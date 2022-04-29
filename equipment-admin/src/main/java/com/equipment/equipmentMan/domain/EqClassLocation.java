package com.equipment.equipmentMan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 多媒体分布信息对象 eq_class_location
 * 
 * @author cdy
 * @date 2022-04-06
 */
public class EqClassLocation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分布id */
    private Long id;

    /** 所在楼栋 */
    @Excel(name = "所在楼栋")
    private String location;

    /** 教室分布(多个教室以、分割) */
    @Excel(name = "教室分布(多个教室以、分割)")
    private String locationClass;

    /** 数量 */
    @Excel(name = "数量")
    private Long eqNumber;

    /** 使用教程下载地址 */
    @Excel(name = "使用教程下载地址")
    private String useDownload;

    /** 责任人 */
    @Excel(name = "责任人")
    private String personCharg;

    /** 值班电话 */
    @Excel(name = "值班电话")
    private String personPhone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setLocationClass(String locationClass) 
    {
        this.locationClass = locationClass;
    }


    public String getLocationClass() 
    {
        return locationClass;
    }
    public void setEqNumber(Long eqNumber) 
    {
        this.eqNumber = eqNumber;
    }

    public Long getEqNumber() 
    {
        return eqNumber;
    }
    public void setUseDownload(String useDownload) 
    {
        this.useDownload = useDownload;
    }

    public String getUseDownload() 
    {
        return useDownload;
    }
    public void setPersonCharg(String personCharg) 
    {
        this.personCharg = personCharg;
    }

    public String getPersonCharg() 
    {
        return personCharg;
    }
    public void setPersonPhone(String personPhone) 
    {
        this.personPhone = personPhone;
    }

    public String getPersonPhone() 
    {
        return personPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("location", getLocation())
            .append("locationClass", getLocationClass())
            .append("eqNumber", getEqNumber())
            .append("useDownload", getUseDownload())
            .append("personCharg", getPersonCharg())
            .append("personPhone", getPersonPhone())
            .toString();
    }
}
