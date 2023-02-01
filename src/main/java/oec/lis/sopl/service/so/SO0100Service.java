package oec.lis.sopl.service.so;

import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.so.SO010001RequestBean;
import oec.lis.sopl.model.so.SO010001ResponseBean;

public interface SO0100Service {
    
    RestOneResponse<SO010001ResponseBean> queryShipment(RestRequest<SO010001RequestBean> model);
}
