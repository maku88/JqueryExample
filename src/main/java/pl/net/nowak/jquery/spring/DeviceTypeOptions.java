package pl.net.nowak.jquery.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
public class DeviceTypeOptions implements Serializable{

    @JsonProperty("DisplayText")
    private String displayText;
    @JsonProperty("Value")
    private String value;

}
