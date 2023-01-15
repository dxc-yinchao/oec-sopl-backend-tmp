package oec.lis.sopl.common.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MasterDataRequestBean implements Serializable {

    @ApiModelProperty(value = "Field name for querying single value list, allow (hboNo, mblNo, shipmentNo, consolNo)", allowEmptyValue = false)
    private String fieldName;

}