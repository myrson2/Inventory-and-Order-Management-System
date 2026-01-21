import java.util.Scanner;
import user.*;

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

                            System.out.println("====================");

                            System.out.println("Hi " + name + "! Select Your Role: ");
                            
                            userRole();
                            System.out.print("> ");
                            int userRoleChoice = scanner.nextInt();
                            scanner.nextLine();

                             do{ // As long as userRoleChoice Invalid 
                                switch (userRoleChoice) {
                                    case 1: // Customer Dashboard
                                        User customer = new Customer(id, name, email);
                                            if(customer.login()) {
                                                System.out.println("Successfully Login");
                                            }

                                            System.out.println("====================");

                                        break;
                                
                                    case 2: // Admin Dashboard
                                        User admin = new Admin(id, name, email);
                                            if(admin.login()) {
                                                System.out.println("Successfully Login");
                                            }

                                            System.out.println("====================");

                                            System.out.println("Hi, " + admin.getName() + "! Welcome to Admin Dashboard.");
                                            
                                        break;

                                    default:
                                        System.out.println("Invalid Code.");
                                        break;
                                }
                            }while(userRoleChoice > 3); //valid userRoleChoice

                            System.out.println("====================");

                    break;

                    case 2:
                            System.out.println("Logging Out");
                            scanner.close();
                    break;

                    default:
                        System.out.println("Invalid Code.");
                    break;
                }

            }while(userAuthChoice > 3); // Valid Authentication
        
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
