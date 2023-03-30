package jpabook.springjpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
public class Member {
    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;
    private String name;

    @Embedded //내장타입을 등록했다는 의미
    private Address address;

    @OneToMany(mappedBy = "member") // Order 테이블에 있는 Member 필드에 의해 매핑 됨
                                    //내가 매핑하는게 아닌 매핑된 상태이다.. 읽기 전용??
    private List<Order> orders = new ArrayList<>();
}
