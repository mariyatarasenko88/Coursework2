package coursework2.service;

import coursework2.exception.BigSizeAmountException;
import coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
    public class  ExaminerServiceImpl implements ExaminerService {
        private Random random;
        private final QuestionService questionService;

        ExaminerServiceImpl(QuestionService questionService) {
            this.questionService = questionService;
        }

        @Override
        public Collection<Question> getQuestions(int amount) {
            if (amount > questionService.getAll().size()) {
                throw new BigSizeAmountException("Превышен лимит вопросов");
            }

            Set<Question> resultQuestions = new HashSet<>();
            while (resultQuestions.size() < amount) {
                resultQuestions.add(questionService.getRandomQuestion());
            }

            return resultQuestions;
        }
    }
