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
    char[] hiddenT;
    boolean wonGame;
    Game(String path) {
        this.path = path;
        movieTitle = new MovieList(path);
        title = movieTitle.getMovieTitle();
        hiddenT = title.toCharArray();
        wrongLetters = " ";
        rightLetters = " ";
    }



    public char[] getHiddenMovieTitle() {

        if(rightLetters.equals(" ")) {
            for(int i = 0; i < title.toCharArray().length; i ++ ){
                hiddenT[i] = '_';
            }
            return hiddenT;
        } else {
            for(int i = 0; i < title.toCharArray().length; i ++ ){
                if(title.toCharArray()[i]== rightLetters.charAt(0)) {
                    hiddenT[i]  = rightLetters.charAt(0);
                }
            }
            return hiddenT;
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
        if(Arrays.equals(getHiddenMovieTitle(), title.toCharArray())) {
                wonGame  = true;
                return true;
        }
        return false;
    }




    public void guessLetter() {

        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine();

        System.out.println(" +++ "  + title.indexOf(guess));
        if(title.indexOf(guess) >= 0){
                rightLetters = guess;
        }

        else  {
            pointsLost ++;
            wrongLetters += " " + guess;

        }



    }

    public void talktoUser() {

        System.out.printf("You Are Guessing: ");
        char[] hiddenTitle = getHiddenMovieTitle();
        for(int i  = 0; i < hiddenTitle.length; i ++) {
            System.out.printf("%c ", hiddenTitle[i]);
        }
        System.out.println();
        System.out.println("You have guessed (" + pointsLost + ") wrong letters: " + wrongLetters );
        System.out.println("Guess a letter: ");
    }

}
