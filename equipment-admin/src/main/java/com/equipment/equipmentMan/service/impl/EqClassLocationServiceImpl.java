package com.equipment.equipmentMan.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.equipment.common.config.EquipmentConfig;
import com.equipment.common.constant.Constants;
import com.equipment.common.core.domain.entity.SysUser;
import com.equipment.common.exception.ServiceException;
import com.equipment.common.utils.SecurityUtils;
import com.equipment.common.utils.StringUtils;
import com.equipment.common.utils.bean.BeanValidators;
import com.equipment.common.utils.file.FileUploadUtils;
import com.equipment.common.utils.file.FileUtils;
import com.equipment.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.equipment.equipmentMan.mapper.EqClassLocationMapper;
import com.equipment.equipmentMan.domain.EqClassLocation;
import com.equipment.equipmentMan.service.IEqClassLocationService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多媒体分布信息Service业务层处理
 * 
 * @author cdy
 * @date 2022-04-06
 */
@Service
public class EqClassLocationServiceImpl implements IEqClassLocationService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private EqClassLocationMapper eqClassLocationMapper;

    /**
     * 查询多媒体分布信息
     *
     * @param id 多媒体分布信息主键
     * @return 多媒体分布信息
     */
    @Override
    public EqClassLocation selectEqClassLocationById(Long id) {
        return eqClassLocationMapper.selectEqClassLocationById(id);
    }

    /**
     * 查询多媒体分布信息
     *
     * @param location 多媒体分布信息主键
     * @return 多媒体分布信息
     */
    @Override
    public EqClassLocation selectEqClassLocationByLocation(String location) {
        return eqClassLocationMapper.selectEqClassLocationByLocation(location);
    }

    /**
     * 查询多媒体分布信息列表
     *
     * @param eqClassLocation 多媒体分布信息
     * @return 多媒体分布信息
     */
    @Override
    public List<EqClassLocation> selectEqClassLocationList(EqClassLocation eqClassLocation) {
        return eqClassLocationMapper.selectEqClassLocationList(eqClassLocation);
    }

    /**
     * 新增多媒体分布信息
     *
     * @param eqClassLocation 多媒体分布信息
     * @return 结果
     */
    @Override
    public int insertEqClassLocation(EqClassLocation eqClassLocation) {
        return eqClassLocationMapper.insertEqClassLocation(eqClassLocation);
    }

    /**
     * 修改多媒体分布信息
     *
     * @param eqClassLocation 多媒体分布信息
     * @return 结果
     */
    @Override
    public int updateEqClassLocation(EqClassLocation eqClassLocation) {
        return eqClassLocationMapper.updateEqClassLocation(eqClassLocation);
    }

    /**
     * 批量删除多媒体分布信息
     *
     * @param ids 需要删除的多媒体分布信息主键
     * @return 结果
     */
    @Override
    public int deleteEqClassLocationByIds(Long[] ids) {
        return eqClassLocationMapper.deleteEqClassLocationByIds(ids);
    }

    /**
     * 删除多媒体分布信息信息
     *
     * @param id 多媒体分布信息主键
     * @return 结果
     */
    @Override
    public int deleteEqClassLocationById(Long id) {
        return eqClassLocationMapper.deleteEqClassLocationById(id);
    }

    /**
     * 导入多媒体教室分布数据
     *
     * @param locationList    用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importUser(List<EqClassLocation> locationList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(locationList) || locationList.size() == 0) {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (EqClassLocation location : locationList) {
            try {
                // 验证是否存在这条记录
                EqClassLocation lo = eqClassLocationMapper.selectEqClassLocationByLocation(location.getLocation());
                if (StringUtils.isNull(lo)) {
                    this.insertEqClassLocation(location);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、所在楼栋 " + location.getLocation() + " 导入成功");
                } else if (isUpdateSupport) {

                    this.updateEqClassLocation(location);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、所在楼栋 " + location.getLocation() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、所在楼栋 " + location.getLocation() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、所在楼栋 " + location.getLocation() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * 上传文件
     *
     * @param  file
     * @return 新文件名
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        // 获取上传文件路径
        String filePath = EquipmentConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        return fileName;
    }

    @Override
    public void downloadFile(long id, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EqClassLocation location = new EqClassLocation();
        location = eqClassLocationMapper.selectEqClassLocationById(id);
        String path = location.getUseDownload();
        String realFileName = location.getPersonCharg();

        if (StringUtils.isEmpty(realFileName))
        {
            throw new NullPointerException("文件名称无效");
        }
        if (!FileUtils.checkAllowDownload(path)) {
            throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", id));
        }
        // 本地资源路径
        String localPath = EquipmentConfig.getProfile();
        // 数据资源地址
        String downloadPath = localPath + StringUtils.substringAfter(path, Constants.RESOURCE_PREFIX);
        File file = new File(downloadPath);
        if(!file.exists()){
            location.setUseDownload("");
            eqClassLocationMapper.updateEqClassLocation(location);
            throw new FileNotFoundException("文件不存在或已被删除！");
        }
        // 下载名称
        String downloadName = realFileName + downloadPath.substring(downloadPath.lastIndexOf("."));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        FileUtils.setAttachmentResponseHeader(response, downloadName);
        FileUtils.writeBytes(downloadPath, response.getOutputStream());

    }
}

