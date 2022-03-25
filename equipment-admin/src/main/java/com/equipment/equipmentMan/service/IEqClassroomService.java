package com.equipment.equipmentMan.service;

import java.util.List;
import com.equipment.equipmentMan.domain.EqClassroom;

/**
 * 教室信息Service接口
 * 
 * @author cdy
 * @date 2022-03-20
 */
public interface IEqClassroomService 
{
    /**
     * 查询教室信息
     * 
     * @param id 教室信息主键
     * @return 教室信息
     */
    public EqClassroom selectEqClassroomById(Long id);

    /**
     * 查询教室信息列表
     * 
     * @param eqClassroom 教室信息
     * @return 教室信息集合
     */
    public List<EqClassroom> selectEqClassroomList(EqClassroom eqClassroom);

    /**
     * 新增教室信息
     * 
     * @param eqClassroom 教室信息
     * @return 结果
     */
    public int insertEqClassroom(EqClassroom eqClassroom);

    /**
     * 修改教室信息
     * 
     * @param eqClassroom 教室信息
     * @return 结果
     */
    public int updateEqClassroom(EqClassroom eqClassroom);

    /**
     * 批量删除教室信息
     * 
     * @param ids 需要删除的教室信息主键集合
     * @return 结果
     */
    public int deleteEqClassroomByIds(Long[] ids);

    /**
     * 删除教室信息信息
     * 
     * @param id 教室信息主键
     * @return 结果
     */
    public int deleteEqClassroomById(Long id);
}
