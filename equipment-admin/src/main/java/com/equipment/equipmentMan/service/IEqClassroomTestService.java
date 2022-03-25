package com.equipment.equipmentMan.service;

import java.util.List;
import com.equipment.equipmentMan.domain.EqClassroomTest;

/**
 * 教室信息测试Service接口
 * 
 * @author cdy
 * @date 2022-03-23
 */
public interface IEqClassroomTestService 
{
    /**
     * 查询教室信息测试
     * 
     * @param id 教室信息测试主键
     * @return 教室信息测试
     */
    public EqClassroomTest selectEqClassroomTestById(Long id);

    /**
     * 查询教室信息测试列表
     * 
     * @param eqClassroomTest 教室信息测试
     * @return 教室信息测试集合
     */
    public List<EqClassroomTest> selectEqClassroomTestList(EqClassroomTest eqClassroomTest);

    /**
     * 新增教室信息测试
     * 
     * @param eqClassroomTest 教室信息测试
     * @return 结果
     */
    public int insertEqClassroomTest(EqClassroomTest eqClassroomTest);

    /**
     * 修改教室信息测试
     * 
     * @param eqClassroomTest 教室信息测试
     * @return 结果
     */
    public int updateEqClassroomTest(EqClassroomTest eqClassroomTest);

    /**
     * 批量删除教室信息测试
     * 
     * @param ids 需要删除的教室信息测试主键集合
     * @return 结果
     */
    public int deleteEqClassroomTestByIds(Long[] ids);

    /**
     * 删除教室信息测试信息
     * 
     * @param id 教室信息测试主键
     * @return 结果
     */
    public int deleteEqClassroomTestById(Long id);
}
