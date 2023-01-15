package oec.lis.sopl.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oec.lis.sopl.common.model.MasterCodeTableRequestBean;
import oec.lis.sopl.common.model.MasterCodeTableResponseBean;
import oec.lis.sopl.common.model.MasterDataRequestBean;
import oec.lis.sopl.common.model.MasterDataResponseBean;
import oec.lis.sopl.common.model.RestListResponse;
import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.service.so.MasterCodeTableService;

@RestController
@RequestMapping("/common")
@Api(tags = "Common APIs")
public class CommonController {

    @Autowired
    private MasterCodeTableService service;

    @PostMapping("/getMasterCodeTable")
    @ApiOperation(value = "Get HBL No and filtered by user profile attributes (company code, role, sales id).")
    public RestListResponse<MasterCodeTableResponseBean> getMasterCodeTable(@Valid @RequestBody RestRequest<MasterCodeTableRequestBean> model) {
        // get company code and sales id and role from user profile
        return service.getMasterCodeTable(model);
    }

    @GetMapping("/getMasterData")
    @ApiOperation(value = "Get varies master data and filtered by user profile attributes (company code, role, sales id).")
    public RestOneResponse<MasterDataResponseBean> getMasterData(@Valid @RequestBody RestRequest<MasterDataRequestBean> model) {
        // get company code and sales id and role from user profile
        RestOneResponse<MasterDataResponseBean> result = new RestOneResponse<MasterDataResponseBean>();
        return result;        
    }
}
