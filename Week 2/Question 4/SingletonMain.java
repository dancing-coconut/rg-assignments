public class SingletonMain {

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();

        // Uncomment for testing:
//        try {
//            Singleton test = new Singleton();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
