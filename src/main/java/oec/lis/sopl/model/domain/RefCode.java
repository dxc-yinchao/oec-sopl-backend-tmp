package oec.lis.sopl.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefCode {

    @ApiModelProperty(value = "Code Group, ex. 'STATUS' or 'CARGO_TYPE' ")
    private String codeType;

    @ApiModelProperty(value = "Code")
    private String codeValue;

    @ApiModelProperty(value = "Value or description")
    private String codeDescp;

    @ApiModelProperty(value = "Display order")
    private Integer codeOrder;

    @ApiModelProperty(value = "Is this record active? TRUE=active, FALSE=inactive")
    private Boolean isActive;
}
