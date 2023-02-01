package oec.lis.sopl.service.sample;

import oec.lis.sopl.model.cargowise.dao.po.MonitorRepertoryPO;
import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import java.util.List;

public interface JpaSampleService {

    List<ShipmentRepertoryPO> postgreTest();
    List<MonitorRepertoryPO> mssqlTest();

}
