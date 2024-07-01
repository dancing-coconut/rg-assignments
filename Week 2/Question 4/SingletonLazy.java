public class SingletonLazy {

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
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
