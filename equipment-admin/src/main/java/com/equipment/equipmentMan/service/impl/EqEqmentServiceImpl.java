package com.equipment.equipmentMan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.equipment.common.utils.StringUtils;
import com.equipment.equipmentMan.domain.EqClassroom;
import com.equipment.equipmentMan.domain.EqEqmentClass;
import com.equipment.equipmentMan.mapper.EqEqmentClassMapper;
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
    @Autowired
    private EqEqmentClassMapper eqEqmentClassMapper;

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
     * 新增教室设备关联信息
     *
     * @param eqEqment 设备对象
     */
    public void insertEqEqmentClass(EqEqment eqEqment)
    {
        Long eqEqmentId = eqEqment.getId();
        if (StringUtils.isNotNull(eqEqmentId))
        {
            // 新增教室与设备关联
            EqEqmentClass eqEqmentClass = new EqEqmentClass();
            eqEqmentClass.setEqmentId(eqEqmentId);
            eqEqmentClass.setClassId(eqEqment.getClassroomId());
            if (eqEqmentId.toString().length() > 0)
            {
                eqEqmentClassMapper.insertEqEqmentClass(eqEqmentClass);
            }
        }
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
        EqEqment eqEqment1 = new EqEqment();
        eqEqment1.setClassroomId(eqEqment.getClassroomId());
        eqEqment1.setEqmentType(eqEqment.getEqmentType());
        if(eqEqmentMapper.selectEqEqmentList(eqEqment1).size() > 0){
            return -1;
        }
        int row = eqEqmentMapper.insertEqEqment(eqEqment);
        //新增教室设备关联信息
        insertEqEqmentClass(eqEqment);


        return row;
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
        Long eqmentId = eqEqment.getId();
        //删除教室设备关联表信息
        eqEqmentClassMapper.deleteEqEqmentClassByEqmentId(eqmentId);
        //新增教室设备关联表信息
        insertEqEqmentClass(eqEqment);
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
        EqEqment eqEqment = new EqEqment();
        for(int i = 0; i < ids.length; i++){
            if(!eqEqmentMapper.selectEqEqmentById(ids[i]).getEqmentStatus().equals("2")){
                return -1;
            }
        }
        eqEqmentClassMapper.deleteEqEqmentClassByEqmentIds(ids);
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
        eqEqmentClassMapper.deleteEqEqmentClassByEqmentId(id);
        return eqEqmentMapper.deleteEqEqmentById(id);
    }
}
