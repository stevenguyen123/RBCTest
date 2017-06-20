import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PriceProviderImpl implements PriceProvider {
	
	final Map<Fruit,Double> currentPrice = new ConcurrentHashMap<Fruit,Double>();
	
	@Override
	public void setPrice(Fruit fruit, double value){
		if (value > 0.0){
		currentPrice.put(fruit, value);
		} else{
			throw new IllegalArgumentException("Price must be positive");
		}
	}

	@Override
	public double getPrice(Fruit fruit) {
		return currentPrice.getOrDefault(fruit, Double.NaN);
	}

}
