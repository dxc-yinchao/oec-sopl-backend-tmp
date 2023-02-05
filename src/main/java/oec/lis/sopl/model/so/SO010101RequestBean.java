package oec.lis.sopl.model.so;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import oec.lis.sopl.common.util.Misc;
import oec.lis.sopl.model.domain.Shipment;

@Data
@NoArgsConstructor
public class SO010101RequestBean {

    //shipment info
    @ApiModelProperty(value = "Shipment No")
    private String shipmentNo;

    @ApiModelProperty(value = "Service Contract")
    private String serviceContractId;
    
    @ApiModelProperty(value = "Service Contract")
    private String serviceContract;
    
    @ApiModelProperty(value = "Bullet No")
    private String bulletNoId;
    
    @ApiModelProperty(value = "Bullet No")
    private String bulletNo;
    
    
    //from so_consol by consolNo?
    @ApiModelProperty(value = "Carrier Remark")
    private String carrierRemark;
    
    @ApiModelProperty(value = "Selling Rate")
    private List<SO0101RateDto> sellingRate;
    
    @ApiModelProperty(value = "Bottom Rate")
    private List<SO0101RateDto> bottomRate;
    
    //from so_rate_version by shipmentNo?
    @ApiModelProperty(value = "Remark")
    private String remark;
    
    
}
