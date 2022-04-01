package com.equipment.equipmentMan.service.impl;

import java.util.List;

import com.equipment.common.core.domain.entity.SysUser;
import com.equipment.common.core.domain.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqEqmentMapper;
import com.equipment.equipmentMan.domain.EqEqment;
import com.equipment.equipmentMan.service.IEqEqmentService;

/**
 * 设备信息Service业务层处理
 * 
 * @author cdy
 * @date 2022-03-19
 */
@Service
public class EqEqmentServiceImpl implements IEqEqmentService 
{
    @Autowired
    private EqEqmentMapper eqEqmentMapper;

    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    @Override
    public EqEqment selectEqEqmentById(Long id)
    {
        return eqEqmentMapper.selectEqEqmentById(id);
    }

    /**
     * 查询设备信息列表
     * 
     * @param eqEqment 设备信息
     * @return 设备信息
     */
    @Override
    public List<EqEqment> selectEqEqmentList(EqEqment eqEqment)
    {
        return eqEqmentMapper.selectEqEqmentList(eqEqment);
    }

    /**
     * 新增设备信息
     * 
     * @param eqEqment 设备信息
     * @return 结果
     */
    @Override
    public int insertEqEqment(EqEqment eqEqment)
    {
        return eqEqmentMapper.insertEqEqment(eqEqment);
    }

    /**
     * 修改设备信息
     * 
     * @param eqEqment 设备信息
     * @return 结果
     */
    @Override
    public int updateEqEqment(EqEqment eqEqment)
    {
        return eqEqmentMapper.updateEqEqment(eqEqment);
    }

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteEqEqmentByIds(Long[] ids)
    {
        return eqEqmentMapper.deleteEqEqmentByIds(ids);
    }

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteEqEqmentById(Long id)
    {
        return eqEqmentMapper.deleteEqEqmentById(id);
    }
}
