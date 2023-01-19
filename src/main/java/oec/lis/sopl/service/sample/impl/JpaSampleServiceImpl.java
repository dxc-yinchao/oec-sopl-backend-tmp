package oec.lis.sopl.service.sample.impl;

import java.util.List;
import oec.lis.sopl.model.cargowise.dao.MonitorRepertoryDao;
import oec.lis.sopl.model.cargowise.dao.po.MonitorRepertoryPO;
import oec.lis.sopl.model.sopl.dao.ShipmentRepertoryDao;
import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import oec.lis.sopl.service.sample.JpaSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oec.lis.sopl.common.service.AbstractService;

@Service
public class JpaSampleServiceImpl extends AbstractService implements JpaSampleService {

    @Autowired
    private ShipmentRepertoryDao shipmentRepertoryDao;
    @Autowired
    private MonitorRepertoryDao monitorRepertoryDao;

    @Override
    public List<ShipmentRepertoryPO> postgreTest(){
        List<ShipmentRepertoryPO> list =  shipmentRepertoryDao.findAll();
        return list;
    }

    @Override
    public List<MonitorRepertoryPO> mssqlTest(){
        List<MonitorRepertoryPO> list =  monitorRepertoryDao.findAll();
        return list;
    }
}
