import java.io.Serializable;

public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String item;
	private String user;

	// custom constructor
	public OrderBean(String item, String user) {
		this.item = item;
		this.setUser(user);
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}