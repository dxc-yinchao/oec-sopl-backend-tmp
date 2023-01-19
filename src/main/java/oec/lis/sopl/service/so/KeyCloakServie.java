package oec.lis.sopl.service.so;

import oec.lis.sopl.common.model.MasterCodeTableRequestBean;
import oec.lis.sopl.common.model.MasterCodeTableResponseBean;
import oec.lis.sopl.common.model.RestListResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.domain.UserInfo;

public interface KeyCloakServie {
    
    UserInfo getUserInfo(String token);
    
    UserInfo getUserInfo(String username,String password);
    
    String getUserToken(String username,String password);

}
