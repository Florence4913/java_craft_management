import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Authetication for initial Admin
        Adminstrator admin1 = new Adminstrator("Bob", "pass246");
        Authentication auth = new Authentication();

        CategoriesManagement cateMana = new CategoriesManagement();
        CraftsManagement crafM = new CraftsManagement();

        boolean loggedIn = false;
        while(!loggedIn){
            System.out.println("\nPlease login first before enter Management System:");
            System.out.println("Enter username: ");
            String adminName = scanner.nextLine();
            System.out.println("Enter password: ");
            String adminPwd = scanner.nextLine();

            if (admin1.verifyLogin(adminName, adminPwd).contains("Success")) {
                System.out.println("Admin Login Success!");
                auth.setLoginStatus(true);

                while (true) {
                    System.out.println("\n******Welcome to Kuching Craft Management******");
                    System.out.println("1. User Management");
                    System.out.println("2. Categories Management");
                    System.out.println("3. Crafts Management");
                    System.out.println("4. Exit or enter 'E' to exit~");
                    System.out.println("Please enter your option:");

                    String inputE = scanner.nextLine();

                    if(inputE.equalsIgnoreCase("E")){
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();

                        return;
                    }
                
                    int choice = Integer.parseInt(inputE);
                    switch (choice){
                        case 1:
                            admin1.AdminMenu();
                            break;
                        case 2:
                            cateMana.manageCategory();
                            break;
                        case 3:
                            crafM.manageCraft();
                            break;
                        case 4:
                            System.out.println("Exiting the system. Goodbye!");
                                
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter 1-4.");
                    }
                }   
            }else {
            System.out.println("Login failed. Please try again.");
            } 
        }
        scanner.close();
    }
}