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
import com.equipment.equipmentMan.domain.EqClassroom;
import com.equipment.equipmentMan.service.IEqClassroomService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 教室信息Controller
 * 
 * @author cdy
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/equipmentMan/classroom")
public class EqClassroomController extends BaseController
{
    @Autowired
    private IEqClassroomService eqClassroomService;

    /**
     * 查询教室信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqClassroom eqClassroom)
    {
        startPage();
        List<EqClassroom> list = eqClassroomService.selectEqClassroomList(eqClassroom);
        return getDataTable(list);
    }

    /**
     * 导出教室信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroom:export')")
    @Log(title = "教室信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqClassroom eqClassroom)
    {
        List<EqClassroom> list = eqClassroomService.selectEqClassroomList(eqClassroom);
        ExcelUtil<EqClassroom> util = new ExcelUtil<EqClassroom>(EqClassroom.class);
        util.exportExcel(response, list, "教室信息数据");
    }

    /**
     * 获取教室信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqClassroomService.selectEqClassroomById(id));
    }

    /**
     * 新增教室信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroom:add')")
    @Log(title = "教室信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqClassroom eqClassroom)
    {
        return toAjax(eqClassroomService.insertEqClassroom(eqClassroom));
    }

    /**
     * 修改教室信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroom:edit')")
    @Log(title = "教室信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqClassroom eqClassroom)
    {
        return toAjax(eqClassroomService.updateEqClassroom(eqClassroom));
    }

    /**
     * 删除教室信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroom:remove')")
    @Log(title = "教室信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        AjaxResult ajaxResult = new AjaxResult();
        int num = eqClassroomService.deleteEqClassroomByIds(ids);
        if(num == -1){
            ajaxResult.put("msg","教室正在使用，不允许删除！");
            ajaxResult.put("code",500);
            return ajaxResult;
        }else if(num == -2){
            ajaxResult.put("msg","存在关联设备，不允许删除！");
            ajaxResult.put("code",500);
            return ajaxResult;
        }else{
            return toAjax(num);
        }

    }
}
