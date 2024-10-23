package GameQuiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserScore {
    public int id;
    public  String user;
    public int score;
    public  String topic;

    public UserScore() {
    }

    public UserScore(int id, String user, int score, String topic) {
        this.id = id;
        this.user = user;
        this.score = score;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    public ArrayList getAllScoresForUser() throws SQLException {      ArrayList <UserScore> al=new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter the user name:");
        String user = sc.next();
        Connection conn=DBConnection.getConnection();
        String qry="select * from scoreHistory where User=?";
        PreparedStatement ps=conn.prepareStatement(qry);

        ps.setString(1,user);
        ResultSet rs=ps.executeQuery();
        UserScore p;
        while(rs.next()){
            p=new UserScore();
            p.setId(rs.getInt(1));
            p.setUser(rs.getString(2));
            p.setScore(rs.getInt(3));
            p.setTopic(rs.getString(4));

            al.add(p);


        }

        return al;
    }

    public  ArrayList getAllScoresForTenisAbove3() throws SQLException{      ArrayList <UserScore> al=new ArrayList<>();

        Connection conn=DBConnection.getConnection();
        String qry="select * from scoreHistory where topic='Tenis' and score >= 3 ";
        PreparedStatement ps=conn.prepareStatement(qry);

        ps.setString(1,user);
        ResultSet rs=ps.executeQuery();
        UserScore p;
        while(rs.next()){
            p=new UserScore();
            p.setId(rs.getInt(1));
            p.setUser(rs.getString(2));
            p.setScore(rs.getInt(3));
            p.setTopic(rs.getString(4));

            al.add(p);


        }

        return al;
    }
    public  void getAllScoresForCurrentUser(String user) throws SQLException{

        Connection conn=DBConnection.getConnection();
        String qry="select * from scoreHistory where User=?";
        PreparedStatement ps=conn.prepareStatement(qry);

        ps.setString(1,user);
        ResultSet rs=ps.executeQuery();
        UserScore p;
        while(rs.next()){
            p=new UserScore();
            p.setId(rs.getInt(1));
            p.setUser(rs.getString(2));
            p.setScore(rs.getInt(3));
            p.setTopic(rs.getString(4));




        }


    }
    @Override
    public String toString() {
        return "UserScore{" +
                ", user='" + user + '\'' +
                ", score=" + score +
                ", topic='" + topic + '\'' +
                '}';
    }
}
