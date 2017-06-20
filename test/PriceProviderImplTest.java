import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class PriceProviderImplTest {

	@Test
	public void test() {
		PriceProvider p = new PriceProviderImpl();
		p.setPrice(Fruit.APPLE, 5.0);
		assertEquals(p.getPrice(Fruit.APPLE), 5.0, 0.001);

		try {
			p.setPrice(Fruit.APPLE, -1.0);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Price must be positive"));
		}
	}

}
