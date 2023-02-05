package oec.lis.sopl.model.so;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * for SO0101 detail container
 * @author teddy
 *
 */
@Data
public class SO0101ContainerDto {

    @ApiModelProperty(value = "ConsolNo")
    protected String consolNo;

    @ApiModelProperty(value = "Container Type")
    protected String containerType;

    @ApiModelProperty(value = "Count")
    protected String count;

    @ApiModelProperty(value = "Container No")
    protected String containerNo;

    @ApiModelProperty(value = "DeliveryMode")
    protected String deliverymode;

    @ApiModelProperty(value = "Weight")
    protected String weight;

    @ApiModelProperty(value = "Seal No ")
    protected String sealno ;


}
