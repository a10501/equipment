package com.equipment.equipmentMan.mapper;

import java.util.List;
import com.equipment.equipmentMan.domain.EqDatamanage;

/**
 * 多媒体教室数据分析Mapper接口
 * 
 * @author cdy
 * @date 2022-04-08
 */
public interface EqDatamanageMapper 
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
     * 删除多媒体教室数据分析
     * 
     * @param id 多媒体教室数据分析主键
     * @return 结果
     */
    public int deleteEqDatamanageById(Long id);

    /**
     * 批量删除多媒体教室数据分析
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqDatamanageByIds(Long[] ids);
}
