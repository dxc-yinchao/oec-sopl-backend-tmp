package oec.lis.sopl.model.so;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SO010001RequestBean implements Serializable {

    @ApiModelProperty(value = "hbl no", allowEmptyValue = true)
    private String[] hblNo;

    @ApiModelProperty(value = "mbl no", allowEmptyValue = true)
    private String[] mblNo;

    @ApiModelProperty(value = "shipment no", allowEmptyValue = true)
    private String[] shipmentNo;

    @ApiModelProperty(value = "consol no", allowEmptyValue = true)
    private String[] consolNo;

    @ApiModelProperty(value = "status ( [N]ew | [D]raft | [P]ending | [A]pproved | [R]ejected )", allowEmptyValue = true)
    private String[] status;

    @ApiModelProperty(value = "origin", allowEmptyValue = true)
    private String[] origin;

    @ApiModelProperty(value = "destination", allowEmptyValue = true)
    private String[] destination;

    @ApiModelProperty(value = "shipper organization ID", allowEmptyValue = true)
    private String[] shipperOrgId;

    @ApiModelProperty(value = "consignee organization ID", allowEmptyValue = true)
    private String[] consigneeOrgId;

    @ApiModelProperty(value = "agent organization ID", allowEmptyValue = true)
    private String[] agentOrgId;

    @ApiModelProperty(value = "carieer organization ID", allowEmptyValue = true)
    private String[] carieerOrgId;

    @ApiModelProperty(value = "sales staff ID", allowEmptyValue = true)
    private String[] salesId;

    @ApiModelProperty(value = "Begin date for querying ETD (=Estimated Time of Departure)", allowEmptyValue = true)
    private String beginDate;

    @ApiModelProperty(value = "End date for querying ETD (=Estimated Time of Departure)", allowEmptyValue = true)
    private String endDate;

    @ApiModelProperty(value = "cargo type ( [L]ocal | [R]outine | [M]utual | [C]oload | [S] Volume Non-calculated )", allowEmptyValue = true)
    private String[] cargoType;
    
}
