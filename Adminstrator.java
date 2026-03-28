import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adminstrator extends User {
    private List<User>users;
    private Authentication au;
    Scanner scanner = new Scanner(System.in);

    public Adminstrator(String username, String password){
        super(username, password);
        users = new ArrayList<>();
        this.au = new Authentication();
    }

    @Override
    public String verifyLogin(String loginName, String loginPassword){
        if (getUsername().equals(loginName) && getPassword().equals(loginPassword)){
            au.setLoginStatus(true);
            return "Admin Login Success";
        } else {
            return "Unsuccessful Admin Login!";
        }
    }

    public void addUser(){
        System.out.println("\n-----Add User-----");
        System.out.println("Enter a new username:");
        String username = scanner.nextLine();
        System.out.println("Enter new password:");
        String password = scanner.nextLine();
        au.registerUser(username, password);

        User u = new User(username, password) {
            @Override
            public String verifyLogin(String loginName, String loginPassword) {
                if (getUsername().equals(loginName) && getPassword().equals(loginPassword)) {
                    au.setLoginStatus(true);
                    return "Admin Login Success!";
                }
                return "Please enter valid ursername and password.";
            }
        };

        users.add(u);
        System.out.println("User added successfully ~");
    }

    public void removeUser(){
        System.out.println("\n-----Delete User-----");
        System.out.println("Please enter username you want to delete:");
        String username = scanner.nextLine();

        boolean found = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("User removed successful!");
        } else {
            System.out.println("Sorry, cannot found this username.");
        }
    }

    public void editUser(){
        System.out.println("\n-----Edit User-----");
        System.out.println("Enter username to edit:");
        String username = scanner.nextLine();

        boolean found = false;
    
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Enter new username:");
                String newUsername = scanner.nextLine();
                System.out.println("Enter new password:");
                String newPass = scanner.nextLine();
            
                user.setUsername(newUsername);
                user.setPassword(newPass);
                System.out.println("User updated successfully!");

                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Sorry, username not found.");
        }
    }

    public void displayUsers(){
        System.out.println("\n-----User List-----");
            int count = 1;
            for(User u : users){
                System.out.println(count+"."+ u.getUsername());
                count++;
            }
        if(users.isEmpty()){
            System.out.println("No user in the list!");
        }

    }

    public void AdminMenu(){
        
        while (true) {
            System.out.println("\n[---+---Welcome to User Management---+---]");
            System.out.println("1. Add Users");
            System.out.println("2. Remove Users");
            System.out.println("3. Edit Users");
            System.out.println("4. Display User List");
            System.out.println("5. Back to Main Menu");
            System.out.println("Please enter your option:");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    if (!au.getloginStatus()) {
                        System.out.println("Please login first!");
                        break;
                    }
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    editUser();
                    break;
                case 4:
                    displayUsers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }

    }
}
