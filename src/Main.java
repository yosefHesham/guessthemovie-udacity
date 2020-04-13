public class Main {
    public static void main(String[] args)  throws  Exception{
        String path = "movielist.txt";
        int turns = 0;



            System.out.println("### Game Starts ### ");

            Game game = new Game(path);

            while(!game.gameEnded()) {
              game.inputLetter();
                game.guessLetter();

                if(game.wonGame()) {
                    System.out.println("You Won !!");
                    System.out.println("the title is: " + game.getMovieTitle());
                    break;
                }

            }

            if(!game.wonGame()) {
                System.out.println("You Lost :((");
                System.out.println("the title is: " + game.getMovieTitle());

            }

    }
}
