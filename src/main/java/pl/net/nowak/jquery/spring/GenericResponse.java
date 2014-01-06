package pl.net.nowak.jquery.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> implements Serializable {

    @JsonProperty("Result")
    private String Result;

    @JsonProperty("Record")
    private T Records;

    @JsonProperty("Message")
    private String Message;

}


