package com.equipment.equipmentMan.service.impl;

import java.util.List;

import com.equipment.equipmentMan.domain.EqBadinfo;
import com.equipment.equipmentMan.domain.EqClassroom;
import com.equipment.equipmentMan.domain.EqEqment;
import com.equipment.equipmentMan.mapper.EqClassroomMapper;
import com.equipment.equipmentMan.mapper.EqEqmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqMainteRecordMapper;
import com.equipment.equipmentMan.domain.EqMainteRecord;
import com.equipment.equipmentMan.service.IEqMainteRecordService;

/**
 * 维修信息Service业务层处理
 * 
 * @author cdy
 * @date 2022-04-12
 */
@Service
public class EqMainteRecordServiceImpl implements IEqMainteRecordService 
{
    @Autowired
    private EqMainteRecordMapper eqMainteRecordMapper;

    @Autowired
    private EqEqmentMapper eqEqmentMapper;

    @Autowired
    private EqClassroomMapper eqClassroomMapper;


    /**
     * 查询维修信息
     * 
     * @param id 维修信息主键
     * @return 维修信息
     */
    @Override
    public EqMainteRecord selectEqMainteRecordById(Long id)
    {
        return eqMainteRecordMapper.selectEqMainteRecordById(id);
    }

    /**
     * 查询维修信息列表
     * 
     * @param eqMainteRecord 维修信息
     * @return 维修信息
     */
    @Override
    public List<EqMainteRecord> selectEqMainteRecordList(EqMainteRecord eqMainteRecord)
    {
        return eqMainteRecordMapper.selectEqMainteRecordList(eqMainteRecord);
    }

    /**
     * 新增维修信息
     * 
     * @param eqMainteRecord 维修信息
     * @return 结果
     */
    @Override
    public int insertEqMainteRecord(EqMainteRecord eqMainteRecord)
    {
        return eqMainteRecordMapper.insertEqMainteRecord(eqMainteRecord);
    }

    /**
     * 审批维修信息
     * 
     * @param eqMainteRecord 维修信息
     * @return 结果
     */
    @Override
    public int updateEqMainteRecord(EqMainteRecord eqMainteRecord)
    {
        if(eqMainteRecord.getRecordStatus().equals("3")){
            updateEquipmentStatus(eqMainteRecord);
            updateClassroomStatus(eqMainteRecord);
        }

        return eqMainteRecordMapper.updateEqMainteRecord(eqMainteRecord);
    }

    /**
     *更改设备状态
     */
    public void  updateEquipmentStatus(EqMainteRecord eqMainteRecord){
        EqEqment eqEqment = eqEqmentMapper.selectEqEqmentById(eqMainteRecord.getEqmentId());
        eqEqment.setEqmentStatus("0");
        eqEqmentMapper.updateEqEqment(eqEqment);
    }

    /**
     *更改教室状态
     */
    public void  updateClassroomStatus(EqMainteRecord eqMainteRecord){
        EqClassroom eqClassroom = eqClassroomMapper.selectEqClassroomById(eqMainteRecord.getClassroomId());
        eqClassroom.setStatus("0");
        eqClassroomMapper.updateEqClassroom(eqClassroom);
    }

    /**
     * 批量删除维修信息
     * 
     * @param ids 需要删除的维修信息主键
     * @return 结果
     */
    @Override
    public int deleteEqMainteRecordByIds(Long[] ids)
    {
        return eqMainteRecordMapper.deleteEqMainteRecordByIds(ids);
    }

    /**
     * 删除维修信息信息
     * 
     * @param id 维修信息主键
     * @return 结果
     */
    @Override
    public int deleteEqMainteRecordById(Long id)
    {
        return eqMainteRecordMapper.deleteEqMainteRecordById(id);
    }
}
