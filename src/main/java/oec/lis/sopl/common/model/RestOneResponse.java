package oec.lis.sopl.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RestOneResponse<T> extends CommonRestApiResponse {

    @ApiModelProperty(value = "回覆處理結果")
    private T body;
}
