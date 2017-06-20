import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class BasketTest {

	@Test
	public void test() {
		Basket a = new Basket();
		a.setQuantity(Fruit.APPLE, 3);
		assertEquals(a.getQuantity(Fruit.APPLE), (Integer)3);

		try {
			a.setQuantity(Fruit.APPLE, -1);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Quantity must be positive"));
		}


	}

}
