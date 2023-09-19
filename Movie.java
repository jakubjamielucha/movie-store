public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Provide correct name!");
        }
        if(!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Provide correct format! DVD or Blue-Ray");
        }
        if(rating < 0 || rating > 10 ){
            throw new IllegalArgumentException("Provide correct rating, must be higher than 0 and lower than 10!");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        isAvailable = true;
    }

    public Movie(Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }

    @Override
    public String toString() {
        return  "Name = " + name +
                "\nFormat = " + format +
                "\nRating = " + rating +
                "\nSelling Price = " + sellingPrice +
                "\nRental Price = " + rentalPrice +
                "\nIs Available = " + isAvailable;
    }

    public String getName() {
        return this.name;
    }

    public String getFormat() {
        return this.format;
    }

    public double getRating() {
        return rating;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Provide correct name!");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if(!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Provide correct format! DVD or Blue-Ray");
        }
        this.format = format;
        setRentalPrice(format.equals("Blue-Ray") ? 1.99 : 0.99);
        setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
    }

    public void setRating(double rating) {
        if(rating < 0 || rating > 10 ){
            throw new IllegalArgumentException("Provide correct rating, must be higher than 0 and lower than 10!");
        }
        this.rating = rating;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
