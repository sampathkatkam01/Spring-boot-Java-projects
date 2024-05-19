package in.sampath.binding;

public class Order {

	private String id;
	
	private String name;

	private String email;
	
	private Long price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", email=" + email + ", price=" + price + "]";
	}
	
}
