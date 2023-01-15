package oec.lis.sopl.service.so.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oec.lis.sopl.common.model.MasterCodeTableRequestBean;
import oec.lis.sopl.common.model.MasterCodeTableResponseBean;
import oec.lis.sopl.common.model.RestListResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.common.service.AbstractService;
import oec.lis.sopl.service.so.MasterCodeTableService;

@Service
public class MasterCodeTableServiceImpl extends AbstractService implements MasterCodeTableService {

    @Autowired
    @Qualifier("cargowiseJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public RestListResponse<MasterCodeTableResponseBean> getMasterCodeTable(RestRequest<MasterCodeTableRequestBean> model) {
        String fieldName = model.getBody().getFieldName();
        String queryShipper = new StringBuilder()
            .append("select")
            .append("  oh.OH_Code as Shipper, ")
            .append("  oh.OH_FullName as ShipperName ")
            .append("from JobShipment a ")
            .append("  left join JobDocAddress jda on jda.E2_ParentID = a.JS_PK and jda.E2_AddressType = 'CRD' ")
            .append("  left join OrgAddress oa on oa.OA_PK = jda.E2_OA_Address ")
            .append("  left join OrgHeader oh on oh.OH_PK = oa.OA_OH ")
            .append("where ")
            .append("  a.JS_UniqueConsignRef = ? ")
            .toString();
        String shipmentNo = "S00015015";
        List<MasterCodeTableResponseBean> shippers = jdbcTemplate.query(
            queryShipper, 
            new Object[]{shipmentNo}, 
            new int[] { Types.VARCHAR }, 
            (rs, rowNum) -> new MasterCodeTableResponseBean(
                rs.getString("Shipper"),
                rs.getString("ShipperName")
            )
        );

        RestListResponse<MasterCodeTableResponseBean> result = new RestListResponse<MasterCodeTableResponseBean>();
        result.setBody(shippers);

        return result;
    }

   
}
