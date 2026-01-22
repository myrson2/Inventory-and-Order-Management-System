package user;

public abstract class User {
    private String id;
    private String name;
    private String email;

    public User(){
        this("", "", "");
    }

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
    
    public boolean login(){
        if(getId().isEmpty() || getEmail().isEmpty() || getName().isEmpty()){
            return false;
        }
        return true;
    }

    public abstract void performRoleAction();
}
