package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	// Atributos
	private Date moment;
	private OrderStatus status;
	
	// Associa��o
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Client client;
	
	// Construtores
	public Order() {
		
		
	}

	public Order(OrderStatus status, Date moment, Client client) {
		this.status = status;
		this.moment = moment;
		this.client = client;
	}

	// Getter/Setter
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	// M�todos da classe
	public void addItem(OrderItem item) {
		
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		
		items.remove(item);
	}
	
	public double total() {
		
		double sum = 0;
		for (OrderItem  it : items) {
			
			sum += it.subTotal();
		}
		
		return sum; 
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: "); 
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
	
	
	
	
	
	
	

}
