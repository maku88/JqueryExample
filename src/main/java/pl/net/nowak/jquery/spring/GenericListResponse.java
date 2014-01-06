package pl.net.nowak.jquery.spring;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:45
 */
@Data
public class GenericListResponse<T> implements Serializable {

    @JsonProperty("Result")
    private String result;

    @JsonProperty("Records")
    private List<T> records;

    @JsonProperty("TotalRecordCount")
    private int totalRecordCount;

    @JsonProperty("Message")
    private String message;

    public GenericListResponse(String result, List<T> records, int totalRecordCount) {
        this.result = result;
        this.records = records;
        this.totalRecordCount = totalRecordCount;
    }

    public GenericListResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }

}
