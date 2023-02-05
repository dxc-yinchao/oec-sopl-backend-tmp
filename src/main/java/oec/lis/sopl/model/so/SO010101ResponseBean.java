package oec.lis.sopl.model.so;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import oec.lis.sopl.common.util.Misc;
import oec.lis.sopl.model.domain.Shipment;

@Data
@NoArgsConstructor
public class SO010101ResponseBean {

    //shipment info
    @ApiModelProperty(value = "Shipment No")
    private String shipmentNo;

    @ApiModelProperty(value = "HBL No")
    private String hblNo;

    @ApiModelProperty(value = "Origin")
    private String origin;
    //OriginNM??
    
    @ApiModelProperty(value = "Destination")
    private String destination;
    //DestinationNM??
    
    @ApiModelProperty(value = "Shipper")
    private String shipper;
    
    @ApiModelProperty(value = "Consignee")
    private String consignee;
    
    @ApiModelProperty(value = "Local Client")
    private String localClient;
    //LocalClientNM??
    
    @ApiModelProperty(value = "Delivery Agent")
    private String deliveryAgent;
    //DelveiryAgentNM
    
    @ApiModelProperty(value = "Controlling Agent")
    private String controllingAgent;
    
    @ApiModelProperty(value = "Cargo Type")
    private String cargoType;
    
    @ApiModelProperty(value = "HBL Service")
    private String hblService;
    
    @ApiModelProperty(value = "Sales")
    private String sales;
    
    @ApiModelProperty(value = "Volume")
    private String volume;
    
    @ApiModelProperty(value = "Weight")
    private String weight;
    
    @ApiModelProperty(value = "Chargeable")
    private String chargeable;
    
    @ApiModelProperty(value = "Packs")
    private String packs;
    //PackType??
    @ApiModelProperty(value = "Incoterm")
    private String incoterm;
    
    @ApiModelProperty(value = "Invoice Term")
    private String invoiceTerm;
    
    @ApiModelProperty(value = "Commodity")
    private String commodity;
    
    @ApiModelProperty(value = "Transport Mode")
    private String transportMode;
    
    @ApiModelProperty(value = "Type")
    private String type;
   
    @ApiModelProperty(value = "Container Mode")
    private String containerMode;
    
    //consol info
    @ApiModelProperty(value = "Consol No")
    private String consolNo;
    
    @ApiModelProperty(value = "MBL No")
    private String mblNo;
    
    @ApiModelProperty(value = "Transport Mode in consol")
    private String consolTransportMode;
    
    @ApiModelProperty(value = "Type in consol")
    private String consoTtype;
    //AgentType??
    
    @ApiModelProperty(value = "Container Mode in consol")
    private String consolContainerMode;
    
    @ApiModelProperty(value = "Receiving Agent")
    private String receivingAgent;
    //ReceivingAgentNM
    
    @ApiModelProperty(value = "Carrier Booking No")
    private String carrierBookingNo;
    
    @ApiModelProperty(value = "Carrier")
    private String carrier;
    //CarrierNM??
    
    //from so_consol by consolNo?
    //	資料取自<so_consol.cntrct_id>,關聯<so_contract.cntrct_id>取<so_contract.cntrct_no>體現
    @ApiModelProperty(value = "Service Contract")
    private String serviceContractId;
    
    @ApiModelProperty(value = "Service Contract")
    private String serviceContract;
    
    //from so_consol by consolNo?
    //	資料取自<so_consol.cntrct_id>,關聯<so_contract.cntrct_id>取 <so_contract.bullet_no>體現
    @ApiModelProperty(value = "Bullet No")
    private String bulletNoId;
    
    @ApiModelProperty(value = "Bullet No")
    private String bulletNo;
    
    
    //from so_consol by consolNo?
    @ApiModelProperty(value = "Carrier Remark")
    private String carrierRemark;
    
    @ApiModelProperty(value = "Routing")
    private List<SO0101RoutingDto> routing;
    
    @ApiModelProperty(value = "Container")
    private List<SO0101ContainerDto> container;
    
    
    @ApiModelProperty(value = "Selling Rate")
    private List<SO0101RateDto> sellingRate;
    
    @ApiModelProperty(value = "Bottom Rate")
    private List<SO0101RateDto> bottomRate;
    
    //from so_rate_version by shipmentNo?
    @ApiModelProperty(value = "Remark")
    private String remark;
    
    @ApiModelProperty(value = "Creator")
    private String creator;
    
    @ApiModelProperty(value = "Created Date")
    private String createdDate;
    
    @ApiModelProperty(value = "Modify By")
    private String modifyBy;
    
    @ApiModelProperty(value = "Modify Date")
    private String modifyDate;
    
}
