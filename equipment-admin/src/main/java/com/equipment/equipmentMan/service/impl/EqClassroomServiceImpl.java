package com.equipment.equipmentMan.service.impl;

import java.util.List;
import com.equipment.common.utils.DateUtils;
import com.equipment.equipmentMan.domain.EqEqment;
import com.equipment.equipmentMan.service.IEqEqmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqClassroomMapper;
import com.equipment.equipmentMan.domain.EqClassroom;
import com.equipment.equipmentMan.service.IEqClassroomService;

/**
 * 教室信息Service业务层处理
 * 
 * @author cdy
 * @date 2022-03-27
 */
@Service
public class EqClassroomServiceImpl implements IEqClassroomService 
{
    @Autowired
    private EqClassroomMapper eqClassroomMapper;

    @Autowired
    private IEqEqmentService eqEqmentService;

    /**
     * 查询教室信息
     * 
     * @param id 教室信息主键
     * @return 教室信息
     */
    @Override
    public EqClassroom selectEqClassroomById(Long id)
    {
        return eqClassroomMapper.selectEqClassroomById(id);
    }

    /**
     * 查询教室信息列表
     * 
     * @param eqClassroom 教室信息
     * @return 教室信息
     */
    @Override
    public List<EqClassroom> selectEqClassroomList(EqClassroom eqClassroom)
    {
        return eqClassroomMapper.selectEqClassroomList(eqClassroom);
    }

    /**
     * 新增教室信息
     * 
     * @param eqClassroom 教室信息
     * @return 结果
     */
    @Override
    public int insertEqClassroom(EqClassroom eqClassroom)
    {
        eqClassroom.setCreateTime(DateUtils.getNowDate());
        return eqClassroomMapper.insertEqClassroom(eqClassroom);
    }

    /**
     * 修改教室信息
     * 
     * @param eqClassroom 教室信息
     * @return 结果
     */
    @Override
    public int updateEqClassroom(EqClassroom eqClassroom)
    {
        eqClassroom.setUpdateTime(DateUtils.getNowDate());
        return eqClassroomMapper.updateEqClassroom(eqClassroom);
    }

    /**
     * 批量删除教室信息
     * 
     * @param ids 需要删除的教室信息主键
     * @return 结果
     */
    @Override
    public int deleteEqClassroomByIds(Long[] ids)
    {
        EqEqment eqEqment = new EqEqment();
        for (int i = 0; i < ids.length; i++) {
            if(eqClassroomMapper.selectEqClassroomById(ids[i]).getStatus().equals("1"))
                return -1;
            eqEqment.setClassroomId(ids[i]);
            if(eqEqmentService.selectEqEqmentList(eqEqment).size() > 0){
                return -2;
            }
        }

        return eqClassroomMapper.deleteEqClassroomByIds(ids);
    }

    /**
     * 删除教室信息信息
     * 
     * @param id 教室信息主键
     * @return 结果
     */
    @Override
    public int deleteEqClassroomById(Long id)
    {
        return eqClassroomMapper.deleteEqClassroomById(id);
    }
}
