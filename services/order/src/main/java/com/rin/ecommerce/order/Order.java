package com.rin.ecommerce.order;

import com.rin.ecommerce.orderline.OrderLine;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue
    Integer id;
    String reference;
    BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
    String customerId;
    @OneToMany(mappedBy = "order")
    List<OrderLine> orderLines;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    LocalDateTime createDate;
    @LastModifiedDate
    @Column(insertable = false)
    LocalDateTime lastModifiedDate;

}
