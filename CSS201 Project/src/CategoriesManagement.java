import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriesManagement {
    Scanner scanner = new Scanner (System.in);
    private List<Categories> category;

    public CategoriesManagement(){
        category = new ArrayList<>();
    }

    public List<Categories> getCategoryList(){
        return category;
    }

    public void createCategories(){
        System.out.println("\n-----Create New Categories-----");
        System.out.println("Enter the name of the category to be created: ");
        String cateName = scanner.nextLine();

        System.out.println("Description: ");
        String description = scanner.nextLine();
        
        Categories ctgr = new Categories(cateName, description);
        category.add(ctgr);
        System.out.println("Create Sucessful.");
    }

    public void editCategories() {
        System.out.println("\n-----Edit Categories-----");
        System.out.println("Enter the category to edit: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < category.size(); i++) {
            Categories currenCategories = category.get(i);

            if (name.equals(currenCategories.getName())){
                System.out.println("Category name: ");
                String setName = scanner.nextLine();

                System.out.println("Decription: ");
                String setDescription = scanner.nextLine();

                category.set(i, new Categories(setName, setDescription));
                System.out.println("Edit Sucessful.");
                found = true;
                break;
                }
            }
            if(!found){
                System.out.println("Not Found.");
            }
    }
    

    public void deleteCategory() {
        System.out.println("\n-----Delete Category-----");
        System.out.println("Enter the category name to be deleted: ");
        String name = scanner.nextLine();
        boolean found = false;

        for(int i = 0; i < category.size(); i++){
            Categories currentCategories = category.get(i);

            if (name.equals(currentCategories.getName())){

                category.remove(i);
                System.out.println("Delete Sucessful");
                found = true;
                break;
            }
        }
        
        if(!found){
            System.out.println("Category not found. Delete Unsuccessful");
        }

    }

    public void displayCategory() {
        System.out.println("\n------All Categories-----");
        int count = 1;
        for (Categories c: category) {
            System.out.println("Categories " + count++ + ":");
            System.out.println(c.getName());
            System.out.println("Description: " + c.getDescription());
            
            System.out.println("Total number of " + c.getName() + " is " + c.calTotalNumber() + "\n");
        }
    }
    
    public void manageCategory(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n[---+----Categories Management----+---]");
            System.out.println("1. Create Category ");
            System.out.println("2. Edit Category ");
            System.out.println("3. Delete Category ");
            System.out.println("4. Display Categories ");
            System.out.println("5. Back to Main Menu");

            System.out.println("Please enter your option:");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCategories();
                    break;
                case 2:
                    editCategories();
                    break;
                case 3:
                    deleteCategory();
                    break;
                case 4:
                    displayCategory();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid input. Please enter the correct number.");
                }
            }
        }

}