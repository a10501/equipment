package com.equipment.equipmentMan.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.equipment.equipmentMan.domain.EqEqmentClass;
import com.equipment.equipmentMan.service.IEqEqmentClassService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 设备和教室关联Controller
 * 
 * @author cdy
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/equipmentMan/classeqment")
public class EqEqmentClassController extends BaseController
{
    @Autowired
    private IEqEqmentClassService eqEqmentClassService;

    /**
     * 查询设备和教室关联列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classeqment:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqEqmentClass eqEqmentClass)
    {
        startPage();
        List<EqEqmentClass> list = eqEqmentClassService.selectEqEqmentClassList(eqEqmentClass);
        return getDataTable(list);
    }

    /**
     * 导出设备和教室关联列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classeqment:export')")
    @Log(title = "设备和教室关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqEqmentClass eqEqmentClass)
    {
        List<EqEqmentClass> list = eqEqmentClassService.selectEqEqmentClassList(eqEqmentClass);
        ExcelUtil<EqEqmentClass> util = new ExcelUtil<EqEqmentClass>(EqEqmentClass.class);
        util.exportExcel(response, list, "设备和教室关联数据");
    }

    /**
     * 获取设备和教室关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classeqment:query')")
    @GetMapping(value = "/{eqmentId}")
    public AjaxResult getInfo(@PathVariable("eqmentId") Long eqmentId)
    {
        return AjaxResult.success(eqEqmentClassService.selectEqEqmentClassByEqmentId(eqmentId));
    }

    /**
     * 新增设备和教室关联
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classeqment:add')")
    @Log(title = "设备和教室关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqEqmentClass eqEqmentClass)
    {
        return toAjax(eqEqmentClassService.insertEqEqmentClass(eqEqmentClass));
    }

    /**
     * 修改设备和教室关联
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classeqment:edit')")
    @Log(title = "设备和教室关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqEqmentClass eqEqmentClass)
    {
        return toAjax(eqEqmentClassService.updateEqEqmentClass(eqEqmentClass));
    }

    /**
     * 删除设备和教室关联
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classeqment:remove')")
    @Log(title = "设备和教室关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eqmentIds}")
    public AjaxResult remove(@PathVariable Long[] eqmentIds)
    {
        return toAjax(eqEqmentClassService.deleteEqEqmentClassByEqmentIds(eqmentIds));
    }
}
