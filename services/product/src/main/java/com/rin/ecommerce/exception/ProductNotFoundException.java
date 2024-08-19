package com.rin.ecommerce.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String msg;
    public CustomerNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
