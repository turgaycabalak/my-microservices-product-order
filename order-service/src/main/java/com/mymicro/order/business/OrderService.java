package com.mymicro.order.business;

import com.mymicro.order.clientConfig.InventoryFeignClient;
import com.mymicro.order.dataAccess.OrderRepository;
import com.mymicro.order.eDto.OrderRequest;
import com.mymicro.order.entities.InventoryResponse;
import com.mymicro.order.entities.Order;
import com.mymicro.order.entities.OrderLineItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryFeignClient inventoryFeignClient;


    @Transactional
    public void placeOrder(OrderRequest request) {

        List<OrderLineItem> orderLineItems = request.getOrderLineItemDtos().stream()
                .map(orderLineItemDto -> new OrderLineItem(
                        orderLineItemDto.getSkuCode(),
                        orderLineItemDto.getPrice(),
                        orderLineItemDto.getQuantity()
                )).toList();

        Order order = new Order(
                UUID.randomUUID().toString(),
                orderLineItems
        );

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        List<InventoryResponse> inventoryResponses = inventoryFeignClient.isInStock(skuCodes);
        boolean isAllInStock = inventoryResponses.stream().allMatch(InventoryResponse::isInStock);

        if (isAllInStock) {
            orderRepository.saveAndFlush(order);
            log.info("Order {} is placed.", order.getId());

        } else {
            throw new IllegalStateException("Product is not in stock!");
        }


    }
}
