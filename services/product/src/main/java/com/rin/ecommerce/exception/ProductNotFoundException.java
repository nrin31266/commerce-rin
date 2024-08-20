package com.rin.ecommerce.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class ProductNotFoundException extends RuntimeException {
    private final String msg;
    public ProductNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
