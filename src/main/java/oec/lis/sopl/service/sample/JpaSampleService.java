package oec.lis.sopl.service.sample;

import oec.lis.sopl.common.model.RestPageResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.cargowise.dao.po.MonitorRepertoryPO;
import oec.lis.sopl.model.sopl.dao.po.ListSampleRequestBean;
import oec.lis.sopl.model.sopl.dao.po.ListSampleResponseBean;
import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface JpaSampleService {

    List<ShipmentRepertoryPO> postgreTest();
    List<MonitorRepertoryPO> mssqlTest();
    RestPageResponse<ListSampleResponseBean> listTest(RestRequest<ListSampleRequestBean> model);

}
