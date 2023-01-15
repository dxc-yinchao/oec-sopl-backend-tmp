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
import oec.lis.sopl.model.domain.Shipment;
import oec.lis.sopl.model.so.SO010001RequestBean;
import oec.lis.sopl.service.so.SO0100Service;

@Service
public class SO0100ServiceImpl extends AbstractService implements SO0100Service {

    @Autowired
    @Qualifier("soplJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public RestOneResponse<Shipment> queryShipment(RestRequest<SO010001RequestBean> model) {

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
            .append("from so_shipment ")
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

        RestOneResponse<Shipment> result = new RestOneResponse<Shipment>();
        result.setBody(shippers.get(0));

        return result;
    }
    
}
