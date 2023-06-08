package coursework2.controller;

import coursework2.model.Question;
import coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(
            @RequestParam String question,
            @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(
            @RequestParam String question,
            @RequestParam String answer) {
        Question currentQuestion = new Question(question, answer);
        return service.remove(currentQuestion);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
