package GameQuiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BinaryQuiz extends Quiz
{
    public int id;
    public String question;
    public String correctAnswer;


    public BinaryQuiz() {

    }



    public BinaryQuiz(int id, String question, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public  ArrayList showQuestion() throws SQLException {
        ArrayList<BinaryQuiz> al = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String qry = "select * from binaryQuiz";
        PreparedStatement ps = conn.prepareStatement(qry);
        ResultSet rs = ps.executeQuery();
        BinaryQuiz p;
        while (rs.next()) {
            p = new BinaryQuiz();
            p.setId(rs.getInt(1));
            p.setQuestion(rs.getString(2));
            //    p.setCorrectAnswer(rs.getString(3));
            al.add(p);

        }

        return al;
    }

    @Override
    public boolean  isCorrectAnswer(String answer) {
        return this.getCorrectAnswer().equalsIgnoreCase(answer);

    }


    @Override
    public String toString() {
        return "BinaryQuiz{" +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}