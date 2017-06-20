import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Basket {
	private final Map<Fruit,Integer> items = new ConcurrentHashMap<Fruit,Integer>();
		
	public Map<Fruit,Integer> getItems() {
		return items;
	}
	
	public Integer getQuantity(Fruit fruit){
		return items.getOrDefault(fruit, 0);
	}
	public void setQuantity(Fruit fruit, int number) {
		if (number >= 0) {
			this.items.put(fruit, number);}
		else {
			throw new IllegalArgumentException("Quantity must be positive");
		}
	}
	

}
