public class Encapsulation {
    public static void main(String[] args) {
        EncapsulatedClass user = new EncapsulatedClass();
        user.setSecurityId(10);
        user.setPassword("QWERTYUIOP");

        System.out.println("Credentials: ");
        System.out.println("User ID: " + user.getSecurityId());
        System.out.println("Password: " + user.getPassword());
    }
}
