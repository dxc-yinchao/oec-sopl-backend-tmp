package oec.lis.sopl.service.so;

import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.domain.Shipment;
import oec.lis.sopl.model.so.SO010001RequestBean;

public interface SO0100Service {
    
    RestOneResponse<Shipment> queryShipment(RestRequest<SO010001RequestBean> model);
}
