package com.demwob.training.order.client;


import com.demwob.training.order.configuration.InventoryClientProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class InventoryClient {
    private final WebClient webClient;

    private final InventoryClientProperties inventoryClientProperties;

    public InventoryClient(WebClient.Builder webClientBuilder, InventoryClientProperties inventoryClientProperties) {
        this.webClient = webClientBuilder.build();
        this.inventoryClientProperties = inventoryClientProperties;
    }

    public Boolean isInStock(String skuCode, Integer quantity) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme(inventoryClientProperties.getScheme())
                        .host(inventoryClientProperties.getHost())
                        .port(inventoryClientProperties.getPort())
                        .path(inventoryClientProperties.getPath())
                        .queryParam("skuCode", skuCode)
                        .queryParam("quantity", quantity).build())
                .retrieve()
//                .onStatus(HttpStatus.INTERNAL_SERVER_ERROR, clientResponse ->
//                        Mono.error(new RuntimeException("Failed to fetch inventory: " + clientResponse.statusCode())))
                .bodyToMono(Boolean.class).block();
    }
}
