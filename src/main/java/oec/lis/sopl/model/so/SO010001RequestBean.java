package oec.lis.sopl.model.so;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SO010001RequestBean implements Serializable {

    @ApiModelProperty(value = "hbl no", allowEmptyValue = true)
    private String hblNo;

    @ApiModelProperty(value = "mbl no", allowEmptyValue = true)
    private String mblNo;

    @ApiModelProperty(value = "shipment no", allowEmptyValue = true)
    private String shipmentNo;

    @ApiModelProperty(value = "consol no", allowEmptyValue = true)
    private String consolNo;

    @ApiModelProperty(value = "status (Booking Received | Booking Processing | Wait for Confirmation | Consignee Confirmed | Rejected | Canceled)", allowEmptyValue = true)
    private String status;

    @ApiModelProperty(value = "origin", allowEmptyValue = true)
    private String origin;

    @ApiModelProperty(value = "destination", allowEmptyValue = true)
    private String destination;

    @ApiModelProperty(value = "shipper organization ID", allowEmptyValue = true)
    private String shipperOrgId;

    @ApiModelProperty(value = "consignee organization ID", allowEmptyValue = true)
    private String consigneeOrgId;

    @ApiModelProperty(value = "agent organization ID", allowEmptyValue = true)
    private String agentOrgId;

    @ApiModelProperty(value = "carieer organization ID", allowEmptyValue = true)
    private String carieerOrgId;

    @ApiModelProperty(value = "sales staff ID", allowEmptyValue = true)
    private String salesId;

    @ApiModelProperty(value = "ETD (Estimated Time Depart", allowEmptyValue = true)
    private String etd;

    @ApiModelProperty(value = "cargo type (Local | Routine | Mutual | Coload | Volume Non-calculated)", allowEmptyValue = true)
    private String cargoType;
    
}
