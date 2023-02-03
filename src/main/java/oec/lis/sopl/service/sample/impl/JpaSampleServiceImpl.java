package oec.lis.sopl.service.sample.impl;

import java.util.List;

import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestPageResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.cargowise.dao.MonitorRepertoryDao;
import oec.lis.sopl.model.cargowise.dao.po.MonitorRepertoryPO;
import oec.lis.sopl.model.so.SO010001ResponseBean;
import oec.lis.sopl.model.sopl.dao.ListSampleRepertoryDao;
import oec.lis.sopl.model.sopl.dao.ShipmentRepertoryDao;
import oec.lis.sopl.model.sopl.dao.po.ListSampleRequestBean;
import oec.lis.sopl.model.sopl.dao.po.ListSampleResponseBean;
import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import oec.lis.sopl.service.sample.JpaSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import oec.lis.sopl.common.service.AbstractService;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class JpaSampleServiceImpl extends AbstractService implements JpaSampleService {

    @Autowired
    private ShipmentRepertoryDao shipmentRepertoryDao;
    @Autowired
    private MonitorRepertoryDao monitorRepertoryDao;

    @Autowired
    private ListSampleRepertoryDao listSampleRepertoryDao;

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

    @Override
    public RestPageResponse<ListSampleResponseBean> listTest(@Valid @RequestBody RestRequest<ListSampleRequestBean> model) {
        //ASC,DESC
        int page = model.getBody().getPage();
        int size = model.getBody().getSize();
        String sortBy = model.getBody().getSortBy();
        String sortDir = model.getBody().getSortDir();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        //List<ListSampleResponseBean> list =  listSampleRepertoryDao.findAll(sort);
        List<ListSampleResponseBean> list =  listSampleRepertoryDao.findAll();
        RestPageResponse<ListSampleResponseBean> result = new RestPageResponse<>(list, page, size);
        //return (result != null ?? null);
        if(result != null){
            return result;
        }
        return null;
    }

}
