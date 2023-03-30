package jpabook.springjpashop;

import jpabook.springjpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository  // Entity를 찾아주는 것  Component scan 대상
public class MemberRepository {
    @PersistenceContext  //스프링부트가 emManger를 주입해줌
    private EntityManager em;

    public  Long save(Member member){
        em.persist(member);
        return  member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }


}
