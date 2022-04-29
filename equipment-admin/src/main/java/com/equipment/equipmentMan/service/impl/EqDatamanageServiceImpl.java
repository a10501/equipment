package com.equipment.equipmentMan.service.impl;

import com.equipment.common.exception.ServiceException;
import com.equipment.common.utils.StringUtils;
import com.equipment.equipmentMan.domain.EqDatamanage;
import com.equipment.equipmentMan.mapper.EqDatamanageMapper;
import com.equipment.equipmentMan.service.IEqDatamanageService;
import com.equipment.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 多媒体教室数据分析Service业务层处理
 * 
 * @author cdy
 * @date 2022-04-08
 */
@Service
public class EqDatamanageServiceImpl implements IEqDatamanageService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private EqDatamanageMapper eqDatamanageMapper;


    /**
     * 查询多媒体教室数据分析
     *
     * @param id 多媒体教室数据分析主键
     * @return 多媒体教室数据分析
     */
    @Override
    public EqDatamanage selectEqDatamanageById(Long id) {
        return eqDatamanageMapper.selectEqDatamanageById(id);
    }

    /**
     * 查询多媒体教室数据分析列表
     *
     * @param eqDatamanage 多媒体教室数据分析
     * @return 多媒体教室数据分析
     */
    @Override
    public List<EqDatamanage> selectEqDatamanageList(EqDatamanage eqDatamanage) {
        return eqDatamanageMapper.selectEqDatamanageList(eqDatamanage);
    }

    /**
     * 新增多媒体教室数据分析
     *
     * @param eqDatamanage 多媒体教室数据分析
     * @return 结果
     */
    @Override
    public int insertEqDatamanage(EqDatamanage eqDatamanage) {
        return eqDatamanageMapper.insertEqDatamanage(eqDatamanage);
    }

    /**
     * 修改多媒体教室数据分析
     *
     * @param eqDatamanage 多媒体教室数据分析
     * @return 结果
     */
    @Override
    public int updateEqDatamanage(EqDatamanage eqDatamanage) {
        return eqDatamanageMapper.updateEqDatamanage(eqDatamanage);
    }

    /**
     * 批量删除多媒体教室数据分析
     *
     * @param ids 需要删除的多媒体教室数据分析主键
     * @return 结果
     */
    @Override
    public int deleteEqDatamanageByIds(Long[] ids) {
        return eqDatamanageMapper.deleteEqDatamanageByIds(ids);
    }

    /**
     * 删除多媒体教室数据分析信息
     *
     * @param id 多媒体教室数据分析主键
     * @return 结果
     */
    @Override
    public int deleteEqDatamanageById(Long id) {
        return eqDatamanageMapper.deleteEqDatamanageById(id);
    }

    @Override
    public String importDataManage(List<EqDatamanage> datamanageList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(datamanageList) || datamanageList.size() == 0) {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (EqDatamanage datamanage : datamanageList) {
            try {

                    this.insertEqDatamanage(datamanage);
                    successNum++;

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum +  " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + "条" );
        }
        return successMsg.toString();
    }
}

