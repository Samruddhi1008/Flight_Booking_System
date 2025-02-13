package user;

public class User {
    private String userId;
    private String name;
    private String email;
    private String phone;

    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void displayUserInfo() {
        System.out.println("User: " + name + " | Email: " + email + " | Phone: " + phone);
    }
}
