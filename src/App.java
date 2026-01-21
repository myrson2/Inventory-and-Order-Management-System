import java.util.Scanner;
import user.User;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== WELCOME TO INVENTORY AND MANAGEMENT SYSTEM =====");

        int userAuthChoice = 0;
        do{ // start user Authentication 
            userAuthentication();
            System.out.print("> ");
            userAuthChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("====================");

            User user = new User();

            do{ // As long as invalid 
                switch(userAuthChoice){
                    case 1:
                        System.out.println("=== Login ===");

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        if(user.login()){
                            System.out.println("Successfully login.");
                        }

                        user = new User(id, name, email);

                    break;

                    case 2:
                        if(user.logout()){
                            System.out.println("Logging Out");
                            scanner.close();
                        }
                    break;

                    default:
                        System.out.println("Invalid Code.");
                    break;
                }

            }while(userAuthChoice > 3); // Valid Authentication

            System.out.println("====================");

            //Performing Role Action
            System.out.println("Hi " + user.getName() + "! Select Your Role: ");
            
            userRole();
            System.out.println("> ");
            int userRoleChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("====================");

            do{ // As long as userRoleChoice Invalid 
                switch (userRoleChoice) {
                    case 1: // Customer Dashboard
                        
                        break;
                
                    case 2: // Admin Dashboard
                        System.out.println("===== Welcome to Admin Dashboard =====");
                        adminDashboardMenu();
                        break;

                    default:
                        System.out.println("Invalid Code.");
                        break;
                }
            }while(userRoleChoice > 3); //valid userRoleChoice
        
        } while(userAuthChoice != 2); // end user authentication

        System.out.println("End System.");
    }

    static void userAuthentication(){
        System.out.println("1. login");
        System.out.println("2. logout");
    }

    static void userRole(){
        System.out.println("1. Customer");
        System.out.println("2. Admin");
    }

    static void adminDashboardMenu(){
        System.out.println("1. Add Product");
        System.out.println("2. Update Stock");
        System.out.println("3. View All Orders");
    }
}
