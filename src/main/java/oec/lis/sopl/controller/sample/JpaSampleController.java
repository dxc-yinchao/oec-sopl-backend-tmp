package oec.lis.sopl.controller.sample;

import javax.validation.Valid;

import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestPageResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.cargowise.dao.po.MonitorRepertoryPO;
import oec.lis.sopl.model.so.SO010001RequestBean;
import oec.lis.sopl.model.so.SO010001ResponseBean;
import oec.lis.sopl.model.sopl.dao.po.ListSampleRequestBean;
import oec.lis.sopl.model.sopl.dao.po.ListSampleResponseBean;
import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import oec.lis.sopl.service.sample.JpaSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/sample")
@Api(tags = "Jpa sample cde")
public class JpaSampleController {

            @Value("${runtime.environment}")
            private String environment;

            @Autowired
            private JpaSampleService service;
    /*
            @PostMapping("/postgreTest")
            @ApiOperation(value = "jpa postgresql test code")
            public ResponseEntity<List<ShipmentRepertoryPO>> postgreTest() {
                List<ShipmentRepertoryPO> result = service.postgreTest();
                if (result == null){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
                return ResponseEntity.ok(result);
            }

            @PostMapping("/mssqlTest")
            @ApiOperation(value = "jpa postgresql test code")
            public ResponseEntity<List<MonitorRepertoryPO>> mssqlTest() {
                List<MonitorRepertoryPO> result = service.mssqlTest();
                if (result == null){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
                return ResponseEntity.ok(result);
            }
    */
    @PostMapping("/listTest")
    @ApiOperation(value = "Query SO Instruction data by varies condition for JPA testing.")
    public RestPageResponse<ListSampleResponseBean> listTest(@Valid @RequestBody RestRequest<ListSampleRequestBean> model) {
        return service.listTest(model);
    }

}
