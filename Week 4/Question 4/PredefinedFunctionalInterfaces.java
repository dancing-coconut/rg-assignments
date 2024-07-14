import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PredefinedFunctionalInterfaces {
    public static void main(String[] args) {
        Function<String, String> function = String::toLowerCase;
        Consumer<String> consumer = System.out::println;
        Supplier<String> supplier = () -> new Random().ints(65, 91).limit(10).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        String string = supplier.get();
        System.out.println("Supplied: " + string);
        String processedString = function.apply(string);
        System.out.println("Function Processing: " + processedString);
        consumer.accept(processedString);
    }
}
