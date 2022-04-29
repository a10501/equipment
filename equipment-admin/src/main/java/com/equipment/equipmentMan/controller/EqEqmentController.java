package com.equipment.equipmentMan.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.equipment.common.core.domain.entity.SysUser;
import com.equipment.common.core.domain.model.LoginUser;
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
import com.equipment.equipmentMan.domain.EqEqment;
import com.equipment.equipmentMan.service.IEqEqmentService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 设备信息Controller
 * 
 * @author cdy
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/equipmentMan/eqment")
public class EqEqmentController extends BaseController
{
    @Autowired
    private IEqEqmentService eqEqmentService;

    /**
     * 查询设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:eqment:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqEqment eqEqment)
    {
        startPage();
        List<EqEqment> list = eqEqmentService.selectEqEqmentList(eqEqment);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:eqment:export')")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqEqment eqEqment)
    {
        List<EqEqment> list = eqEqmentService.selectEqEqmentList(eqEqment);
        ExcelUtil<EqEqment> util = new ExcelUtil<EqEqment>(EqEqment.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:eqment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqEqmentService.selectEqEqmentById(id));
    }

    /**
     * 新增设备信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:eqment:add')")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqEqment eqEqment)
    {
        AjaxResult ajaxResult = new AjaxResult();
        int num = eqEqmentService.insertEqEqment(eqEqment);
        if(num == -1){
            ajaxResult.put("msg","已有此设备类型，请勿重复添加！");
            ajaxResult.put("code",500);
            return ajaxResult;
        }else{
            return toAjax(num);
        }
    }

    /**
     * 修改设备信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:eqment:edit')")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqEqment eqEqment)
    {
        return toAjax(eqEqmentService.updateEqEqment(eqEqment));
    }

    /**
     * 删除设备信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:eqment:remove')")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        AjaxResult ajaxResult = new AjaxResult();
        int num = eqEqmentService.deleteEqEqmentByIds(ids);
        if(num == -1){
            ajaxResult.put("msg","非报废设备，不允许删除！");
            ajaxResult.put("code",500);
            return ajaxResult;
        }else{
            return toAjax(num);
        }
    }
}
