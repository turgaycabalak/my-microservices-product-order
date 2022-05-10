package com.mymicro.order.api.controller;

import com.mymicro.order.business.OrderService;
import com.mymicro.order.eDto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) {
        orderService.placeOrder(request);
        return new ResponseEntity<>("Order Placed Successfully.", HttpStatus.CREATED);
    }


}
