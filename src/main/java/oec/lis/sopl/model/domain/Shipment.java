package oec.lis.sopl.model.domain;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @ApiModelProperty(value = "Shipment No")
    private String shipmentNo;

    @ApiModelProperty(value = "Transport Mode, 值分別為 AIR, SEA")
    private String trnsptMode;

    @ApiModelProperty(value = "System URL info. 提供 Cargowise 使用者可以連結回到 SOPL 的網址")
    private String shipmentUrl;

    @ApiModelProperty(value = "負責這筆Shipment的Sales staff code")
    private String salesStaffCode;

    @ApiModelProperty(value = "負責這筆Shipment的OP staff Code")
    private String opStaffCode;

    @ApiModelProperty(value = "建立者的Company Code")
    protected String createCmpny;

    @ApiModelProperty(value = "建立者的Branch Code")
    protected String createBranch;

    @ApiModelProperty(value = "建立者的Department Code")
    protected String createDept;

    @ApiModelProperty(value = "建立者的Staff Code")
    protected String createBy;

    @ApiModelProperty(value = "建立時間")
    protected Timestamp createTime;

    @ApiModelProperty(value = "更新者的Company Code")
    protected String updateCmpny;

    @ApiModelProperty(value = "更新者的Branch Code")
    protected String updateBranch;

    @ApiModelProperty(value = "更新者的Department Code")
    protected String updateDept;

    @ApiModelProperty(value = "更新者的Staff Code")
    protected String updateBy;

    @ApiModelProperty(value = "資料更新時間")
    protected Timestamp updateTime;

}
