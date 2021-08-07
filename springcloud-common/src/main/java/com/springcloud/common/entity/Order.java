package com.springcloud.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String orderId;
}
