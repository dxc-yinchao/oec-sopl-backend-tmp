package oec.lis.sopl.model.so;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import oec.lis.sopl.common.util.Misc;
import oec.lis.sopl.model.domain.Shipment;

@Data
@NoArgsConstructor
public class SO010001ResponseBean {

    public SO010001ResponseBean(Shipment shipment) {
        Misc.copyMatchingFields(shipment, this);
    }

    @ApiModelProperty(value = "Shipment No")
    private String shipmentNo;

    @ApiModelProperty(value = "HBL No")
    private String houseBill;

    @ApiModelProperty(value = "status (Booking Received | Booking Processing | Wait for Confirmation | Consignee Confirmed | Rejected | Canceled)")
    private String status;

    @ApiModelProperty(value = "Consol No")
    private String consoleNo;

    @ApiModelProperty(value = "master Billing No")
    private String masterBillNo;

    @ApiModelProperty(value = "Origin Code")
    private String originCode;

    @ApiModelProperty(value = "Origin port name")
    private String originPortName;

    @ApiModelProperty(value = "Destination Code")
    private String destinationCode;

    @ApiModelProperty(value = "Destination port name")
    private String destinationPortName;

    @ApiModelProperty(value = "Shipper Organization Code")
    private String shipperCode;

    @ApiModelProperty(value = "Shipper full name")
    private String shipperFullName;

    @ApiModelProperty(value = "Consignee Organization Code")
    private String consigneeCode;

    @ApiModelProperty(value = "Consignee full name")
    private String consigneeFullName;

    @ApiModelProperty(value = "Delivery agent organization code")
    private String deliveryAgentCode;

    @ApiModelProperty(value = "Delivery agent full name")
    private String deliveryAgentFullName;

    @ApiModelProperty(value = "Control agent organization code")
    private String controllingAgentCode;

    @ApiModelProperty(value = "Control agent full name")
    private String controllingAgentFullName;

    @ApiModelProperty(value = "Carrier organization code")
    private String carrierCode;

    @ApiModelProperty(value = "Carrier full name")
    private String carrierFullName;

    @ApiModelProperty(value = "Cargo type = GenCustomAddOnValue.XV_TYpe")
    private String cargoTypeType;

    @ApiModelProperty(value = "Cargo data = GenCustomAddOnValue.XV_Data")
    private String cargoTypeData;

    @ApiModelProperty(value = "Sales code = GlbStaff.GS_Code")
    private String salesCode;

    @ApiModelProperty(value = "Sales full name = = GlbStaff.FullName")
    private String salesFullName;

    @ApiModelProperty(value = "ETD, estimated time of departure")
    private String etd;

    @ApiModelProperty(value = "Service contract")
    private String serviceContract;
}
