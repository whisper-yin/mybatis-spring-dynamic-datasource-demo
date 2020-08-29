package org.hk.demo.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Component("dataSourceConfiguration")
@ConfigurationProperties(prefix = "custom.datasource")
public class DataSourceConfiguration {

    private List<String> alias;
    private List<String> driverClassName;
    private List<String> url;
    private List<String> username;
    private List<String> password;

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public List<String> getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(List<String> driverClassName) {
        this.driverClassName = driverClassName;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }
}
