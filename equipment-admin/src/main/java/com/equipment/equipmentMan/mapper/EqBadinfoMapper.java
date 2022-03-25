package com.equipment.equipmentMan.mapper;

import java.util.List;
import com.equipment.equipmentMan.domain.EqBadinfo;
import com.equipment.equipmentMan.domain.EqClass;

/**
 * 设备报修信息Mapper接口
 * 
 * @author cdy
 * @date 2022-03-19
 */
public interface EqBadinfoMapper 
{
    /**
     * 查询设备报修信息
     * 
     * @param id 设备报修信息主键
     * @return 设备报修信息
     */
    public EqBadinfo selectEqBadinfoById(Long id);

    /**
     * 查询设备报修信息列表
     * 
     * @param eqBadinfo 设备报修信息
     * @return 设备报修信息集合
     */
    public List<EqBadinfo> selectEqBadinfoList(EqBadinfo eqBadinfo);

    /**
     * 新增设备报修信息
     * 
     * @param eqBadinfo 设备报修信息
     * @return 结果
     */
    public int insertEqBadinfo(EqBadinfo eqBadinfo);

    /**
     * 修改设备报修信息
     * 
     * @param eqBadinfo 设备报修信息
     * @return 结果
     */
    public int updateEqBadinfo(EqBadinfo eqBadinfo);

    /**
     * 删除设备报修信息
     * 
     * @param id 设备报修信息主键
     * @return 结果
     */
    public int deleteEqBadinfoById(Long id);

    /**
     * 批量删除设备报修信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqBadinfoByIds(Long[] ids);

    /**
     * 批量删除教室信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqClassByIds(Long[] ids);
    
    /**
     * 批量新增教室信息
     * 
     * @param eqClassList 教室信息列表
     * @return 结果
     */
    public int batchEqClass(List<EqClass> eqClassList);
    

    /**
     * 通过设备报修信息主键删除教室信息信息
     * 
     * @param id 设备报修信息ID
     * @return 结果
     */
    public int deleteEqClassById(Long id);
}
