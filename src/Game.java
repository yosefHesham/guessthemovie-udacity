import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Game {
    String path;
    MovieList movieTitle;
    int pointsLost;
    String wrongLetters;
    String rightLetters;
    String title;
    boolean wonGame;
    Game(String path) {
        this.path = path;
        movieTitle = new MovieList(path);
        title = movieTitle.getMovieTitle();
        pointsLost = 0;
        wrongLetters = " ";
        rightLetters = " ";
    }


    public String getMovieTitle() {
        return title;
    }

    public char[] getHiddenMovieTitle() {
        char[] hiddenTitle = getMovieTitle().toCharArray();
        String hiddenT = getMovieTitle();
        if(rightLetters.equals(" ")) {
            for(int i = 0; i < hiddenTitle.length; i ++ ){
                hiddenTitle[i] = '_';
            }
            return hiddenTitle;
        } else {
            int index = hiddenT.indexOf(rightLetters);
            System.out.println(index);
            hiddenTitle[index] = rightLetters.charAt(0);
            return  hiddenTitle;
        }
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public boolean wonGame(){
        return  wonGame;
    }

    public boolean gameEnded(){
        if(pointsLost >= 10) {
            return  true;
        }
        if(Arrays.equals(getHiddenMovieTitle(), getMovieTitle().toCharArray())) {
                wonGame  = true;
                return true;
        }
        return false;
    }

    public String inputLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("You Are Guessing: ");
        System.out.println();
        char[] hiddenTitle = getHiddenMovieTitle();
        for(int i  = 0; i < hiddenTitle.length; i ++) {
            System.out.printf("%c ", hiddenTitle[i]);
        }
        System.out.println("You have guessed (" + pointsLost + ") wrong letters" + wrongLetters );
        System.out.println("Guess a letter: ");
        String guessInput = scanner.nextLine();
        return  guessInput;
    }

    public void guessLetter() {

        char guess = inputLetter().charAt(0);
        boolean isEqual = false;
        for(int i = 0; i <getMovieTitle().toCharArray().length; i ++) {
            if(guess == getMovieTitle().toCharArray()[i]) {
                getHiddenMovieTitle()[i] = guess;
                isEqual = true;
            }
        }
        if(isEqual == true) {
            rightLetters = inputLetter();
        }
        else if(isEqual == false) {
            pointsLost ++;
            wrongLetters += " " + inputLetter();

        }

    }


}
