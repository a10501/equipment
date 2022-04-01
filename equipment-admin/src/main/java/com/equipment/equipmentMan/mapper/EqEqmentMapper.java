package com.equipment.equipmentMan.mapper;

import java.util.List;
import com.equipment.equipmentMan.domain.EqEqment;

/**
 * 设备信息Mapper接口
 * 
 * @author cdy
 * @date 2022-03-19
 */
public interface EqEqmentMapper 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    public EqEqment selectEqEqmentById(Long id);

    /**
     * 查询设备信息列表
     * 
     * @param eqEqment 设备信息
     * @return 设备信息集合
     */
    public List<EqEqment> selectEqEqmentList(EqEqment eqEqment);

    /**
     * 新增设备信息
     * 
     * @param eqEqment 设备信息
     * @return 结果
     */
    public int insertEqEqment(EqEqment eqEqment);

    /**
     * 修改设备信息
     * 
     * @param eqEqment 设备信息
     * @return 结果
     */
    public int updateEqEqment(EqEqment eqEqment);

    /**
     * 删除设备信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteEqEqmentById(Long id);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqEqmentByIds(Long[] ids);
}
