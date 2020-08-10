package com.example.springit.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("springit")
/**
 * This is our welkome message
 */
public class SpringitProperties {
    private String welkomeMsg="Hello, World";

    public String getWelkomeMsg() {
        return welkomeMsg;
    }

    public void setWelkomeMsg(String welkomeMsg) {
        this.welkomeMsg = welkomeMsg;
    }
}
