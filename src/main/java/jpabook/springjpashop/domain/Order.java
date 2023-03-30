package jpabook.springjpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name= "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //Order클래스내 member_id는 fk키로 지정
    private Member member;  //JoinColum 어노테이션 사용시 매핑되 있는 fk의 클래스를 불러와야함

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)  // 1대1 관계에서는 연관관계 주인을 아무나 해도 댐
    @JoinColumn(name = "delivery_id") //Order 클래스내 delivery_id는 fk로 지정
    private Delivery delibery;

    private LocalDateTime orderDate;  //LocalDateTime 클래스 시간 분 초 생성  -> 자바8 기능

    private  OrderState status; // 주문 상태 [ORDER, CENCEL]

    //--연관관계 메서드 --//   => 주로 핵심적으로 컨트롤하는곳에 지정
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    //?? orderItem이 Order와 연관관계인 이유?
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delibery =delivery;
        delibery.setOrder(this);
    }
}
