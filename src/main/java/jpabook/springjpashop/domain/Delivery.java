package jpabook.springjpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery") //order클래스로 부터 매핑이 됨
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(value = EnumType.STRING) // enum 타입 사용시 무족건 @Enumerated 사용
    private DeliveryStatus status; // READY, COMP
}
