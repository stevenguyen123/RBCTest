import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PriceProviderImpl implements PriceProvider {
	
	final Map<Fruit,Double> currentPrice = new ConcurrentHashMap<Fruit,Double>();
	
	@Override
	public void setPrice(Fruit fruit, double value){
		currentPrice.put(fruit, value);
	}

	@Override
	public double getPrice(Fruit fruit) {
		return currentPrice.getOrDefault(fruit, 0.0);
	}

}
