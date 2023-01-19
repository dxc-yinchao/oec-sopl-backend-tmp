package oec.lis.sopl.controller.so;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.domain.Shipment;
import oec.lis.sopl.model.so.SO010001RequestBean;
import oec.lis.sopl.model.so.SO010001ResponseBean;
import oec.lis.sopl.service.so.SO0100Service;

@RestController
@RequestMapping("/so0100")
@Api(tags = "SO0100 SO Instruction List")
public class SO0100Controller {

    @Value("${runtime.environment}")
    private String environment;

    @Autowired
    private SO0100Service service;

    @PostMapping("/list")
    @ApiOperation(value = "Query SO Instruction data by varies condition.")
    public RestOneResponse<SO010001ResponseBean> doQuerySoList(@Valid @RequestBody RestRequest<SO010001RequestBean> model) {
        return service.queryShipment(model);
    }
}
