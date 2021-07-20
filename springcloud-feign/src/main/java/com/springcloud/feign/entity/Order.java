package com.springcloud.feign.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String orderId;
}
