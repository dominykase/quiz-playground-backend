package exceptions;

public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException(Long id) {
        super("Could not find quiz by id=" + id.toString());
    }
}
