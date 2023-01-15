package oec.lis.sopl.common.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MasterCodeTableRequestBean implements Serializable {

    @ApiModelProperty(value = "Field name for querying single value list, allow (status | origin | destination | shipper | consignee | agent | carieer | staff | cargoType)", allowEmptyValue = false, required = true)
    private String fieldName;

}