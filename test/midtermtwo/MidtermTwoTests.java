package midtermtwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MidtermTwoTests {

    @Test
    public void testDogEars() {
        MidtermTwoReview<Integer> mt2 = new MidtermTwoReview<>();
        Assertions.assertEquals(10, MidtermTwoReview.dogEars(5));
        Assertions.assertEquals(10, MidtermTwoReview.otherDogEars(5));
        Assertions.assertEquals(0, MidtermTwoReview.dogEars(0));
        Assertions.assertEquals(0, MidtermTwoReview.otherDogEars(0));
        Assertions.assertEquals(100, MidtermTwoReview.dogEars(50));
        Assertions.assertEquals(100, MidtermTwoReview.otherDogEars(50));
    }

}
