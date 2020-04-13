public class Main {
    public static void main(String[] args)  throws  Exception {
        String path = "movielist.txt";
        int turns = 0;


        System.out.println("### Game Starts ### ");

        Game game = new Game(path);
        System.out.println(game.title);
        while (!game.gameEnded()) {
            game.talktoUser();
            game.guessLetter();

        }

        if(game.wonGame()) {
            System.out.println("You Won !!");
            System.out.println("the title is: " + game.title);
        }
        if(!game.wonGame()) {
            System.out.println("You Lost :((");
            System.out.println("the title is: " + game.title);

        }




    }
}
