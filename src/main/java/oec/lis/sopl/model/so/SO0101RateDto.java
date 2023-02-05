package oec.lis.sopl.model.so;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * for SO0101 Client Rates (seliing rate and bottom rate 共用)
 * getTariffs getVost getRate
 * @author teddy
 *
 */
@Data
public class SO0101RateDto {

    @ApiModelProperty(value = "Client")
    protected String Client;

    @ApiModelProperty(value = "Origin")
    protected String Origin;

    @ApiModelProperty(value = "Destination")
    protected String Destination;

    @ApiModelProperty(value = "Mode")
    protected String Mode;

    @ApiModelProperty(value = "StartDate")
    protected String StartDate;

    @ApiModelProperty(value = "ExpiryDate")
    protected String ExpiryDate;

    @ApiModelProperty(value = "ChargeCode")
    protected String ChargeCode;

    @ApiModelProperty(value = "ChargeDescription")
    protected String ChargeDescription;

    @ApiModelProperty(value = "Currency")
    protected String Currency;

    @ApiModelProperty(value = "Unit")
    protected String Unit;

    @ApiModelProperty(value = "ItemOperator")
    protected String ItemOperator;

    @ApiModelProperty(value = "Rate")
    protected String Rate;
    
    @ApiModelProperty(value = "P/C")
    protected String PC;


}
