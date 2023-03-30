package jpabook.springjpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable  //어딘가에 내장이 될수 있다는 가독성을 위해 사용
@Getter @Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
