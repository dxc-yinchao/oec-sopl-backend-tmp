package oec.lis.sopl.service.so.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.apachecommons.CommonsLog;
import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.service.AbstractService;
import oec.lis.sopl.model.so.SO010101ResponseBean;
import oec.lis.sopl.service.so.SO0101Service;

@Service
@CommonsLog
public class SO0101ServiceImpl extends AbstractService implements SO0101Service {

    //String shipmentNo = "S00015015";


    @Override
    @Transactional(readOnly = true)
    public RestOneResponse<SO010101ResponseBean> queryShipmentDetail(String shipmentNo){

        RestOneResponse<SO010101ResponseBean> result = new RestOneResponse<SO010101ResponseBean>();
        SO010101ResponseBean testData = new SO010101ResponseBean();
        result.setBody(testData);

        return result;
    }
    
}
