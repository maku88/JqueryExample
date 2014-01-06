package pl.net.nowak.jquery.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 04.01.14
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonAutoDetect
public class Device implements Serializable{

    public enum DeviceType {
        PUBLIC,
        PRIVATE
    }

    private long id;
    private String name;
    private String description;

    private String creationDate;
    private String expireDate;
    private DeviceType type;


}
