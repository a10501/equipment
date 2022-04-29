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
import com.equipment.equipmentMan.domain.EqMainteRecord;
import com.equipment.equipmentMan.service.IEqMainteRecordService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 维修信息Controller
 * 
 * @author cdy
 * @date 2022-04-12
 */
@RestController
@RequestMapping("/equipmentMan/badRecord")
public class EqMainteRecordController extends BaseController
{
    @Autowired
    private IEqMainteRecordService eqMainteRecordService;

    /**
     * 查询维修信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqMainteRecord eqMainteRecord)
    {
        startPage();
        List<EqMainteRecord> list = eqMainteRecordService.selectEqMainteRecordList(eqMainteRecord);
        return getDataTable(list);
    }

    /**
     * 导出维修信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badRecord:export')")
    @Log(title = "维修信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqMainteRecord eqMainteRecord)
    {
        List<EqMainteRecord> list = eqMainteRecordService.selectEqMainteRecordList(eqMainteRecord);
        ExcelUtil<EqMainteRecord> util = new ExcelUtil<EqMainteRecord>(EqMainteRecord.class);
        util.exportExcel(response, list, "维修信息数据");
    }

    /**
     * 获取维修信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqMainteRecordService.selectEqMainteRecordById(id));
    }

    /**
     * 新增维修信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badRecord:add')")
    @Log(title = "维修信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqMainteRecord eqMainteRecord)
    {
        return toAjax(eqMainteRecordService.insertEqMainteRecord(eqMainteRecord));
    }

    /**
     * 修改维修信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badRecord:edit')")
    @Log(title = "维修信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqMainteRecord eqMainteRecord)
    {
        return toAjax(eqMainteRecordService.updateEqMainteRecord(eqMainteRecord));
    }

    /**
     * 删除维修信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:badRecord:remove')")
    @Log(title = "维修信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqMainteRecordService.deleteEqMainteRecordByIds(ids));
    }
}
