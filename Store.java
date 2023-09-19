import java.util.ArrayList;

public class Store {

    ArrayList<Movie> movies;

    public Store(){
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index){
        return new Movie(this.movies.get(index));
    }

    public Movie getMovie(String name){
        for (int i = 0; i < this.movies.size(); i++) {
            if(this.movies.get(i).getName().equals(name)){
                return new Movie(this.movies.get(i));
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie){
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    public void action(String name, String action){
        if(movies.isEmpty()){
            throw new IllegalArgumentException("There are no movies available!");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be empty!");
        }
        if(!(action == "sell" || action == "rent" || action == "return")){
            throw new IllegalArgumentException("The action must be either sell, rent or return!");
        }
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)){
                switch (action){
                    case "sell":
                        if(!(this.movies.get(i).getIsAvailable())){
                            throw new IllegalStateException("The movie is not available to be bought!");
                        }
                        this.movies.remove(i); break;
                    case "rent": this.movies.get(i).setIsAvailable(false); break;
                    case "return": this.movies.get(i).setIsAvailable(true); break;
                }
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
}
