package coursework2;

import coursework2.exception.BigSizeAmountException;
import coursework2.model.Question;
import coursework2.service.ExaminerServiceImpl;
import coursework2.service.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private final Set<Question> questions = new HashSet<>();

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void addElements() {
        questions.add(new Question("qu1", "an1"));
        questions.add(new Question("qu2", "an2"));
        questions.add(new Question("qu3", "an3"));
        questions.add(new Question("qu4", "an4"));
        Mockito.when(questionService.getAll()).thenReturn(questions);
    }

    @Test
    void getQuestionsPositive() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(new ArrayList<>(questions).get(1));

        Set<Question> actual = new HashSet<>();
        actual.add(new Question("qu4", "an4"));

        Assertions.assertThat(examinerService.getQuestions(1))
                .isEqualTo(actual);
    }

    @Test
    void getQuestionsNegative() {
        Assertions.assertThatExceptionOfType(BigSizeAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(7))
                .withMessage("Превышен лимит вопросов");
    }

}
