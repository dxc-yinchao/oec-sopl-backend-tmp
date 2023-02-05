package oec.lis.sopl.model.so;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * for SO0101 detail routing
 * @author teddy
 *
 */
@Data
public class SO0101RoutingDto {

    @ApiModelProperty(value = "ConsolNo")
    protected String ConsolNo;

    @ApiModelProperty(value = "LegSeq")
    protected String LegSeq;

    @ApiModelProperty(value = "LegMode")
    protected String LegMode;

    @ApiModelProperty(value = "Vessel")
    protected String Vessel;

    @ApiModelProperty(value = "VoyageFlight")
    protected String VoyageFlight ;

    @ApiModelProperty(value = "POL")
    protected String POL;

    @ApiModelProperty(value = "POD")
    protected String POD;

    @ApiModelProperty(value = "ETD")
    protected String ETD;

    @ApiModelProperty(value = "ETA")
    protected String ETA;

}
