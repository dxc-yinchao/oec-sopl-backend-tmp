package oec.lis.sopl.common.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class RestPageRequest implements Serializable {

    @ApiModelProperty(value = "number of pages queried.", required = false )
    private int page = 0;

    @ApiModelProperty(value = "The number of queries per page", required = false )
    private int size = 10;

    @ApiModelProperty(value = "sortBy shipmentNo", required = false )
    private String sortBy = "id";

    @ApiModelProperty(value = "sortDir ASC,DESC", required = false )
    private String sortDir = "ASC";

}