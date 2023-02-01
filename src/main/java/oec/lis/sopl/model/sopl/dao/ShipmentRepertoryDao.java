package oec.lis.sopl.model.sopl.dao;

import oec.lis.sopl.model.sopl.dao.po.ShipmentRepertoryPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShipmentRepertoryDao extends JpaRepository<ShipmentRepertoryPO, String>, JpaSpecificationExecutor<ShipmentRepertoryPO> {

}

