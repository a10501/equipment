package com.equipment.equipmentMan.service;

import java.util.List;

import com.equipment.equipmentMan.domain.EqClassLocation;
import com.equipment.equipmentMan.domain.EqDatamanage;

/**
 * 多媒体教室数据分析Service接口
 * 
 * @author cdy
 * @date 2022-04-08
 */
public interface IEqDatamanageService 
{
    /**
     * 查询多媒体教室数据分析
     * 
     * @param id 多媒体教室数据分析主键
     * @return 多媒体教室数据分析
     */
    public EqDatamanage selectEqDatamanageById(Long id);

    /**
     * 查询多媒体教室数据分析列表
     * 
     * @param eqDatamanage 多媒体教室数据分析
     * @return 多媒体教室数据分析集合
     */
    public List<EqDatamanage> selectEqDatamanageList(EqDatamanage eqDatamanage);

    /**
     * 新增多媒体教室数据分析
     * 
     * @param eqDatamanage 多媒体教室数据分析
     * @return 结果
     */
    public int insertEqDatamanage(EqDatamanage eqDatamanage);

    /**
     * 修改多媒体教室数据分析
     * 
     * @param eqDatamanage 多媒体教室数据分析
     * @return 结果
     */
    public int updateEqDatamanage(EqDatamanage eqDatamanage);

    /**
     * 批量删除多媒体教室数据分析
     * 
     * @param ids 需要删除的多媒体教室数据分析主键集合
     * @return 结果
     */
    public int deleteEqDatamanageByIds(Long[] ids);

    /**
     * 删除多媒体教室数据分析信息
     * 
     * @param id 多媒体教室数据分析主键
     * @return 结果
     */
    public int deleteEqDatamanageById(Long id);

    /**
     * 导入多媒体设备使用情况数据
     *
     * @param datamanageList 设备使用数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importDataManage(List<EqDatamanage> datamanageList, Boolean isUpdateSupport);
}
