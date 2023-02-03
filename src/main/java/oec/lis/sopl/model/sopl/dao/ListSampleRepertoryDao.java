package oec.lis.sopl.model.sopl.dao;

import io.lettuce.core.dynamic.annotation.Param;
import oec.lis.sopl.model.sopl.dao.po.ListSampleResponseBean;
import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListSampleRepertoryDao extends JpaRepository<ListSampleResponseBean, String>, JpaSpecificationExecutor<ListSampleResponseBean> {
    @Query(value = "select * where so_shipment c where c.SHIPMENT_NO=:shipmentNo ORDER BY :orderId :orderBy", nativeQuery = true)
    List<ListSampleResponseBean> findAllByShipmentNo(@Param("shipmentNo") String shipmentNo, @Param("orderId") String orderId, @Param("orderBy") String orderBy);
}

