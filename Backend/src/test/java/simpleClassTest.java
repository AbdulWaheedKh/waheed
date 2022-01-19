import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.waheed.java.model.simpleClass;


//First Test to check 

class simpleClassTest {

    @Test
    void twoPlusTwoEqualsFour(){

        var calculator = new simpleClass();
        calculator.add(2, 2);
        assertEquals(4, calculator.add(2, 2));

    }
}
