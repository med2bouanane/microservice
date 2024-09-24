package com.demwob.training.order.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "inventory-client")
@Getter
@Setter
public class InventoryClientProperties {
    private String url;
    private String scheme;
    private String host;
    private int port;
    private String path;
}
