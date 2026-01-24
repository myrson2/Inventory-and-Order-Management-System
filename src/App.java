import java.util.Scanner;
import java.time.LocalDate;
import user.*;
import product.*;

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
                                            System.out.println("Hi, " + customer.getName() + "! Welcome to Customer Dashboard.");
                                            customer.performRoleAction();

                                            int customerChoice = 0;

                                            do{ // customer menu
                                                customerDashBoardMenu();
                                                System.out.println("> ");
                                                customerChoice = scanner.nextInt();
                                                scanner.nextLine();

                                                switch(customerChoice){
                                                    case 1: // View available products
                                                        System.out.println("===== Available Produucts =====");
                                                    break;

                                                    case 2: // Place orders
                                                    break;

                                                    case 3: // View order details
                                                    break;

                                                    default:
                                                    break;
                                                }
                                            }while(customerChoice != 0); // end customer menu
                                            
                                        break;
                                
                                    case 2: // Admin Dashboard
                                        Admin admin = new Admin(id, name, email); // Changed User to Admin
                                            if(admin.login()) {
                                                System.out.println("Successfully Login");
                                            }

                                            System.out.println("====================");

                                            System.out.println("Hi, " + admin.getName() + "! Welcome to Admin Dashboard.");
                                            admin.performRoleAction();

                                            int adminChoice = 0;

                                            do{ // Admin Menu
                                                adminDashboardMenu();
                                                System.out.print("> ");
                                                adminChoice = scanner.nextInt();
                                                scanner.nextLine();

                                                switch(adminChoice){
                                                    case 1: // Add product
                                                        System.out.println("\n===== Add Product =====");
                                                        
                                                        System.out.print("Name: ");
                                                        String productName = scanner.nextLine();

                                                        System.out.print("Price: ");
                                                        double productPrice = scanner.nextDouble();
                                                        scanner.nextLine();

                                                        System.out.print("Quantity: ");
                                                        int productQuantity = scanner.nextInt();
                                                        scanner.nextLine();

                                                        System.out.println("\n Product Type: \n 1. Non-Perishable || 2. Perishable");
                                                        int productType = scanner.nextInt();
                                                        scanner.nextLine();

                                                        Product product = null;

                                                        switch (productType) { // Validation of Product Type
                                                            case 1:
                                                                System.out.println("Warannty (Months): ");
                                                                int months = scanner.nextInt();
                                                                scanner.nextLine();

                                                                product = new NonPerishableProduct(productName, productPrice, productQuantity, months);   
                                                                admin.addProduct(product);
                                                            break;

                                                            case 2:
                                                                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                                                                String dateInput = scanner.nextLine();
                                                                LocalDate expirationDate = LocalDate.parse(dateInput);

                                                                product = new PerishableProduct(productName, productPrice, productQuantity, expirationDate);   
                                                                admin.addProduct(product);
                                                            break;
                                                        
                                                            default:
                                                                System.out.println("Invalid");
                                                                break;
                                                        } // end of Vavlidation of Product Type

                                                    break;

                                                    case 2: // Update Stocks
                                                        System.out.println("===== Update Product =====\n");

                                                        System.out.println("Enter Product ID: ");
                                                        String upd_Id = scanner.nextLine();

                                                        System.out.println("Enter amount: ");
                                                        int amount = scanner.nextInt();

                                                        admin.updateStocks(upd_Id, amount);
                                                        
                                                    break;

                                                    case 3: // View All Orders from Customer (Database)
                                                        System.out.println("===== Viewing All Orders =====");
                                                        // admin.viewProducts();
                                                    break;

                                                    default:
                                                    break;
                                                } // end switch
                                            }while(adminChoice != 0); // end admin menu
                                            
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
    
    static void customerDashBoardMenu(){
        System.out.println("1. View Available Products");
        System.out.println("2. Place Orders");
        System.out.println("3. View Order Details");
    }
}
