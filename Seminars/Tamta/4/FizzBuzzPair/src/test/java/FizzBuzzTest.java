import fizzBuzz.FizzBuzz;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    FizzBuzz fz  = new FizzBuzz();
    @Test
    public void div15(){
        for (int i = 0; i < 100; i++) {
            assertEquals("FizzBuzz", fz.fizzBuzz(i*15));
        }
    }

    @Test
    public void contains35(){
        assertEquals("FizzBuzz", fz.fizzBuzz(35));
        assertEquals("FizzBuzz", fz.fizzBuzz(315));
        assertEquals("FizzBuzz", fz.fizzBuzz(513)); // მიმდევრობა, 3-ის ჯერადი
        assertEquals("FizzBuzz", fz.fizzBuzz(432251));
        assertEquals("FizzBuzz", fz.fizzBuzz(253));
    }

    @Test
    public void div3(){
        assertEquals("Fizz", fz.fizzBuzz(3));
        assertEquals("Fizz", fz.fizzBuzz(27));
        assertEquals("Fizz", fz.fizzBuzz(123));
        assertEquals("Fizz", fz.fizzBuzz(444));
        assertEquals("Fizz", fz.fizzBuzz(564));
    }

    @Test
    public void contains3(){
        assertEquals("Fizz", fz.fizzBuzz(333));
        assertEquals("Fizz", fz.fizzBuzz(130)); // იყოფა 5-ზე
        assertEquals("Fizz", fz.fizzBuzz(13)); // არ იყოფა 3-ზე
    }

    @Test
    public void div5(){
        assertEquals("Buzz", fz.fizzBuzz(5));
        assertEquals("Buzz", fz.fizzBuzz(50));
        assertEquals("Buzz", fz.fizzBuzz(25));
        assertEquals("Buzz", fz.fizzBuzz(100));
    }

    @Test
    public void contains5(){
        assertEquals("Buzz", fz.fizzBuzz(52));
        assertEquals("Buzz", fz.fizzBuzz(1451));
    }

    @Test
    public void other(){
        assertEquals("1", fz.fizzBuzz(1));
        assertEquals("112", fz.fizzBuzz(112));
        assertEquals("86", fz.fizzBuzz(86));
    }

}