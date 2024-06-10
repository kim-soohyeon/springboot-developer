package me.kimsoohyeon.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")//test 수행 전 sql 스크립트 실행
    @Test
    void getAllMembers(){
        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")//test 수행 전 sql 스크립트 실행
    @Test
    void getMemberById(){
        //when
        Member member = memberRepository.findById(2L).get();

        //then
        assertThat(member.getName()).isEqualTo("B");
    }

    @Sql("/insert-members.sql")//test 수행 전 sql 스크립트 실행
    @Test
    void getMemberByName(){
        //when
        Member member = memberRepository.findByName("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Test
    void saveMember(){
        //given
        Member member = new Member(1L, "A");

        //when
        memberRepository.save(member);

        //then
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }

    @Test
    void saveMembers(){
        //given
        List<Member> members = List.of(new Member(2L, "B"),
                new Member(3L, "C"));

        //when
        memberRepository.saveAll(members);

        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")//test 수행 전 sql 스크립트 실행
    @Test
    void deleteMemberById(){
        //when
        memberRepository.deleteById(2L);

        //then
//        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();

        assertThat(memberRepository.findById(2L)).isEmpty();
    }
}