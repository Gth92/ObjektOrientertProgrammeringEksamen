package MainJava;

import GameQuiz.BinaryQuiz;
import GameQuiz.MultichoiceQuiz;
import GameQuiz.UserScore;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        MultichoiceQuiz mt = new MultichoiceQuiz();//initiate class MultichoiceQuiz
        BinaryQuiz bq = new BinaryQuiz();//initiate class BinaryQuiz
        UserScore us = new UserScore();//initiate class UserScore
        Scanner sc = new Scanner(System.in);//initiate class Scanner for inputs
        int score=0;
        String user;
        String answer;
        char choice;

        try {
            System.out.println("1. Sign up a new user: ");
            user = sc.nextLine();
            //us.setUser(user);
            System.out.println("Choose Quiz topic:\n" +
                    "A. Music (Multichoice Quiz)\n" +
                    "B. Movie (Binary Quiz)");
            choice = sc.nextLine().toUpperCase().charAt(0);//read the choice

            //  System.out.println("1 user: " + user);
            // System.out.println("1. choice: " + choice);

            if (choice == 'A') {//when the choice is Music

                System.out.println(" Welcome to the Music quiz: ");

                mt.showQuestion();//get the question and answer choices
                mt.toString();// display the question and answer choices
                answer = sc.nextLine(); //read the answer
                boolean check= mt.isCorrectAnswer(answer);// check the answer if the correct
                char return1= checkAnswer(check,score,us,user);//check the answer and update the score (this function is defined below)
                checkReturnOfCheckAnswer(return1,us);//check the return of the function checkAnswer (this function is defined below)

            } else if (choice == 'B') {//when the choice is Movie
                System.out.println(" Welcome to the Movie quiz: ");
                bq.showQuestion();//get the question and answer choices
                bq.toString();// display the question and answer choices
                answer = sc.nextLine(); //read the answer
                boolean check= bq.isCorrectAnswer(answer);// check the answer
                char return1= checkAnswer(check,score,us,user);//check the answer and update the score (this function is defined below)
                checkReturnOfCheckAnswer(return1, us);// check the return of the function checkAnswer (this function is defined below)
            } else {//when the choice is not Music or Movie the program stop
                System.out.println("wrong choice,  the game is stopping now ...");

            }
        }
        catch (Exception Exception){//exception in case of error in the main program
            System.out.println(" Oops ! System Error please try later :/ ");
            Exception.printStackTrace();
        }
    }

    //method checkAnswer  that check the answer of the question and update the score
    public static  char   checkAnswer(boolean check , int score, UserScore us, String user) throws SQLException {
        us = new UserScore();
        Scanner sc = new Scanner(System.in);
        char choice;
        if (check == true){
            score++;
            System.out.println("Your answer is correct! Would you like to:\n" +
                    "A: Continue with next question\n" +
                    "B: Exit current round");
            choice =sc.nextLine().toUpperCase().charAt(0);

        }else{
            System.out.println(" Your answer is wrong!");
            System.out.println("Your final score is "+ score +"out of 4! The score board is as below:");

            us.getAllScoresForCurrentUser(user);//get the score of the current user
            us.toString();//diplay the result of getAllScoresForCurrentUser

            System.out.println("\n You have following options:\n" +
                    "C: Continue with another round\n" +
                    "D: More options\n" +
                    "E: Exit the game ");
            choice =sc.nextLine().toUpperCase().charAt(0);
        }
        return choice;
    }

    //method checkReturnOfCheckAnswer that check the return choice of the function checkAnswer
    public static void checkReturnOfCheckAnswer(char choice,UserScore us) throws SQLException {
        us= new UserScore();
        switch(choice) {
            case 'A':
                System.out.println("Continue with next question ");
                break;
            case 'B':
                System.out.println("Exit current round ");
                break;
            case 'C':
                System.out.println("Continue with another round ");
                break;
            case 'D':

                System.out.println("More options ");
                moreOptionChoice(us);//display more option
                break;
            case 'E':
                System.out.println("Bye and Welcome back! ...");
                System.exit(0);//exit the program
                break;
            default:
                System.out.println("Wrong choice , the game is stopping now ...");
                System.exit(0);//exit the program
        }
    }

    //method moreOptionChoice to display and handle the More option choice
    public static void moreOptionChoice(UserScore us) throws SQLException {
        us= new UserScore();
        Scanner sc = new Scanner(System.in);
        String user_name;
        char choice;
        System.out.println("You have below options:\n" +
                "A. List all scores for a user \n" +
                "B. List all score records >= 3 for Tennis \n"+
                "C. Continue with another round \n"+
                "E: Exit the game ");

        choice =sc.nextLine().toUpperCase().charAt(0);

        switch(choice) {
            case 'A':
                System.out.println("List all scores for a user below ");

                us.getAllScoresForUser();//get the result for a list of all scores for a user entered
                us.toString();// display the result of getAllScoresForUser
                break;
            case 'B':
                System.out.println("List all score records >= 3 for Tennis");
                us.getAllScoresForTenisAbove3();//get the result for a list all score records >= 3 for Tennis
                us.toString();// display the result of getAllScoresForTenisAbove3
                break;
            case 'C':
                System.out.println("Continue with another round");

                break;
            case 'E':
                System.out.println("Bye and Welcome back! ...");
                System.exit(0);//exit the program
                break;
            default:
                System.out.println("Wrong choice , the game is stopping now ...");
                System.exit(0);//exit the program
        }


    }

}

