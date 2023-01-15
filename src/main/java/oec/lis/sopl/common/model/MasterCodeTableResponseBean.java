package oec.lis.sopl.common.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MasterCodeTableResponseBean implements Serializable {
    
    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "value")
    private String value;
}
