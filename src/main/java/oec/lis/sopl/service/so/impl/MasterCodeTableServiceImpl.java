package oec.lis.sopl.service.so.impl;

import java.sql.Types;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
    private JdbcTemplate cwJdbcTemplate;

    @Autowired
    @Qualifier("soplJdbcTemplate")
    private JdbcTemplate soplJdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public RestListResponse<MasterCodeTableResponseBean> getMasterCodeTable(RestRequest<MasterCodeTableRequestBean> model) {
        String fieldName = model.getBody().getFieldName();
        RestListResponse<MasterCodeTableResponseBean> result = new RestListResponse<MasterCodeTableResponseBean>();

        if ("status".equalsIgnoreCase(fieldName)) {
            String query = new StringBuilder()
                .append("SELECT")
                .append("  code_value, ")
                .append("  code_descp ")
                .append("from sopl.so_ref_code ")
                .append("where ")
                .append("  code_type = 'SO_STATUS' ")
                .append("  and is_active = TRUE ")
                .append("order by ")
                .append("  code_order ")
                .toString();
            List<MasterCodeTableResponseBean> codeValues = soplJdbcTemplate.query(
                query, 
                (rs, rowNum) -> new MasterCodeTableResponseBean(
                    rs.getString("code_value"),
                    rs.getString("code_descp")
                )
            );
            result.setBody(codeValues);

        } else if ("cargoType".equalsIgnoreCase(fieldName)) {
            String query = new StringBuilder()
                .append("SELECT")
                .append("  code_value, ")
                .append("  code_descp ")
                .append("from sopl.so_ref_code ")
                .append("where ")
                .append("  code_type = 'CARGO_TYPE' ")
                .append("  and is_active = TRUE ")
                .append("order by ")
                .append("  code_order ")
                .toString();
            List<MasterCodeTableResponseBean> codeValues = soplJdbcTemplate.query(
                query, 
                (rs, rowNum) -> new MasterCodeTableResponseBean(
                    rs.getString("code_value"),
                    rs.getString("code_descp")
                )
            );
            result.setBody(codeValues);

        } else if ("origin".equalsIgnoreCase(fieldName) || "destination".equalsIgnoreCase(fieldName)) {
            StringBuilder sbQuery = new StringBuilder()
                .append("SELECT")
                .append("  unloco, ")
                .append("  port_name || ', ' ||  ")
                .append("  case country_code ")
                .append("  when 'C' then 'China' ")
                .append("  else country_code ")
                .append("  end as port_name ")
                .append("from sopl.cw_ref_unloco ");
            StringBuilder sbQueryWhere = new StringBuilder(sbQuery)
                .append("where ")
                .append("  port_name like ? ")
                .append("order by ")
                .append("  unloco ");

            String query = null;
            List<MasterCodeTableResponseBean> codeValues = null;
            String keyword = model.getBody().getKeyword();
            if (StringUtils.isNoneBlank(keyword)) {
                query = sbQueryWhere.toString();
                codeValues = soplJdbcTemplate.query(
                    query, 
                    new Object[]{keyword+"%"}, 
                    new int[] { Types.VARCHAR }, 
                    (rs, rowNum) -> new MasterCodeTableResponseBean(
                        rs.getString("unloco"),
                        rs.getString("port_name")
                    )
                );
            } else {
                query = sbQuery.toString();
                codeValues = soplJdbcTemplate.query(
                    query, 
                    (rs, rowNum) -> new MasterCodeTableResponseBean(
                        rs.getString("unloco"),
                        rs.getString("port_name")
                    )
                );
            }
            if (codeValues!=null) {
                result.setBody(codeValues);
            }

        } else if ("shipper".equalsIgnoreCase(fieldName) || "consignee".equalsIgnoreCase(fieldName)||"agent".equalsIgnoreCase(fieldName) || "carrier".equalsIgnoreCase(fieldName)) {
            String whereCondition = "";
            if ("shipper".equalsIgnoreCase(fieldName)) {
                whereCondition = " is_consignor = TRUE ";
            } else if ("consignee".equalsIgnoreCase(fieldName)) {
                whereCondition = " is_consignee = TRUE ";
            } else if ("agent".equalsIgnoreCase(fieldName)) {
                whereCondition = " is_forwarder = TRUE ";
            } else if ("carrier".equalsIgnoreCase(fieldName)) {
                whereCondition = " is_shipping_provider = TRUE ";
            }
            StringBuilder sbQuery = new StringBuilder()
                .append("SELECT")
                .append("  org_code, ")
                .append("  full_name  ")
                .append("from sopl.cw_org_header ")
                .append("where ")
                .append(whereCondition);

            String query = null;
            List<MasterCodeTableResponseBean> codeValues = null;
            String keyword = model.getBody().getKeyword();
            if (StringUtils.isNoneBlank(keyword)) {
                query = sbQuery.append("  and full_name like ? ").append("order by org_code").toString();
                codeValues = soplJdbcTemplate.query(
                    query, 
                    new Object[]{keyword+"%"}, 
                    new int[] { Types.VARCHAR }, 
                    (rs, rowNum) -> new MasterCodeTableResponseBean(
                        rs.getString("org_code"),
                        rs.getString("full_name")
                    )
                );
            } else {
                query = sbQuery.append("order by org_code").toString();
                codeValues = soplJdbcTemplate.query(
                    query, 
                    (rs, rowNum) -> new MasterCodeTableResponseBean(
                        rs.getString("org_code"),
                        rs.getString("full_name")
                    )
                );
            }
            if (codeValues!=null) {
                result.setBody(codeValues);
            }
    
        } else if ("sales".equalsIgnoreCase(fieldName)) {
            StringBuilder sbQuery = new StringBuilder()
                .append("SELECT")
                .append("  staff_code, ")
                .append("  full_name ")
                .append("from sopl.cw_global_staff ")
                .append("where ")
                .append("  is_sales_rep = TRUE ");

            String query = null;
            List<MasterCodeTableResponseBean> codeValues = null;
            String keyword = model.getBody().getKeyword();
            if (StringUtils.isNoneBlank(keyword)) {
                query = sbQuery.append("  AND full_name like ? ").append("order by staff_code ").toString();
                codeValues = soplJdbcTemplate.query(
                    query, 
                    new Object[]{"%"+keyword+"%"}, 
                    new int[] { Types.VARCHAR }, 
                    (rs, rowNum) -> new MasterCodeTableResponseBean(
                        rs.getString("staff_code"),
                        rs.getString("full_name")
                    )
                );
            } else {
                query = sbQuery.append("order by staff_code ").toString();
                codeValues = soplJdbcTemplate.query(
                    query, 
                    (rs, rowNum) -> new MasterCodeTableResponseBean(
                        rs.getString("staff_code"),
                        rs.getString("full_name")
                    )
                );
            }
            if (codeValues!=null) {
                result.setBody(codeValues);
            }

        } else {
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
            List<MasterCodeTableResponseBean> shippers = cwJdbcTemplate.query(
                queryShipper, 
                new Object[]{shipmentNo}, 
                new int[] { Types.VARCHAR }, 
                (rs, rowNum) -> new MasterCodeTableResponseBean(
                    rs.getString("Shipper"),
                    rs.getString("ShipperName")
                )
            );
            result.setBody(shippers);
        }

        return result;
    }

   
}
