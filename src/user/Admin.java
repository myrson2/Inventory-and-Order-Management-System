package user;

public class Admin extends User{
    public Admin(String id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void performRoleAction() {
        System.out.println("Admin is managing products and inventory.");
        
    }
}
