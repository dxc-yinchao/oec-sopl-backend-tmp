package oec.lis.sopl.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefUnloco {

    @ApiModelProperty(value = "refUnlocoId, key value")
    private String refUnlocoId;

    @ApiModelProperty(value = "unloco")
    private String unloco;

    @ApiModelProperty(value = "port name")
    private String portName;

    @ApiModelProperty(value = "country code")
    private String countryCode;

    @ApiModelProperty(value = "iata code")
    private String iata;

    @ApiModelProperty(value = "has airport")
    private Boolean hasAirport;

    @ApiModelProperty(value = "has seaport")
    private Boolean hasSeaport;

    @ApiModelProperty(value = "has rail")
    private Boolean hasRail;

    @ApiModelProperty(value = "has road")
    private Boolean hasRoad;

    @ApiModelProperty(value = "Is this record active? TRUE=active, FALSE=inactive")
    private Boolean isActive;
}
