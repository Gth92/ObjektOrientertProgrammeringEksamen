package GameQuiz;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class   Quiz {


    abstract ArrayList showQuestion() throws SQLException;


    abstract boolean  isCorrectAnswer(String answer);
}
