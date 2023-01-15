package oec.lis.sopl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MasterDataResponseBean implements Serializable {
    
    @ApiModelProperty(value = "The field name for returned value(s).")
    private String fieldName;

    @ApiModelProperty(value = "The field name for returned value(s).")
    private List<String> data = new ArrayList<>();
}
