package com.equipment.equipmentMan.service.impl;

import java.util.List;

import com.equipment.equipmentMan.domain.EqClassroom;
import com.equipment.equipmentMan.domain.EqEqment;
import com.equipment.equipmentMan.domain.EqMainteRecord;
import com.equipment.equipmentMan.mapper.EqClassroomMapper;
import com.equipment.equipmentMan.mapper.EqEqmentMapper;
import com.equipment.equipmentMan.mapper.EqMainteRecordMapper;
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

    @Autowired
    private EqEqmentMapper eqEqmentMapper;

    @Autowired
    private EqClassroomMapper eqClassroomMapper;

    @Autowired
    private EqMainteRecordMapper eqMainteRecordMapper;


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
     * 审批设备报修信息
     * 
     * @param eqBadinfo 设备报修信息
     * @return 结果
     */
    @Override
    public int updateEqBadinfo(EqBadinfo eqBadinfo)
    {
        if (eqBadinfo.getBadinfoStatus().equals("2")) {

            updateEquipmentStatus(eqBadinfo);

            updateClassroomStatus(eqBadinfo);

            addMainteRecord(eqBadinfo);

        }
        return eqBadinfoMapper.updateEqBadinfo(eqBadinfo);

    }

    /**
     *新增维修信息
     */
    public void addMainteRecord(EqBadinfo eqBadinfo){
        EqMainteRecord eqMainteRecord = new EqMainteRecord();
        EqEqment eqEqment = eqEqmentMapper.selectEqEqmentById(eqBadinfo.getEqmentId());
        eqMainteRecord.setRecordName(eqBadinfo.getBadinfoName());
        eqMainteRecord.setRecordStat(eqBadinfo.getBadinfoStat());
        eqMainteRecord.setClassroomId(eqBadinfo.getClassroomId());
        eqMainteRecord.setRecordPeo(eqEqment.getpeopleId());
        eqMainteRecord.setRecordExamineStatus(eqBadinfo.getBadinfoStatus());
        eqMainteRecord.setEqmentId(eqEqment.getId());
        eqMainteRecord.setRecordApplyDate(eqBadinfo.getBadinfoDate());
        eqMainteRecord.setRemark(eqBadinfo.getRemark());
        eqMainteRecordMapper.insertEqMainteRecord(eqMainteRecord);
    }


    /**
     *更改设备状态
     */
    public void  updateEquipmentStatus(EqBadinfo eqBadinfo){
        EqEqment eqEqment = eqEqmentMapper.selectEqEqmentById(eqBadinfo.getEqmentId());
        eqEqment.setEqmentStatus("1");
        eqEqmentMapper.updateEqEqment(eqEqment);
    }

    /**
     *更改教室状态
     */
    public void  updateClassroomStatus(EqBadinfo eqBadinfo){
        EqClassroom eqClassroom = eqClassroomMapper.selectEqClassroomById(eqBadinfo.getClassroomId());
        eqClassroom.setStatus("2");
        eqClassroomMapper.updateEqClassroom(eqClassroom);
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
