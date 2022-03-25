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
import com.equipment.equipmentMan.domain.EqClassroomTest;
import com.equipment.equipmentMan.service.IEqClassroomTestService;
import com.equipment.common.utils.poi.ExcelUtil;

/**
 * 教室信息测试Controller
 * 
 * @author cdy
 * @date 2022-03-23
 */
@RestController
@RequestMapping("/equipmentMan/classroomTest")
public class EqClassroomTestController extends BaseController
{
    @Autowired
    private IEqClassroomTestService eqClassroomTestService;

    /**
     * 查询教室信息测试列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroomTest:list')")
    @GetMapping("/list")
    public AjaxResult list(EqClassroomTest eqClassroomTest)
    {
        List<EqClassroomTest> list = eqClassroomTestService.selectEqClassroomTestList(eqClassroomTest);
        return AjaxResult.success(list);
    }

    /**
     * 导出教室信息测试列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroomTest:export')")
    @Log(title = "教室信息测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqClassroomTest eqClassroomTest)
    {
        List<EqClassroomTest> list = eqClassroomTestService.selectEqClassroomTestList(eqClassroomTest);
        ExcelUtil<EqClassroomTest> util = new ExcelUtil<EqClassroomTest>(EqClassroomTest.class);
        util.exportExcel(response, list, "教室信息测试数据");
    }

    /**
     * 获取教室信息测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroomTest:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqClassroomTestService.selectEqClassroomTestById(id));
    }

    /**
     * 新增教室信息测试
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroomTest:add')")
    @Log(title = "教室信息测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqClassroomTest eqClassroomTest)
    {
        return toAjax(eqClassroomTestService.insertEqClassroomTest(eqClassroomTest));
    }

    /**
     * 修改教室信息测试
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroomTest:edit')")
    @Log(title = "教室信息测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqClassroomTest eqClassroomTest)
    {
        return toAjax(eqClassroomTestService.updateEqClassroomTest(eqClassroomTest));
    }

    /**
     * 删除教室信息测试
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:classroomTest:remove')")
    @Log(title = "教室信息测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqClassroomTestService.deleteEqClassroomTestByIds(ids));
    }
}
