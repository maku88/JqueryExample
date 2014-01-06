package pl.net.nowak.jquery.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/devices")
public class DeviceController {

    private DeviceService deviceService = new DeviceService();



    @RequestMapping(value = "/datatable", method = RequestMethod.GET)
    public String show(ModelMap model) {
        return "devices";
    }

    /*Table data load - This loads the data for the table*/
    @RequestMapping(value = "/datatable/getAllDevices", method = RequestMethod.POST)
    @ResponseBody
    public GenericListResponse<Device> getAllExpenses(@RequestParam int jtStartIndex, @RequestParam int jtPageSize) {
        GenericListResponse<Device> jstr;
        List<Device> expList;
        try {
            int expenseCount = deviceService.getDeviceCount();
            expList = deviceService.listDevices(jtStartIndex, jtPageSize);
            jstr = new GenericListResponse<Device>("OK",expList,expenseCount);
        } catch (Exception e) {
            e.printStackTrace();
            jstr = new GenericListResponse<Device>("ERROR",e.getMessage());
        }
        return jstr;
    }

    /*Cascaded drop down part one - loads the categories*/
    @RequestMapping(value = "/datatable/types", method = RequestMethod.POST)
    public @ResponseBody GenericOptionsResponse<DeviceTypeOptions> getDeviceTypes() {
        GenericOptionsResponse<DeviceTypeOptions> jstr;
        List<DeviceTypeOptions> categories;
        try {
            categories = deviceService.getDeviceTypes();
            jstr = new GenericOptionsResponse<DeviceTypeOptions>("OK",categories );
        } catch (Exception e) {
            e.printStackTrace();
            jstr = new GenericOptionsResponse<DeviceTypeOptions>("ERROR",e.getMessage());
        }
        return jstr;
    }

    /*CRUD operation - Add the expense */
    @RequestMapping(value = "/datatable/addDevice", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse<Device> insertGroup(@ModelAttribute Device expenseBean, BindingResult result) {
        GenericResponse<Device> jsonJtableResponse;
        if (result.hasErrors()) {
            jsonJtableResponse = new GenericResponse<Device>("ERROR",null, "Form invalid");
        }
        try {
            deviceService.addDevice(expenseBean);
            jsonJtableResponse = new GenericResponse<Device>("OK",expenseBean,"");
        } catch (Exception e) {
            e.printStackTrace();
            jsonJtableResponse = new GenericResponse<Device>("ERROR",null,e.getMessage());
        }
        return jsonJtableResponse;
    }

    /*CRUD operation - Update the expense */
    @RequestMapping(value = "/datatable/updateDevice", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse<Device> updateRole(@ModelAttribute Device expenseBean, BindingResult result) {
        GenericResponse<Device> jsonJtableResponse;
        if (result.hasErrors()) {
            jsonJtableResponse = new GenericResponse<Device>("ERROR",null,"Form invalid");
        }
        try {
            deviceService.updateDevice(expenseBean);
            jsonJtableResponse = new GenericResponse<Device>("OK",expenseBean,"");
        } catch (Exception e) {
            e.printStackTrace();
            jsonJtableResponse = new GenericResponse<Device>("ERROR",null,e.getMessage());
        }
        return jsonJtableResponse;
    }

    /*CRUD operation - Delete the expense */
    @RequestMapping(value = "/datatable/deleteDevice", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse<Device> delete(@RequestParam long id) {
        GenericResponse<Device> jsonJtableResponse;
        try {
            deviceService.removeDevice(id);
            jsonJtableResponse = new GenericResponse<Device>("OK",null,"");
        } catch (Exception e) {
            e.printStackTrace();
            jsonJtableResponse = new GenericResponse<Device>("ERROR",null,e.getMessage());
        }
        return jsonJtableResponse;
    }


}
