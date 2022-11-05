package com.akitsulab.company_simulation_ui.dao;

import com.akitsulab.company_simulation_ui.configuration.ApiCallConfigurationProperties;
import com.akitsulab.company_simulation_ui.domain.Employee;
import com.akitsulab.company_simulation_ui.domain.EmployeeList;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class EmployeeDaoImpl implements EmployeeDao, InitializingBean {
    private final ApiCallConfigurationProperties properties;
    private final RestOperations restOperations;
    private String employeeApiUrlPrefix;

    public EmployeeDaoImpl(ApiCallConfigurationProperties properties, RestOperations restOperations) {
        this.properties = properties;
        this.restOperations = restOperations;
    }

    @Override
    public EmployeeList find() {
        // APIコールのURLを作成する
        // UriComponentsBuilderクラスを利用する
        // URLはbookApiUrlRefixを利用する
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.employeeApiUrlPrefix);
        //  APIコール
        // getForObjectメソッドを実行
        return restOperations.getForObject(builder.build().toUriString(), EmployeeList.class);
    }

    @Override
    public Employee get(int employeeId) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        this.employeeApiUrlPrefix = "http://" + this.properties.getHost() + ":" + this.properties.getPort() + "/services/v1/employee";
    }
}
