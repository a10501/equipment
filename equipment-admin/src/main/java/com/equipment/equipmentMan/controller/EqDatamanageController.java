package com.equipment.equipmentMan.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.equipment.equipmentMan.domain.EqClassLocation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.equipment.common.annotation.Log;
import com.equipment.common.core.controller.BaseController;
import com.equipment.common.core.domain.AjaxResult;
import com.equipment.common.enums.BusinessType;
import com.equipment.equipmentMan.domain.EqDatamanage;
import com.equipment.equipmentMan.service.IEqDatamanageService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 多媒体教室数据分析Controller
 * 
 * @author cdy
 * @date 2022-04-08
 */
@RestController
@RequestMapping("/equipmentMan/datamanage")
public class EqDatamanageController extends BaseController
{
    @Autowired
    private IEqDatamanageService eqDatamanageService;

    /**
     * 查询多媒体教室数据分析列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqDatamanage eqDatamanage)
    {
        startPage();
        List<EqDatamanage> list = eqDatamanageService.selectEqDatamanageList(eqDatamanage);
        return getDataTable(list);
    }

    /**
     * 导出多媒体教室数据分析列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:export')")
    @Log(title = "多媒体教室数据分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqDatamanage eqDatamanage)
    {
        List<EqDatamanage> list = eqDatamanageService.selectEqDatamanageList(eqDatamanage);
        ExcelUtil<EqDatamanage> util = new ExcelUtil<EqDatamanage>(EqDatamanage.class);
        util.exportExcel(response, list, "多媒体教室数据分析数据");
    }

    /**
     * 获取多媒体教室数据分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqDatamanageService.selectEqDatamanageById(id));
    }

    /**
     * 新增多媒体教室数据分析
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:add')")
    @Log(title = "多媒体教室数据分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqDatamanage eqDatamanage)
    {
        return toAjax(eqDatamanageService.insertEqDatamanage(eqDatamanage));
    }

    /**
     * 修改多媒体教室数据分析
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:edit')")
    @Log(title = "多媒体教室数据分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqDatamanage eqDatamanage)
    {
        return toAjax(eqDatamanageService.updateEqDatamanage(eqDatamanage));
    }

    /**
     * 删除多媒体教室数据分析
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:remove')")
    @Log(title = "多媒体教室数据分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqDatamanageService.deleteEqDatamanageByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<EqDatamanage> util = new ExcelUtil<EqDatamanage>(EqDatamanage.class);
        util.importTemplateExcel(response, "多媒体教室数据分析");
    }

    @Log(title = "多媒体教室数据分析", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('equipmentMan:datamanage:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EqDatamanage> util = new ExcelUtil<EqDatamanage>(EqDatamanage.class);
        List<EqDatamanage> datamanageList = util.importExcel(file.getInputStream());
        String message = eqDatamanageService.importDataManage(datamanageList,updateSupport);
        return AjaxResult.success(message);
    }

}
