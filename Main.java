import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {

    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try{
            loadMovies("movies.txt");
            System.out.println("\nMOVIES LOADED!\n\n");
            System.out.println(store);
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void manageMovies(){
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.print("Menu:\n\na) purchase\nb) rent\nc) return\nd) exit\n\nYour choice: ");
        String option = scan.nextLine();
        if(!(option.equals("a") || option.equals("b") || option.equals("c"))){
            scan.close();
            break;
        }
        System.out.println("\nWrite movie's name: ");
        String name = scan.nextLine();
        if(store.getMovie(name) == null){
            System.out.println("Please provide the correct name of the movie!\n");
            continue;
        }

        switch(option){
            case "a":
                if(!(store.getMovie(name).getIsAvailable())){
                    System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                    continue;
                }
                store.action(name, "sell"); break;
            case "b": store.action(name, "rent"); break;
            case "c": store.action(name, "return"); break;
        }
            System.out.println("UPDATED MOVIES:" + store);

    }}

    public static void loadMovies(String fileName) throws FileNotFoundException {
    FileInputStream fis = new FileInputStream(fileName);
    Scanner scanFile = new Scanner(fis);

    while(scanFile.hasNextLine()){
        String line = scanFile.nextLine();
        String[] words = line.split("--");
        store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
    }
    scanFile.close();


}
}
