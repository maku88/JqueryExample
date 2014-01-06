package pl.net.nowak.jquery.spring;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
@Data
public class DeviceListResponse {

    private String result;

    private List<Device> records;

    private int totalRecordCount;

    private String message;

    public DeviceListResponse(String result, List<Device> records,int totalRecordCount) {
        this.result = result;
        this.records = records;
        this.totalRecordCount = totalRecordCount;
    }

    public DeviceListResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }



}
