package com.equipment.equipmentMan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqBadinfoMapper;
import com.equipment.equipmentMan.domain.EqBadinfo;
import com.equipment.equipmentMan.service.IEqBadinfoService;

/**
 * 设备报修信息Service业务层处理
 * 
 * @author cdy
 * @date 2022-03-19
 */
@Service
public class EqBadinfoServiceImpl implements IEqBadinfoService 
{
    @Autowired
    private EqBadinfoMapper eqBadinfoMapper;

    /**
     * 查询设备报修信息
     * 
     * @param id 设备报修信息主键
     * @return 设备报修信息
     */
    @Override
    public EqBadinfo selectEqBadinfoById(Long id)
    {
        return eqBadinfoMapper.selectEqBadinfoById(id);
    }

    /**
     * 查询设备报修信息列表
     * 
     * @param eqBadinfo 设备报修信息
     * @return 设备报修信息
     */
    @Override
    public List<EqBadinfo> selectEqBadinfoList(EqBadinfo eqBadinfo)
    {
        return eqBadinfoMapper.selectEqBadinfoList(eqBadinfo);
    }

    /**
     * 新增设备报修信息
     * 
     * @param eqBadinfo 设备报修信息
     * @return 结果
     */
    @Override
    public int insertEqBadinfo(EqBadinfo eqBadinfo)
    {
        return eqBadinfoMapper.insertEqBadinfo(eqBadinfo);
    }

    /**
     * 修改设备报修信息
     * 
     * @param eqBadinfo 设备报修信息
     * @return 结果
     */
    @Override
    public int updateEqBadinfo(EqBadinfo eqBadinfo)
    {
        return eqBadinfoMapper.updateEqBadinfo(eqBadinfo);
    }

    /**
     * 批量删除设备报修信息
     * 
     * @param ids 需要删除的设备报修信息主键
     * @return 结果
     */
    @Override
    public int deleteEqBadinfoByIds(Long[] ids)
    {
        return eqBadinfoMapper.deleteEqBadinfoByIds(ids);
    }

    /**
     * 删除设备报修信息信息
     * 
     * @param id 设备报修信息主键
     * @return 结果
     */
    @Override
    public int deleteEqBadinfoById(Long id)
    {
        return eqBadinfoMapper.deleteEqBadinfoById(id);
    }
}
