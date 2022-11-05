package com.akitsulab.company_simulation_ui.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "employee.api.call")
public class ApiCallConfigurationProperties {
    private final String host;
    private final int port;

    public ApiCallConfigurationProperties(String host, int port){
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
