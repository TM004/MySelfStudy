package machine.vending;

public class Money {
	// private final String name;
	private final int parametar;
	private int stock;
	/*
	public Money(String name,int parametar, int stock){
		this.name = name;
		this.parametar = parametar;
		this.stock = stock;
	}
	*/
	
	public Money(int parametar, int stock){
		this.parametar = parametar;
		this.stock = stock;
	}
	
	public int getStock(){
		return this.stock;
	}
	
	public int getParametar(){
		return this.parametar;
	}
	
	public void minusStock( int stock ){
		this.stock = this.stock - stock;
	}
	
}
