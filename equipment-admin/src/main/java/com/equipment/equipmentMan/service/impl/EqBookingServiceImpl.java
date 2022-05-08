package com.equipment.equipmentMan.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.equipment.common.core.domain.entity.SysUser;
import com.equipment.common.core.domain.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqBookingMapper;
import com.equipment.equipmentMan.domain.EqBooking;
import com.equipment.equipmentMan.service.IEqBookingService;

/**
 * 预约信息Service业务层处理
 * 
 * @author cdy
 * @date 2022-05-05
 */
@Service
public class EqBookingServiceImpl implements IEqBookingService 
{
    @Autowired
    private EqBookingMapper eqBookingMapper;

    /**
     * 查询预约信息
     * 
     * @param id 预约信息主键
     * @return 预约信息
     */
    @Override
    public EqBooking selectEqBookingById(Long id)
    {
        return eqBookingMapper.selectEqBookingById(id);
    }

    /**
     * 查询预约信息列表
     * 
     * @param eqBooking 预约信息
     * @return 预约信息
     */
    @Override
    public List<EqBooking> selectEqBookingList(EqBooking eqBooking)
    {
        return eqBookingMapper.selectEqBookingList(eqBooking);
    }

    /**
     * 查询个人预约信息
     *
     * @param eqBooking
     * @return 预约信息
     */
    public List<EqBooking> selectEqBookingMyself(EqBooking eqBooking){
        return eqBookingMapper.selectEqBookingMyself(eqBooking);
    }



    /**
     * 新增预约信息
     * 
     * @param eqBooking 预约信息
     * @return 结果
     */
    @Override
    public int insertEqBooking(EqBooking eqBooking)
    {
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMddHHmmss");
        String bookingNo =  matter1.format(dt);
        eqBooking.setBookingName(bookingNo);
        return eqBookingMapper.insertEqBooking(eqBooking);
    }

    /**
     * 修改预约信息
     * 
     * @param eqBooking 预约信息
     * @return 结果
     */
    @Override
    public int updateEqBooking(EqBooking eqBooking)
    {
        return eqBookingMapper.updateEqBooking(eqBooking);
    }

    /**
     * 批量删除预约信息
     * 
     * @param ids 需要删除的预约信息主键
     * @return 结果
     */
    @Override
    public int deleteEqBookingByIds(Long[] ids)
    {
        return eqBookingMapper.deleteEqBookingByIds(ids);
    }

    /**
     * 删除预约信息信息
     * 
     * @param id 预约信息主键
     * @return 结果
     */
    @Override
    public int deleteEqBookingById(Long id)
    {
        return eqBookingMapper.deleteEqBookingById(id);
    }
}
