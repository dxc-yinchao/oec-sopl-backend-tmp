package oec.lis.sopl.model.sopl.dao.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "so_shipment")
public class ShipmentRepertoryPO implements Serializable {
    @Id
    @ApiModelProperty(value = "Shipment No")
    private String shipmentNo;

    @ApiModelProperty(value = "Transport Mode, 值分別為 AIR, SEA")
    private String trnsptMode;

    @ApiModelProperty(value = "System URL info. 提供 Cargowise 使用者可以連結回到 SOPL 的網址")
    private String soShipmentUrl;

    @ApiModelProperty(value = "負責這筆Shipment的Sales staff code")
    private String cwSalesStaffCode;

    @ApiModelProperty(value = "負責這筆Shipment的OP staff Code")
    private String cwOpStaffCode;

}