package oec.lis.sopl.model.domain;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommonTxnDomainModel {

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
