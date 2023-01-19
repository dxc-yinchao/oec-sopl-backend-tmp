package oec.lis.sopl.service.so.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oec.lis.sopl.common.model.RestOneResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.common.service.AbstractService;
import oec.lis.sopl.common.util.ListUtils;
import oec.lis.sopl.model.domain.Shipment;
import oec.lis.sopl.model.so.SO010001RequestBean;
import oec.lis.sopl.model.so.SO010001ResponseBean;
import oec.lis.sopl.service.so.SO0100Service;

@Service
public class SO0100ServiceImpl extends AbstractService implements SO0100Service {

    @Autowired
    @Qualifier("soplJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public RestOneResponse<SO010001ResponseBean> queryShipment(RestRequest<SO010001RequestBean> model) {

        // 01. 依照傳入的查詢條件查詢 shipmentNo
        // 02. 每一個查詢條件查詢完成後，將結果進行交集處理
        /* TODO
        // if (model.shipment != empty) { 
            List<String> resultList = null;
            List<String> query01List = getShipmentNoByHouseBill(model);
            if (resultList==null) {
                resultList = query01List;
            } else {
                resultList = ListUtils.intersect(resultList, query01List);
            }
            List<String> query02List = getShipmentNoByStatus(model);
            if (resultList==null) {
                resultList = query02List;
            } else {
                resultList = ListUtils.intersect(resultList, query02List);
            }
            List<String> query03List = getShipmentNoByConsolNo(model);
            List<String> query04List = getShipmentNoByMasterBillNo(model);
            List<String> query05List = getShipmentNoByOriginCode(model);
            List<String> query06List = getShipmentNoByDestinationCode(model);
            List<String> query07List = getShipmentNoByShipperCode(model);
            List<String> query08List = getShipmentNoByConsigneeCode(model);
            List<String> query09List = getShipmentNoByDeliveryAgentCode(model);
            List<String> query10List = getShipmentNoByControllingAgentCode(model);
            List<String> query11List = getShipmentNoByCarrierCode(model);
            List<String> query12List = getShipmentNoByCargoTypeType(model);
            List<String> query13List = getShipmentNoBySalesCode(model);
            List<String> query14List = getShipmentNoByEtd(model);
            List<String> query04List = getShipmentNoByServiceContract(model);

        // 03. List of shipmentNo 查詢 Cargowise 主查詢，並存入 SO010001ResponseBean中
        // 04. 針對每一筆 SO010001ResponseBean 執行 loop
        // 04-1 找到 shipper info. 並填入 SO010001ResponseBean 中
        // 04-2 找到 consignee info. 並填入 SO010001ResponseBean 中
        // 04-3 找到 delivery agent info. 並填入 SO010001ResponseBean 中
        // 04-4 找到 controlling agent info. 並填入 SO010001ResponseBean 中
        // 04-5 找到 carrier info. 並填入 SO010001ResponseBean 中
        // 04-6 找到 status 與 service contract info. 並填入 SO010001ResponseBean 中
         */
        String queryShipper = new StringBuilder()
            .append("select")
            .append("  shipment_no, ")
            .append("  trnspt_mode, ")
            .append("  so_shipment_url, ")
            .append("  cw_sales_staff_code, ")
            .append("  cw_op_staff_code, ")
            .append("  cw_create_cmpny, ")
            .append("  cw_create_branch, ")
            .append("  cw_create_dept, ")
            .append("  cw_create_by, ")
            .append("  cw_create_time, ")
            .append("  cw_update_cmpny, ")
            .append("  cw_update_branch, ")
            .append("  cw_update_dept, ")
            .append("  cw_update_by, ")
            .append("  cw_update_time ")
            .append("from sopl.so_shipment ")
            .append("where ")
            .append("  shipment_no = ? ")
            .toString();

        String shipmentNo = "S00015015";
        List<Shipment> shippers = jdbcTemplate.query(
            queryShipper, 
            new Object[]{shipmentNo}, 
            new int[] { Types.VARCHAR }, 
            (rs, rowNum) -> new Shipment(
                rs.getString("shipment_no"),
                rs.getString("trnspt_mode"),
                rs.getString("so_shipment_url"),
                rs.getString("cw_sales_staff_code"),
                rs.getString("cw_op_staff_code"),
                rs.getString("cw_create_cmpny"),
                rs.getString("cw_create_branch"),
                rs.getString("cw_create_dept"),
                rs.getString("cw_create_by"),
                rs.getTimestamp("cw_create_time"),
                rs.getString("cw_update_cmpny"),
                rs.getString("cw_update_branch"),
                rs.getString("cw_update_dept"),
                rs.getString("cw_update_by"),
                rs.getTimestamp("cw_update_time")
            )
        );

        RestOneResponse<SO010001ResponseBean> result = new RestOneResponse<SO010001ResponseBean>();
        SO010001ResponseBean testData = new SO010001ResponseBean(shippers.get(0));
        result.setBody(testData);

        return result;
    }
    
}
