package jpabook.springjpashop.domain;

import jpabook.springjpashop.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue()
    @Column(name = "order_item_id")

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id") // Order 클래스의 Pk값인 order_id에 매핑 fk 지정
    private  Order order;

    private int orderPrice;
    private int count;

}
