package oec.lis.sopl.common.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRestApiResponse {

    @ApiModelProperty(value = "HTTP Status code", allowEmptyValue = false, required = true)
    private String status = "200"; // 200: Success

    @ApiModelProperty(value = "伺服器處理完成後的回覆內容", allowEmptyValue = true, required = false)
    private List<String> msg = new ArrayList<String>();
}
