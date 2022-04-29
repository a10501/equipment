package com.equipment.equipmentMan.service;

import java.util.List;

import com.equipment.equipmentMan.domain.EqDatamanage;

/**
 * 时长分析Service接口
 * 
 * @author cdy
 * @date 2022-04-09
 */
public interface IEqUseTimeService {

    /**
     * 查询用户时长分析列表
     *
     * @param eqDatamanage 时长分析
     * @return 时长分析集合
     */
    public List<EqDatamanage> selectEqUseTimeList(EqDatamanage eqDatamanage);


    /**
     * 查询教室时长分析列表
     *
     * @param eqDatamanage 时长分析
     * @return 时长分析集合
     */
    public List<EqDatamanage> selectEqUDataNameTimeList(EqDatamanage eqDatamanage);

    /**
     * 查询楼栋时长分析列表
     *
     * @param eqDatamanage 时长分析
     * @return 时长分析集合
     */
    public List<EqDatamanage> selectEqUDataLocationList(EqDatamanage eqDatamanage);
}


