import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CraftsManagement {
    Scanner scanner = new Scanner(System.in);
    private List<Crafts> crafts;
    private List<Categories> categories;
    Crafts craft = new Crafts("Guinea Pig Ceramic Bowl", 50, 65.90, "ceramics", "Pottery, or ceramic art, belongs to the traditional crafts of mankind, involving manufacturing, coloring and repairing techniques. Plus cute guinea pig shape.");

    public CraftsManagement() {
        crafts = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public void addCraft() {
        System.out.println("\n-----Add craft-----");
        System.out.println("Enter the name of the craft to be created: ");
        String name = scanner.nextLine();

        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();

        System.out.println("Price: ");
        double price = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Enter category:");
        String category = scanner.nextLine();
        boolean found = false;
        for(int i = 0; i < categories.size(); i++){
            Categories currentCategories = categories.get(i);

            if (category.equals(currentCategories.getName())){
                currentCategories.calTotalNumber();
                found = true;
                break;
            }
            if (!category.equals(currentCategories.getName())){
                categories.add(new Categories(name, category));
            }
        }

        System.out.println("Crafts Decription: ");
        String description = scanner.nextLine();
        
        Crafts craft1 = new Crafts(name, quantity, price, category, description);

        System.out.println("Price Range: " + craft1.getPriceRange());

        crafts.add(craft1);
        crafts.add(craft);

        
        System.out.println("Add Sucessful.");
    }

    public void editCraft(){
        System.out.println("-----Edit Craft-----");
        System.out.println("Enter the name of the craft to edit: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < crafts.size(); i++){
            Crafts currentCrafts = crafts.get(i);

            if (name.equals(currentCrafts.getName())){
                System.out.println("Name: ");
                String setName = scanner.nextLine();

                System.out.println("Quantity: ");
                int setQuantity = scanner.nextInt();

                System.out.println("Price: ");
                double setPrice = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("Category: ");
                String setCategories = scanner.nextLine();
                
                System.out.println("Crafts Decription: ");
                String setCraftsDescription = scanner.nextLine();

                

                Crafts craft1 = new Crafts(setName, setQuantity, setPrice, setCategories, setCraftsDescription);

                crafts.set(i, craft1);
                System.out.println("Price Range: "  + craft1.getPriceRange());

                System.out.println("Edit Sucessful.");
                found = true;
                break;
            }     
        }
        if(!found){
                System.out.println("Not Found.");
        }
    }

    public void searchCrafts() {
        System.out.println("------Search Craft-----");
        System.out.println("Enter the name of the search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for(int i = 0; i < crafts.size(); i++){
            Crafts currentCrafts = crafts.get(i);
            
            if(name.equals(currentCrafts.getName())){
                System.out.println("Name: " + currentCrafts.getName());
                System.out.println("Quantity: " + currentCrafts.getQuantity());
                System.out.println("Price: " + currentCrafts.getPrice());
                System.out.println("Category: " + currentCrafts.getCategories());
                System.out.println("Crafts Decription: " + currentCrafts.getCraftsDescription());
                System.out.println("Price Range: " + currentCrafts.getPriceRange());
                
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Not Found.");
        }
    }

    public void manageCraft(){
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("\n[---+----Craft Management---+----]");
                System.out.println("1. Add Crafts ");
                System.out.println("2. Edit Crafts ");
                System.out.println("3. Search Crafts ");
                System.out.println("4. Back to Main Menu");
    
                System.out.println("Choice the option:");
                
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addCraft();
                        break;
                    case 2:
                        editCraft();
                        break;
                    case 3:
                        searchCrafts();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid input. Please enter the correct number.");
                    }
                }
            }
}