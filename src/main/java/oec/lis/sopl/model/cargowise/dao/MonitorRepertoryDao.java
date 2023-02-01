package oec.lis.sopl.model.cargowise.dao;


import oec.lis.sopl.model.cargowise.dao.po.MonitorRepertoryPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MonitorRepertoryDao extends JpaRepository<MonitorRepertoryPO, String>, JpaSpecificationExecutor<MonitorRepertoryPO> {

}

