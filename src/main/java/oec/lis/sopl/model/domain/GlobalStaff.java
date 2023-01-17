package oec.lis.sopl.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalStaff {

    @ApiModelProperty(value = "global staff id, unique value")
    public String globalStaffId;

    @ApiModelProperty(value = "global branch id")
    public String globalBranchId;

    @ApiModelProperty(value = "global department id")
    public String globalDeptId;

    @ApiModelProperty(value = "staff code, unique key")
    public String staffCode;

    @ApiModelProperty(value = "cw login name")
    public String cwLoginName;

    @ApiModelProperty(value = "full name")
    public String fullName;

    @ApiModelProperty(value = "email")
    public String email;

    @ApiModelProperty(value = "is sales represent")
    public String isSalesRep;

    @ApiModelProperty(value = "Is this record active? TRUE=active, FALSE=inactive")
    public String isActive;
}
