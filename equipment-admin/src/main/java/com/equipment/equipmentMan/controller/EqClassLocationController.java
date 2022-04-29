package com.equipment.equipmentMan.controller;

import com.equipment.common.annotation.Log;
import com.equipment.common.core.controller.BaseController;
import com.equipment.common.core.domain.AjaxResult;
import com.equipment.common.core.page.TableDataInfo;
import com.equipment.common.enums.BusinessType;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.equipmentMan.domain.EqClassLocation;
import com.equipment.equipmentMan.service.IEqClassLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 多媒体分布信息Controller
 * 
 * @author cdy
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/equipmentMan/location")
public class EqClassLocationController extends BaseController
{
    @Autowired
    private IEqClassLocationService eqClassLocationService;

    /**
     * 查询多媒体分布信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqClassLocation eqClassLocation)
    {
        startPage();
        List<EqClassLocation> list = eqClassLocationService.selectEqClassLocationList(eqClassLocation);
        return getDataTable(list);
    }

    /**
     * 导出多媒体分布信息列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:export')")
    @Log(title = "多媒体分布信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqClassLocation eqClassLocation)
    {
        List<EqClassLocation> list = eqClassLocationService.selectEqClassLocationList(eqClassLocation);
        ExcelUtil<EqClassLocation> util = new ExcelUtil<EqClassLocation>(EqClassLocation.class);
        util.exportExcel(response, list, "多媒体分布信息数据");
    }

    /**
     * 获取多媒体分布信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eqClassLocationService.selectEqClassLocationById(id));
    }

    /**
     * 新增多媒体分布信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:add')")
    @Log(title = "多媒体分布信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestParam(value="file",required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        EqClassLocation location = new EqClassLocation();
        AjaxResult ajaxResult = new AjaxResult();
        String useDownload = request.getParameter("useDownload");
        try {
            String fileName = eqClassLocationService.uploadFile(file);
            if(!file.isEmpty() && !"null".equals(file) && "null".equals(request.getParameter("useDownload")) ) {
                location.setLocation(request.getParameter("location"));
                location.setLocationClass(request.getParameter("locationClass"));
                location.setEqNumber(Long.valueOf(request.getParameter("eqNumber")));
                location.setPersonCharg(request.getParameter("personCharg"));
                location.setPersonPhone(request.getParameter("personPhone"));
                location.setUseDownload(fileName);
                ajaxResult = toAjax(eqClassLocationService.insertEqClassLocation(location));
            }else {
                Long id = Long.valueOf(request.getParameter("id"));
                location.setId(id);
                location.setLocation(request.getParameter("location"));
                location.setLocationClass(request.getParameter("locationClass"));
                location.setEqNumber(Long.valueOf(request.getParameter("eqNumber")));
                location.setPersonCharg(request.getParameter("personCharg"));
                location.setPersonPhone(request.getParameter("personPhone"));
                location.setUseDownload(fileName);
                ajaxResult = toAjax(eqClassLocationService.updateEqClassLocation(location));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }


    /**
     *下载文件
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:downloadFile')")
    @PostMapping(value = "/downloadFile/{id}")
    public void downloadFile(@PathVariable long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        eqClassLocationService.downloadFile(id,request,response);
    }

    /**
     * 修改多媒体分布信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:edit')")
    @Log(title = "多媒体分布信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit( EqClassLocation eqClassLocation,HttpServletRequest request)
    {
        return toAjax(eqClassLocationService.updateEqClassLocation(eqClassLocation));
    }

    /**
     * 删除多媒体分布信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:remove')")
    @Log(title = "多媒体分布信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqClassLocationService.deleteEqClassLocationByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<EqClassLocation> util = new ExcelUtil<EqClassLocation>(EqClassLocation.class);
        util.importTemplateExcel(response, "多媒体教室分布数据");
    }

    @Log(title = "多媒体教室分布管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('equipmentMan:location:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EqClassLocation> util = new ExcelUtil<EqClassLocation>(EqClassLocation.class);
        List<EqClassLocation> locationList = util.importExcel(file.getInputStream());
        String message = eqClassLocationService.importUser(locationList, updateSupport);
        return AjaxResult.success(message);
    }
}
