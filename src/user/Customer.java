package user;

public class Customer extends User{
     public Customer(String id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void performRoleAction() {
        System.out.println("Customer is browsing products and placing orders.");
        
    }
}
