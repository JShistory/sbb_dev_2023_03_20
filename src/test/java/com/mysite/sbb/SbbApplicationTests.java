package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@BeforeEach
	public void before(){
		questionRepository.deleteAll();
		questionRepository.clearAutoIncrement();
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);


		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
//	@Test
//	@DisplayName("create query test")
//	void testJpa1() {
//
//	}

	@Test
	@DisplayName("jpa findAll test")
	void testJpa2(){

		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	@DisplayName("jpa findById test")
	void testJpa3(){
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()){
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?",q.getSubject());
		}
	}

	@Test
	@DisplayName("jpa findBysubject test")
	void testJpa4(){
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
	}

	@Test
	@DisplayName("jpa findBySubjectAndContent test")
	void testJpa5(){
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
	}
}
