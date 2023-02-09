import org.example.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.testng.Assert.assertEquals;

public class PersonTest {

    public void currentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.print("Start testing...");
        currentTime();
    }

    @AfterClass
    void afterTime() {
        System.out.print("End testing!");
        currentTime();
    }

    @DataProvider(name = "TestPerson")
    Object[][] TestPerson() {
        return new Object[][] {

                {-1, false},
                {0, false},
                {12, false},
                {13,true},
                {14,true},
                {18,true},
                {19,true},
                {20,false}
        };
    }

    @Test(dataProvider = "TestPerson")
    void PersonTest(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        System.out.println("age " + age + "= " + "Actual result: " + result + " , " + "Expected result: " + expected);
        assertEquals(result, expected);
    }


}



