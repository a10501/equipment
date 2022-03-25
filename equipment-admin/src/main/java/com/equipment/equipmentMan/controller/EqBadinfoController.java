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
import com.equipment.equipmentMan.domain.EqBadinfo;
import com.equipment.equipmentMan.service.IEqBadinfoService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 设备报修信息Controller
 * 
 * @author cdy
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/equipmentMan/badinfo")
public class EqBadinfoController extends BaseController
{
    @Autowired
    private IEqBadinfoService eqBadinfoService;

    /**
     * 查询设备报修信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqBadinfo eqBadinfo)
    {
        startPage();
        List<EqBadinfo> list = eqBadinfoService.selectEqBadinfoList(eqBadinfo);
        return getDataTable(list);
    }

    /**
     * 导出设备报修信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badinfo:export')")
    @Log(title = "设备报修信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqBadinfo eqBadinfo)
    {
        List<EqBadinfo> list = eqBadinfoService.selectEqBadinfoList(eqBadinfo);
        ExcelUtil<EqBadinfo> util = new ExcelUtil<EqBadinfo>(EqBadinfo.class);
        util.exportExcel(response, list, "设备报修信息数据");
    }

    /**
     * 获取设备报修信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqBadinfoService.selectEqBadinfoById(id));
    }

    /**
     * 新增设备报修信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badinfo:add')")
    @Log(title = "设备报修信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqBadinfo eqBadinfo)
    {
        return toAjax(eqBadinfoService.insertEqBadinfo(eqBadinfo));
    }

    /**
     * 修改设备报修信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badinfo:edit')")
    @Log(title = "设备报修信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqBadinfo eqBadinfo)
    {
        return toAjax(eqBadinfoService.updateEqBadinfo(eqBadinfo));
    }

    /**
     * 删除设备报修信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badinfo:remove')")
    @Log(title = "设备报修信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqBadinfoService.deleteEqBadinfoByIds(ids));
    }
}
