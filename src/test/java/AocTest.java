import org.example.day1.DayFour;
import org.example.day1.DayOne;
import org.example.day1.DayThree;
import org.example.day1.DayTwo;
import org.junit.jupiter.api.Test;

public class AocTest {

    @Test
    public void DayOneOneTest() {
        DayOne dayOne = new DayOne();

        String answer = dayOne.answer();

        System.out.println(answer);

    }

    @Test
    public void DayTwo() {
        DayTwo dayTwo = new DayTwo();

        System.out.println(dayTwo.process());

        System.out.println(dayTwo.processMore());
    }

    @Test
    public void DayThree() {
        DayThree dayThree = new DayThree();

        System.out.println(dayThree.process());

        System.out.println(dayThree.processMore());
    }

    @Test
    public void DayFour() {
        DayFour dayFour = new DayFour();

        System.out.println(dayFour.process());

//        System.out.println(dayFour.processMore());
    }

}
