package com.equipment.equipmentMan.mapper;

import java.util.List;
import com.equipment.equipmentMan.domain.EqClassLocation;

/**
 * 多媒体分布信息Mapper接口
 * 
 * @author cdy
 * @date 2022-04-06
 */
public interface EqClassLocationMapper 
{
    /**
     * 查询多媒体分布信息
     * 
     * @param id 多媒体分布信息主键
     * @return 多媒体分布信息
     */
    public EqClassLocation selectEqClassLocationById(Long id);

    /**
     * 查询多媒体分布信息
     *
     * @param location 多媒体分布信息主键
     * @return 多媒体分布信息
     */
    public EqClassLocation selectEqClassLocationByLocation(String location);

    /**
     * 查询多媒体分布信息列表
     * 
     * @param eqClassLocation 多媒体分布信息
     * @return 多媒体分布信息集合
     */
    public List<EqClassLocation> selectEqClassLocationList(EqClassLocation eqClassLocation);

    /**
     * 新增多媒体分布信息
     * 
     * @param eqClassLocation 多媒体分布信息
     * @return 结果
     */
    public int insertEqClassLocation(EqClassLocation eqClassLocation);

    /**
     * 修改多媒体分布信息
     * 
     * @param eqClassLocation 多媒体分布信息
     * @return 结果
     */
    public int updateEqClassLocation(EqClassLocation eqClassLocation);

    /**
     * 删除多媒体分布信息
     * 
     * @param id 多媒体分布信息主键
     * @return 结果
     */
    public int deleteEqClassLocationById(Long id);

    /**
     * 批量删除多媒体分布信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqClassLocationByIds(Long[] ids);

}
