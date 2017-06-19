
public class Calculator {
	
	private final PriceProvider priceProvider;
	
	public Calculator(PriceProvider priceProvider){
		this.priceProvider = priceProvider;
	}
	
	public double calculateCost(Basket basket){
		return basket.getItems().entrySet().stream().mapToDouble(map -> map.getValue()*priceProvider.getPrice(map.getKey())).sum();
	}
	
	public static void main(String[] args){
		
		Basket a = new Basket();
		a.setQuantity(Fruit.APPLE, 3);
		a.setQuantity(Fruit.PEACH, 2);
		a.setQuantity(Fruit.LEMON, 10);
		a.setQuantity(Fruit.ORANGE,5);
		
		Basket b = new Basket();
		b.setQuantity(Fruit.APPLE, 3);
		b.setQuantity(Fruit.PEACH, 2);
		b.setQuantity(Fruit.LEMON, 10);
		b.setQuantity(Fruit.ORANGE,5);
		b.setQuantity(Fruit.BANANA,9);
		
		PriceProvider p = new PriceProviderImpl();
		p.setPrice(Fruit.APPLE, 5.0);
		p.setPrice(Fruit.PEACH, 5.0);
		p.setPrice(Fruit.BANANA, 5.0);
		p.setPrice(Fruit.ORANGE, 5.0);
		p.setPrice(Fruit.LEMON, 5.0);
		
		Calculator cal = new Calculator(p);
		
		System.out.println("Cost of basket a: " + cal.calculateCost(a));
		System.out.println("Cost of basket b: " + cal.calculateCost(b));
		
		//price change
		System.out.println("Update price");
		p.setPrice(Fruit.APPLE, 6.0);
		
		System.out.println("Cost of basket a: " + cal.calculateCost(a));
		System.out.println("Cost of basket b: " + cal.calculateCost(b));
		
		//quantity change
		System.out.println("Update quantity");
		a.setQuantity(Fruit.APPLE, 5);
		b.setQuantity(Fruit.PEACH, 6);
				
		System.out.println("Cost of basket a: " + cal.calculateCost(a));
		System.out.println("Cost of basket b: " + cal.calculateCost(b));
		
		
	}
}
