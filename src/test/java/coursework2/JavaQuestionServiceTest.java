package coursework2;

import coursework2.model.Question;
import coursework2.service.JavaQuestionService;
import coursework2.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaQuestionServiceTest {
    QuestionService expectedService = new JavaQuestionService();

    @BeforeEach
    void addElements() {
        expectedService.add("qu1", "an1");
        expectedService.add("qu2", "an2");
        expectedService.add("qu3", "an3");
        expectedService.add("qu4", "an4");
    }

    @Test
    void add() {
        QuestionService actualService = new JavaQuestionService();
        actualService.add("qu1", "an1");
        actualService.add("qu2", "an2");
        actualService.add("qu3", "an3");
        actualService.add("qu4", "an4");

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void testAdd() {
        QuestionService actualService = new JavaQuestionService();
        Question question1 = new Question("qu1", "an1");
        Question question2 = new Question("qu2", "an2");
        Question question3 = new Question("qu3", "an3");
        Question question4 = new Question("qu4", "an4");

        actualService.add(question1);
        actualService.add(question2);
        actualService.add(question3);
        actualService.add(question4);

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void remove() {
        expectedService.remove(new Question("qu2", "an2"));
        expectedService.remove(new Question("qu4", "an4"));

        QuestionService actualService = new JavaQuestionService();
        actualService.add("qu1", "an1");
        actualService.add("qu3", "an3");

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question question = expectedService.getRandomQuestion();
        assertThat(expectedService.getAll().contains(question))
                .isTrue();
    }
}
