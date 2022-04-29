package com.equipment.equipmentMan.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.equipment.equipmentMan.domain.EqDatamanage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.equipment.common.annotation.Log;
import com.equipment.common.core.controller.BaseController;
import com.equipment.common.core.domain.AjaxResult;
import com.equipment.common.enums.BusinessType;
import com.equipment.equipmentMan.service.IEqUseTimeService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 时长分析Controller
 * 
 * @author cdy
 * @date 2022-04-09
 */
@RestController
@RequestMapping("/equipmentMan/usetime")
public class EqUseTimeController extends BaseController
{
    @Autowired
    private IEqUseTimeService eqUseTimeService;

    /**
     * 查询用户时长分析列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:usetime:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqDatamanage eqDatamanage,String flag)
    {
        List<EqDatamanage> list = new ArrayList<>();
        System.out.println(flag);
        startPage();
        if(flag.equals("1")){
            list = eqUseTimeService.selectEqUseTimeList(eqDatamanage);
        }else if(flag.equals("2")){
            list = eqUseTimeService.selectEqUDataNameTimeList(eqDatamanage);
        }else  {
            list = eqUseTimeService.selectEqUDataLocationList(eqDatamanage);

        }

        return getDataTable(list);
    }

    /**
     * 导出时长分析列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:usetime:export')")
    @Log(title = "时长分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqDatamanage eqDatamanage,String flag)
    {
        List<EqDatamanage> list = new ArrayList<>();
        if(flag.equals("1")){
            list = eqUseTimeService.selectEqUseTimeList(eqDatamanage);
        }else if(flag.equals("2")){
            list = eqUseTimeService.selectEqUDataNameTimeList(eqDatamanage);
        }else  {
            list = eqUseTimeService.selectEqUDataLocationList(eqDatamanage);
        }
        ExcelUtil<EqDatamanage> util = new ExcelUtil<EqDatamanage>(EqDatamanage.class);
        util.exportExcel(response, list, "时长分析数据");
    }


}
