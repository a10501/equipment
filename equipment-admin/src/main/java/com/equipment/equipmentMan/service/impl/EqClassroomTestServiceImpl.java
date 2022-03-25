package com.equipment.equipmentMan.service.impl;

import java.util.List;
import com.equipment.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqClassroomTestMapper;
import com.equipment.equipmentMan.domain.EqClassroomTest;
import com.equipment.equipmentMan.service.IEqClassroomTestService;

/**
 * 教室信息测试Service业务层处理
 * 
 * @author cdy
 * @date 2022-03-23
 */
@Service
public class EqClassroomTestServiceImpl implements IEqClassroomTestService 
{
    @Autowired
    private EqClassroomTestMapper eqClassroomTestMapper;

    /**
     * 查询教室信息测试
     * 
     * @param id 教室信息测试主键
     * @return 教室信息测试
     */
    @Override
    public EqClassroomTest selectEqClassroomTestById(Long id)
    {
        return eqClassroomTestMapper.selectEqClassroomTestById(id);
    }

    /**
     * 查询教室信息测试列表
     * 
     * @param eqClassroomTest 教室信息测试
     * @return 教室信息测试
     */
    @Override
    public List<EqClassroomTest> selectEqClassroomTestList(EqClassroomTest eqClassroomTest)
    {
        return eqClassroomTestMapper.selectEqClassroomTestList(eqClassroomTest);
    }

    /**
     * 新增教室信息测试
     * 
     * @param eqClassroomTest 教室信息测试
     * @return 结果
     */
    @Override
    public int insertEqClassroomTest(EqClassroomTest eqClassroomTest)
    {
        eqClassroomTest.setCreateTime(DateUtils.getNowDate());
        return eqClassroomTestMapper.insertEqClassroomTest(eqClassroomTest);
    }

    /**
     * 修改教室信息测试
     * 
     * @param eqClassroomTest 教室信息测试
     * @return 结果
     */
    @Override
    public int updateEqClassroomTest(EqClassroomTest eqClassroomTest)
    {
        eqClassroomTest.setUpdateTime(DateUtils.getNowDate());
        return eqClassroomTestMapper.updateEqClassroomTest(eqClassroomTest);
    }

    /**
     * 批量删除教室信息测试
     * 
     * @param ids 需要删除的教室信息测试主键
     * @return 结果
     */
    @Override
    public int deleteEqClassroomTestByIds(Long[] ids)
    {
        return eqClassroomTestMapper.deleteEqClassroomTestByIds(ids);
    }

    /**
     * 删除教室信息测试信息
     * 
     * @param id 教室信息测试主键
     * @return 结果
     */
    @Override
    public int deleteEqClassroomTestById(Long id)
    {
        return eqClassroomTestMapper.deleteEqClassroomTestById(id);
    }
}
