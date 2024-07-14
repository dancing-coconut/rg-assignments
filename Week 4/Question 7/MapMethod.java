import java.util.Optional;

public class MapMethod {
    public static void main(String[] args) {
        String name = "PayPal";
        Optional<String> optionalName = Optional.of(name);

        optionalName.map(String::toUpperCase).ifPresent(System.out::println);
    }
}
