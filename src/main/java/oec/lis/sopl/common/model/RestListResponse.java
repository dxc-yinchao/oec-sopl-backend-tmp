package oec.lis.sopl.common.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RestListResponse<T> extends CommonRestApiResponse {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回覆處理結果")
    private List<T> body;
}
