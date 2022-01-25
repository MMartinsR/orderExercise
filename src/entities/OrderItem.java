package entities;


public class OrderItem {
	
	// Atributos
	private Integer quantity;
	private Double price;

	//Associação
	private Product product;
	
	// Construtores
	public OrderItem() {

		
	}

	public OrderItem(Integer quantity, Double price, Product product) {

		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	// Getter/Setter
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// Métodos da classe
	public Double subTotal() {
		
		return quantity * product.getPrice();
	}
	
	@Override
	public String toString() {
		
		return this.getProduct().getName() 
				+ ", $" 
				+ String.format("%.2f", price)
				+ ", Quantity: " 
				+ quantity
				+ ", Subtotal: $" 
				+ String.format("%.2f", this.subTotal());
	}
	
	
}
