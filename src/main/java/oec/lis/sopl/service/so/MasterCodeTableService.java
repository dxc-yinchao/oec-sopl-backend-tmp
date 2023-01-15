package oec.lis.sopl.service.so;

import oec.lis.sopl.common.model.MasterCodeTableRequestBean;
import oec.lis.sopl.common.model.MasterCodeTableResponseBean;
import oec.lis.sopl.common.model.RestListResponse;
import oec.lis.sopl.common.model.RestRequest;

public interface MasterCodeTableService {
    
    RestListResponse<MasterCodeTableResponseBean> getMasterCodeTable(RestRequest<MasterCodeTableRequestBean> model);
}
