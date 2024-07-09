import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppNamePrinter {
    @Value("${spring.application.name}")
    private String appName;

    public String printAppName() {
        System.out.println("Application Name: " + appName);
        return appName;
    }

}

