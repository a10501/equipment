package com.equipment.equipmentMan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqEqmentClassMapper;
import com.equipment.equipmentMan.domain.EqEqmentClass;
import com.equipment.equipmentMan.service.IEqEqmentClassService;

/**
 * 设备和教室关联Service业务层处理
 * 
 * @author cdy
 * @date 2022-03-19
 */
@Service
public class EqEqmentClassServiceImpl implements IEqEqmentClassService 
{
    @Autowired
    private EqEqmentClassMapper eqEqmentClassMapper;

    /**
     * 查询设备和教室关联
     * 
     * @param eqmentId 设备和教室关联主键
     * @return 设备和教室关联
     */
    @Override
    public EqEqmentClass selectEqEqmentClassByEqmentId(Long eqmentId)
    {
        return eqEqmentClassMapper.selectEqEqmentClassByEqmentId(eqmentId);
    }

    /**
     * 查询设备和教室关联列表
     * 
     * @param eqEqmentClass 设备和教室关联
     * @return 设备和教室关联
     */
    @Override
    public List<EqEqmentClass> selectEqEqmentClassList(EqEqmentClass eqEqmentClass)
    {
        return eqEqmentClassMapper.selectEqEqmentClassList(eqEqmentClass);
    }

    /**
     * 新增设备和教室关联
     * 
     * @param eqEqmentClass 设备和教室关联
     * @return 结果
     */
    @Override
    public int insertEqEqmentClass(EqEqmentClass eqEqmentClass)
    {
        return eqEqmentClassMapper.insertEqEqmentClass(eqEqmentClass);
    }

    /**
     * 修改设备和教室关联
     * 
     * @param eqEqmentClass 设备和教室关联
     * @return 结果
     */
    @Override
    public int updateEqEqmentClass(EqEqmentClass eqEqmentClass)
    {
        return eqEqmentClassMapper.updateEqEqmentClass(eqEqmentClass);
    }

    /**
     * 批量删除设备和教室关联
     * 
     * @param eqmentIds 需要删除的设备和教室关联主键
     * @return 结果
     */
    @Override
    public int deleteEqEqmentClassByEqmentIds(Long[] eqmentIds)
    {
        return eqEqmentClassMapper.deleteEqEqmentClassByEqmentIds(eqmentIds);
    }

    /**
     * 删除设备和教室关联信息
     * 
     * @param eqmentId 设备和教室关联主键
     * @return 结果
     */
    @Override
    public int deleteEqEqmentClassByEqmentId(Long eqmentId)
    {
        return eqEqmentClassMapper.deleteEqEqmentClassByEqmentId(eqmentId);
    }
}
