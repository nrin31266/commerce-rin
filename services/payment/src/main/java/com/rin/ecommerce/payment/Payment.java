package com.rin.ecommerce.payment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    Integer id;
    BigDecimal amount;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
    Integer orderId;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    LocalDateTime createDate;
    @LastModifiedDate
    @Column(insertable = false)
    LocalDateTime lastModifiedDate;


}
