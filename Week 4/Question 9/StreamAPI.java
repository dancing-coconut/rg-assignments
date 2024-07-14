import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Test", "TEST", "test", "TeSt", "tEsT");
        System.out.println(strings);

        // Without Stream API
        List<String> modifiedStringsNormal = new ArrayList<String>();
        for (String string : strings) {
            modifiedStringsNormal.add(string.toUpperCase());
        }
        System.out.println(modifiedStringsNormal);

        // With Stream API
        List<String> modifiedStringsStream = strings.stream().map(String::toUpperCase).toList();
        System.out.println(modifiedStringsStream);

    }
}
