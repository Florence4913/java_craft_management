public class Crafts {
    private String name;
    private int quantity;
    private double price;
    private String category;
    private String craftsDescription;

    public Crafts (String name, int quantity, double price, String category, String craftsDescription) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.craftsDescription = craftsDescription;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if (price < 0) throw new IllegalArgumentException ("Error: Invalid input. Please put the positive number.");
        this.price = price;
    }

    public String getCraftsDescription(){
        return craftsDescription;
    }

    public void setCraftsDescription(String craftsDescription){
        this.craftsDescription = craftsDescription;
    }

    public String getPriceRange(){
        if (price < 20){
            return "Low";
        } else if (price < 80){
            return "Medium";
        } else {
            return "High";
        }
        
    }

    public String getCategories(){
        return category;
    }

    public void setCategories(String category){
        this.category = category;
    }

}