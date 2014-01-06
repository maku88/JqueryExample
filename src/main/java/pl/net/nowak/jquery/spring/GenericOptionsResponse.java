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
public class GenericOptionsResponse<T> implements Serializable {

    @JsonProperty("Result")
    private String result;

    @JsonProperty("Options")
    private List<T> options;


    @JsonProperty("Message")
    private String message;

    public GenericOptionsResponse(String result, List<T> records) {
        this.result = result;
        this.options = records;
    }

    public GenericOptionsResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }

}
