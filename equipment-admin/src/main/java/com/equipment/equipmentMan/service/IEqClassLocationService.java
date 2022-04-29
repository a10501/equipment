package com.equipment.equipmentMan.service;

import java.util.List;

import com.equipment.equipmentMan.domain.EqClassLocation;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多媒体分布信息Service接口
 * 
 * @author cdy
 * @date 2022-04-06
 */
public interface IEqClassLocationService 
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
     * 批量删除多媒体分布信息
     * 
     * @param ids 需要删除的多媒体分布信息主键集合
     * @return 结果
     */
    public int deleteEqClassLocationByIds(Long[] ids);

    /**
     * 删除多媒体分布信息信息
     * 
     * @param id 多媒体分布信息主键
     * @return 结果
     */
    public int deleteEqClassLocationById(Long id);

    /**
     * 导入数据
     *
     * @param locationList 设备使用数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importUser(List<EqClassLocation> locationList, Boolean isUpdateSupport);

    /**
     * 上传文件
     *
     * @param  file
     * @return 新文件名
     */
    public String uploadFile(MultipartFile file) throws Exception;

    /**
     * 下载文件
     *
     * @param
     * @return 新文件名
     */
    public void downloadFile(long id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
