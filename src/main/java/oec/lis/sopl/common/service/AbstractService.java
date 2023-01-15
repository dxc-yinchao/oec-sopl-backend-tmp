package oec.lis.sopl.common.service;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

public abstract class AbstractService {

    @Getter
    @Value("${runtime.environment}")
    private String environment;

    @Qualifier("soplDataSource")
    protected DataSource soplDataSource;

    @Qualifier("cargowiseDataSource")
    protected DataSource cargowiseDataSource;

}
