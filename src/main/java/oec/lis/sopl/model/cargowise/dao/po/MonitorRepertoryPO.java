package oec.lis.sopl.model.cargowise.dao.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spt_monitor")
public class MonitorRepertoryPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "lastrun", nullable = false)
    private Date lastrun;

    @ApiModelProperty(value = "cpu_busy")
    private String cpuBusy;
}
