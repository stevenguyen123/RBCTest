import java.util.Map;

public class Calculator {
	
	private final PriceProvider priceProvider;
	
	public Calculator(PriceProvider priceProvider){
		this.priceProvider = priceProvider;
	}
	
	public double calculateCost(Basket basket){
		return basket.getItems().entrySet().stream().mapToDouble(this::cost).sum();
	}
	
	private double cost(Map.Entry<Fruit, Integer> entry){
		double retVal = Double.NaN;
		double price = priceProvider.getPrice(entry.getKey());
				
		if ( Double.isFinite(price)){
			retVal = entry.getValue()*price;
		} else{
			throw new IllegalArgumentException("Price is not available for: " + entry.getKey());
		}
		
		return retVal;
		
	}
	
}
