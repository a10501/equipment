package com.equipment.equipmentMan.service;

import java.util.List;
import com.equipment.equipmentMan.domain.EqEqmentClass;

/**
 * 设备和教室关联Service接口
 * 
 * @author cdy
 * @date 2022-03-19
 */
public interface IEqEqmentClassService 
{
    /**
     * 查询设备和教室关联
     * 
     * @param eqmentId 设备和教室关联主键
     * @return 设备和教室关联
     */
    public EqEqmentClass selectEqEqmentClassByEqmentId(Long eqmentId);

    /**
     * 查询设备和教室关联列表
     * 
     * @param eqEqmentClass 设备和教室关联
     * @return 设备和教室关联集合
     */
    public List<EqEqmentClass> selectEqEqmentClassList(EqEqmentClass eqEqmentClass);

    /**
     * 新增设备和教室关联
     * 
     * @param eqEqmentClass 设备和教室关联
     * @return 结果
     */
    public int insertEqEqmentClass(EqEqmentClass eqEqmentClass);

    /**
     * 修改设备和教室关联
     * 
     * @param eqEqmentClass 设备和教室关联
     * @return 结果
     */
    public int updateEqEqmentClass(EqEqmentClass eqEqmentClass);

    /**
     * 批量删除设备和教室关联
     * 
     * @param eqmentIds 需要删除的设备和教室关联主键集合
     * @return 结果
     */
    public int deleteEqEqmentClassByEqmentIds(Long[] eqmentIds);

    /**
     * 删除设备和教室关联信息
     * 
     * @param eqmentId 设备和教室关联主键
     * @return 结果
     */
    public int deleteEqEqmentClassByEqmentId(Long eqmentId);
}
