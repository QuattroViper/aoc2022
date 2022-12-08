import org.example.*;
import org.example.DaySix;
import org.example.working.Day7;
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

        System.out.println(dayFour.processMore());
    }

    @Test
    public void DayFive() {
        DayFive dayFive = new DayFive();

        System.out.println(dayFive.process());

        System.out.println(dayFive.processMore());
    }

    @Test
    public void DaySix() {
        DaySix day = new DaySix();

        System.out.println(day.process());

        System.out.println(day.processMore());
    }

    @Test
    public void DaySeven() {
        DaySeven day = new DaySeven();

        System.out.println(day.process());

        System.out.println(day.processMore());

        Day7 d = new Day7();

        System.out.println(d.part1());
        System.out.println(d.part2());
    }

    @Test
    public void DayEight() {
        DayEight day = new DayEight();

        System.out.println(day.process());
        System.out.println(day.processMore());
    }

}
