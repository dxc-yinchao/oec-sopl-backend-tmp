package oec.lis.sopl.service.so;

import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.model.so.SO010101ResponseBean;

public interface SO0101Service {
    
    RestOneResponse<SO010101ResponseBean> queryShipmentDetail(String shipmentNo);
}
