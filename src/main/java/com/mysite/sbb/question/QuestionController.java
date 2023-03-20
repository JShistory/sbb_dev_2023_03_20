package com.mysite.sbb.question;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequiredArgsConstructor
//@RequiredArgsConstructor는 롬복이 제공하는 애너테이션으로
// final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할을 한다
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }
}
