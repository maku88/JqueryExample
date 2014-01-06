package pl.net.nowak.jquery.spring;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class DeviceService {

    private List<Device> list ;

    public DeviceService() {

        list = new ArrayList<Device>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        for(int i =0; i< 10; i++) {

            String date = sdf.format(new Date());

            list.add(new Device(i,"Device " + i, "Descr " +i, date, date, Device.DeviceType.PRIVATE));
        }
    }



    public int getDeviceCount() {
        return list.size();
    }

    public List<Device> listDevices(int jtStartIndex, int jtPageSize) {
        return list;

    }

    public List<DeviceTypeOptions> getDeviceTypes() {
        List<DeviceTypeOptions> list = new ArrayList<DeviceTypeOptions>();
        list.add(new DeviceTypeOptions("Public", Device.DeviceType.PUBLIC.toString()));
        list.add(new DeviceTypeOptions("Private", Device.DeviceType.PRIVATE.toString()));

        return list;
    }

    public void addDevice(Device expenseBean) {
        System.out.println("DODAJE !! " + expenseBean.toString());
        list.add(expenseBean);
    }

    public void updateDevice(Device expenseBean) {
        System.out.println("UPDATE !! " + expenseBean.toString());

    }

    public void removeDevice(Long aLong) {
        System.out.println("DELETE !! " + aLong);
    }
}
