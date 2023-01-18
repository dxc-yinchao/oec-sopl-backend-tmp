package oec.lis.sopl.model.domain;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserInfo {

    @ApiModelProperty(value = "USER ID")
    protected String sub;

    @ApiModelProperty(value = "是否已認證郵件信箱")
    protected String email_verified;

    @ApiModelProperty(value = "主管")
    protected String director;

    @ApiModelProperty(value = "主管EMAIL")
    protected String directorEmail;

    @ApiModelProperty(value = "preferred_username")
    protected String preferred_username;

    @ApiModelProperty(value = "given_name")
    protected String given_name;

    @ApiModelProperty(value = "family_name")
    protected String family_name;

    @ApiModelProperty(value = "email")
    protected String email;

    @ApiModelProperty(value = "company_code")
    protected String company_code;

}
