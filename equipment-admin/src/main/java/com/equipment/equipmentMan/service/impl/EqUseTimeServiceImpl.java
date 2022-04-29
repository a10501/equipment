package com.equipment.equipmentMan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.equipment.equipmentMan.domain.EqDatamanage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqUseTimeMapper;
import com.equipment.equipmentMan.service.IEqUseTimeService;

/**
 * 时长分析Service业务层处理
 * 
 * @author cdy
 * @date 2022-04-09
 */
@Service
public class EqUseTimeServiceImpl implements IEqUseTimeService 
{
    @Autowired
    private EqUseTimeMapper eqUseTimeMapper;

    /**
     * 查询用户时长分析列表
     * 
     * @param eqDatamanage 时长分析
     * @return 时长分析
     */
    @Override
    public List<EqDatamanage> selectEqUseTimeList(EqDatamanage eqDatamanage)
    {
        return eqUseTimeMapper.selectEqUseTimeList(eqDatamanage);
    }

    /**
     * 查询教室时长分析列表
     *
     * @param eqDatamanage 时长分析
     * @return 时长分析
     */
    @Override
    public List<EqDatamanage> selectEqUDataNameTimeList(EqDatamanage eqDatamanage)
    {
        return eqUseTimeMapper.selectEqUDataNameTimeList(eqDatamanage);
    }

    /**
     * 查询教室楼栋时长分析列表
     *
     * @param eqDatamanage 时长分析
     * @return 时长分析
     */
    @Override
    public List<EqDatamanage> selectEqUDataLocationList(EqDatamanage eqDatamanage)
    {
        List<EqDatamanage> list = eqUseTimeMapper.selectEqUDataLocationList(eqDatamanage);
        List<EqDatamanage> list1= new ArrayList<>();
        for (EqDatamanage eq : list
             ) {
            int allTime = Integer.parseInt(eq.getDataUseTime());
            int hour = allTime / 3600 ;
            int minute = allTime % 3600 / 60 ;
            int second = allTime % 3600 % 60 ;
            eq.setDataUseTime(hour + ":" + minute + ":" + second);
            list1.add(eq);
        }
        return list1;
    }


}
