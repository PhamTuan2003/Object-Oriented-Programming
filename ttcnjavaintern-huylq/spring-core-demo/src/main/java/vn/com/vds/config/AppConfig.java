package vn.com.vds.config;

import org.springframework.core.env.ConfigurableEnvironment;

public class AppConfig {

    private ConfigurableEnvironment configurableEnvironment;

    public AppConfig(ConfigurableEnvironment configurableEnvironment) {
        this.configurableEnvironment = configurableEnvironment;
    }

    public void setEnvironment() {
        this.configurableEnvironment.setActiveProfiles("dev");
    }
}
