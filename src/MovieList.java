import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class MovieList {

    String path;
    String title;
    List list;
    int index;
    MovieList(String path) {
        this.path = path;
        list = new ArrayList();
        index = 0;
    }


     public String  getMovieTitle() {
        try {
            File file = new File(path);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line.trim());
            }
            Random random = new Random();
             index = random.nextInt(list.size());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Missing");
        }

        title = list.get(index).toString();
        title = title.replaceAll("\\s", "");
        return  title;
    }






}
