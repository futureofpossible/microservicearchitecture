package com.springcloud.common.entity;

import lombok.*;

/**
 * json封装体
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this(code, message, null);
    }
}
