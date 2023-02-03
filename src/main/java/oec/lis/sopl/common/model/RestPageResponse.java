package oec.lis.sopl.common.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.support.PagedListHolder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RestPageResponse<T> extends CommonRestApiResponse {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "nmber on per page")
    private int size;

    @ApiModelProperty(value = "all pages") // 總頁數
    private int pageCount;

    @ApiModelProperty(value = "reply result") //回傳資料
    private List<T> body;

    public RestPageResponse(List<T> list, int page, int size){
        PagedListHolder pagedListHolder = new PagedListHolder(list);
        pagedListHolder.setPageSize(size); // number of items per page
        pagedListHolder.setPage(page);      // set to first page
        this.size = size;
        this.pageCount = pagedListHolder.getPageCount(); // 總頁數
        this.body = pagedListHolder.getPageList();  // a List which represents the current page
    }
}
