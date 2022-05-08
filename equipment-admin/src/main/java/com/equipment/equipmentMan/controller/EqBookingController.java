package com.equipment.equipmentMan.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.equipment.common.core.domain.entity.SysUser;
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
import com.equipment.equipmentMan.domain.EqBooking;
import com.equipment.equipmentMan.service.IEqBookingService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 预约信息Controller
 * 
 * @author cdy
 * @date 2022-05-05
 */
@RestController
@RequestMapping("/equipmentMan/booking")
public class EqBookingController extends BaseController
{
    @Autowired
    private IEqBookingService eqBookingService;

    /**
     * 查询预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqBooking eqBooking)
    {
        startPage();
        List<EqBooking> list = eqBookingService.selectEqBookingList(eqBooking);
        return getDataTable(list);
    }

    /**
     * 查询个人预约信息
     *
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:myself')")
    @GetMapping("/myself")
    public TableDataInfo selectEqBookingMyself(EqBooking eqBooking) {
        startPage();
        eqBooking.setBookingPeo(getUserId());
        List<EqBooking> list = eqBookingService.selectEqBookingMyself(eqBooking);
        return getDataTable(list);
    }



    /**
     * 导出预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:export')")
    @Log(title = "预约信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqBooking eqBooking)
    {
        List<EqBooking> list = eqBookingService.selectEqBookingList(eqBooking);
        ExcelUtil<EqBooking> util = new ExcelUtil<EqBooking>(EqBooking.class);
        util.exportExcel(response, list, "预约信息数据");
    }

    /**
     * 获取预约信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqBookingService.selectEqBookingById(id));
    }

    /**
     * 预约申请信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:add')")
    @Log(title = "预约信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqBooking eqBooking)
    {
        eqBooking.setBookingPeo(getLoginUser().getUserId());
        return toAjax(eqBookingService.insertEqBooking(eqBooking));
    }

    /**
     * 修改预约信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:edit')")
    @Log(title = "预约信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqBooking eqBooking)
    {
        return toAjax(eqBookingService.updateEqBooking(eqBooking));
    }

    /**
     * 删除预约信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:booking:remove')")
    @Log(title = "预约信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqBookingService.deleteEqBookingByIds(ids));
    }
}
