package oec.lis.sopl.controller.so;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.so.SO010001RequestBean;
import oec.lis.sopl.model.so.SO010101RequestBean;
import oec.lis.sopl.model.so.SO010101ResponseBean;
import oec.lis.sopl.model.so.SO0101RateDto;
import oec.lis.sopl.service.so.SO0101Service;

@RestController
@RequestMapping("/so0101")
@Api(tags = "SO0101 SO Instruction Detail")
@CommonsLog
public class SO0101Controller {

    @Value("${runtime.environment}")
    private String environment;

    @Autowired
    private SO0101Service service;

    @GetMapping("/getDetail")
    @ApiOperation(value = "Query SO Instruction detail data by shipment NO.")
    public RestOneResponse<SO010101ResponseBean> getDetail(@Valid  String shipment) {
    	log.debug("debug");
    	log.info("info");
    	log.warn("warn");
    	log.error("error");
        return service.queryShipmentDetail(shipment);
    }
    
    @GetMapping("/getTariff")
    @ApiOperation(value = "Query tariff data by ETD.")
    public RestOneResponse<SO0101RateDto> getTariff(@Valid  String shipment) {
        RestOneResponse<SO0101RateDto> result = new RestOneResponse<SO0101RateDto>();
    	SO0101RateDto dto = new SO0101RateDto();
        result.setBody(dto);
    	return result;
    }
    
    @GetMapping("/getRate")
    @ApiOperation(value = "Query Rate by ETD")
    public RestOneResponse<SO0101RateDto> getRate(@Valid  String shipment) {
    	RestOneResponse<SO0101RateDto> result = new RestOneResponse<SO0101RateDto>();
    	SO0101RateDto dto = new SO0101RateDto();
        result.setBody(dto);
    	return result;    
    }
    
    @GetMapping("/getCost")
    @ApiOperation(value = "Query Cost by shipment ETD.")
    public RestOneResponse<SO0101RateDto> getCost(@Valid  String shipment) {
    	RestOneResponse<SO0101RateDto> result = new RestOneResponse<SO0101RateDto>();
    	SO0101RateDto dto = new SO0101RateDto();
        result.setBody(dto);
    	return result;    
    }
    
    @GetMapping("/preSubmit")
    @ApiOperation(value = "Query Submit status by shipment NO.")
    public RestOneResponse<SO010101ResponseBean> preSubmit(@Valid  String shipment) {
        return service.queryShipmentDetail(shipment);
    }
    
    @PostMapping("/confirmSubmit")
    @ApiOperation(value = "Submit.")
    public RestOneResponse<SO010101ResponseBean> submit(@Valid @RequestBody RestRequest<SO010001RequestBean> model) {
        return null;
    }
    
    @PostMapping("/save")
    @ApiOperation(value = "Save detail data.")
    public RestOneResponse<SO010101ResponseBean> save(@Valid @RequestBody RestRequest<SO010101RequestBean> model) {
        return null;
    }
}
