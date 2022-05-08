package com.equipment.equipmentMan.mapper;

import java.util.List;
import com.equipment.equipmentMan.domain.EqBooking;

/**
 * 预约信息Mapper接口
 * 
 * @author cdy
 * @date 2022-05-05
 */
public interface EqBookingMapper 
{
    /**
     * 查询预约信息
     * 
     * @param id 预约信息主键
     * @return 预约信息
     */
    public EqBooking selectEqBookingById(Long id);

    /**
     * 查询个人预约信息
     *
     * @param eqBooking
     * @return 预约信息
     */
    public List<EqBooking> selectEqBookingMyself(EqBooking eqBooking);

    /**
     * 查询预约信息列表
     * 
     * @param eqBooking 预约信息
     * @return 预约信息集合
     */
    public List<EqBooking> selectEqBookingList(EqBooking eqBooking);

    /**
     * 新增预约信息
     * 
     * @param eqBooking 预约信息
     * @return 结果
     */
    public int insertEqBooking(EqBooking eqBooking);

    /**
     * 修改预约信息
     * 
     * @param eqBooking 预约信息
     * @return 结果
     */
    public int updateEqBooking(EqBooking eqBooking);

    /**
     * 删除预约信息
     * 
     * @param id 预约信息主键
     * @return 结果
     */
    public int deleteEqBookingById(Long id);

    /**
     * 批量删除预约信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqBookingByIds(Long[] ids);
}
