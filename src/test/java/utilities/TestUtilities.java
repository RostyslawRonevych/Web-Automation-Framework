package utilities;

import org.instancio.Instancio;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.foxminded.skarb.test.HomePageTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import static org.instancio.Select.field;

public class TestUtilities {
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = HomePageTest.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + fileName);
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static WebDriver getDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static Stream<Volunteer> createVolunteerStreamValid() {
        List<Volunteer> list = Instancio.ofList(Volunteer.class)
                .size(10)
                .generate(field(Volunteer::getFirstName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Volunteer::getLastName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Volunteer::getEmail), gen -> gen.text().pattern("#c#c#c#c#c#c@cskarb.ngo"))
                .generate(field(Volunteer::getPhone), gen -> gen.text().pattern("+3809#d#d#d#d#d#d#d#d"))
                .generate(field(Volunteer::getPassword), gen -> gen.text().pattern("#C#C#d#c#c#a#a#a#a##"))
                .create();
        Stream<Volunteer> volunteerStream = list.stream();
        return volunteerStream;
    }
}
