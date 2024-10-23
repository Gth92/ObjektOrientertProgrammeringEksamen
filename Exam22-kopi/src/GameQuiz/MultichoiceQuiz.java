package GameQuiz;

import java.sql.*;
import java.util.*;


public class MultichoiceQuiz extends Quiz {
    public int id;
    public String question;
    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String correctAnswer;

    public MultichoiceQuiz() {
    }


    public MultichoiceQuiz(int id, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
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

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public  ArrayList showQuestion() throws SQLException {
        ArrayList<MultichoiceQuiz> al = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            String qry = "select * from multichoiceQuiz";
            PreparedStatement ps = conn.prepareStatement(qry);
            ResultSet rs = ps.executeQuery();
            MultichoiceQuiz p;
            while (rs.next()) {
                p = new MultichoiceQuiz();
                p.setId(rs.getInt(1));
                p.setQuestion(rs.getString(2));
                p.setAnswerA(rs.getString(3));
                p.setAnswerB(rs.getString(4));
                p.setAnswerC(rs.getString(5));
                p.setAnswerD(rs.getString(6));
                //   p.setCorrectAnswer(rs.getString(7));
                al.add(p);
            }
        } else {

            System.out.println("Database issue , could not connect to DB");

        }

        return al;
    }

    @Override
    public boolean isCorrectAnswer (String answer){
        return this.getCorrectAnswer().equalsIgnoreCase(answer);

    }



    @Override
    public String toString() {
        return "MultichoiceQuiz{" +
                ", question='" + question + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                '}';
    }
}
