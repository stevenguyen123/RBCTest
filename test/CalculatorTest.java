import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() {
		Basket a = new Basket();
		a.setQuantity(Fruit.APPLE, 3);
		a.setQuantity(Fruit.PEACH, 2);
		a.setQuantity(Fruit.LEMON, 10);
		a.setQuantity(Fruit.ORANGE,5);
			
		PriceProvider p = new PriceProviderImpl();
		p.setPrice(Fruit.APPLE, 5.0);
		p.setPrice(Fruit.PEACH, 5.0);
		p.setPrice(Fruit.BANANA, 5.0);
		p.setPrice(Fruit.ORANGE, 5.0);
		p.setPrice(Fruit.LEMON, 5.0);
		
		Calculator cal = new Calculator(p);
		
		assertEquals(100.0,cal.calculateCost(a), 0.001);
		
		PriceProvider p1 = new PriceProviderImpl();
		p1.setPrice(Fruit.APPLE, 5.0);
		
		Calculator cal1 = new Calculator(p1);

		try {
			cal1.calculateCost(a);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), containsString("Price is not available for:"));
		}
		

		
	}

}
