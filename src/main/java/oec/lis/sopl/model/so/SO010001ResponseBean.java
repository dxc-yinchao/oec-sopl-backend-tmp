package oec.lis.sopl.model.so;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SO010001ResponseBean {
    
    @ApiModelProperty(value = "Shipment No")
    private String shipmentNo;

    @ApiModelProperty(value = "HBL No")
    private String hblNo;

    @ApiModelProperty(value = "status (Booking Received | Booking Processing | Wait for Confirmation | Consignee Confirmed | Rejected | Canceled)")
    private String status;

    @ApiModelProperty(value = "Consol No")
    private String consolNo;

    @ApiModelProperty(value = "MBL No")
    private String mblNo;

    @ApiModelProperty(value = "Origin Code")
    private String origin;

    @ApiModelProperty(value = "Origin Name")
    private String originName;

    @ApiModelProperty(value = "Destination Code")
    private String destination;

    @ApiModelProperty(value = "Destination Name")
    private String destinationName;

    @ApiModelProperty(value = "Shipper Organization Code")
    private String shipper; //

    @ApiModelProperty(value = "Shipper Name")
    private String shipperName; //

    @ApiModelProperty(value = "Consignee Organization Code")
    private String consignee; //

    @ApiModelProperty(value = "Consignee Organization Name")
    private String consigneeName; //

    @ApiModelProperty(value = "Delivery Agent")
    private String deliveryAgent;

    @ApiModelProperty(value = "Control agent organization code")
    private String controllingAgent; //

    @ApiModelProperty(value = "Control agent name")
    private String controllingAgentName; //

    @ApiModelProperty(value = "Carrier organization code")
    private String carieer;

    @ApiModelProperty(value = "Cargo type")
    private String cargoType; //

    @ApiModelProperty(value = "Sales full name")
    private String sales;

    @ApiModelProperty(value = "ETD, estimated time of departure")
    private String etd;

    @ApiModelProperty(value = "Service contract")
    private String serviceContract; //
}
