package oec.lis.sopl.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgHeader {

    @ApiModelProperty(value = "orgHeaderId, in uuid format")
    private String orgHeaderId;

    @ApiModelProperty(value = "Org Code, a unique value")
    private String orgCode;

    @ApiModelProperty(value = "full name")
    private String fullName;

    @ApiModelProperty(value = "is consignee, receiver")
    private String isConsignee; // receiver

    @ApiModelProperty(value = "is consignor, shipper")
    private String isConsignor; // shipper

    @ApiModelProperty(value = "is forwarder, agent")
    private String isForwarder; // agent

    @ApiModelProperty(value = "is shipping provider, carrier")
    private String isShippingProvider; // carrier

    @ApiModelProperty(value = "is air line")
    private String isAirLine;

    @ApiModelProperty(value = "is shipping line = sea line")
    private String isShippingLine;

    @ApiModelProperty(value = "is temp account")
    private String isTempAcct;

    @ApiModelProperty(value = "is controlling customer")
    private String isCtrlingCust;

    @ApiModelProperty(value = "is controling agent")
    private String isCtrlingAgent;

    @ApiModelProperty(value = "Is this record active? TRUE=active, FALSE=inactive")
    private String isActive;
}
