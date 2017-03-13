import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "item")
@SessionScoped
public class Item implements Serializable {

	/*
	 * User can request items
	 * Implements the concept of putting library items on hold
	 * */

	private static final long serialVersionUID = 1L;
	private static final ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
	private String item;
	private String user;
	OrderBean order;

	public String addAction() {
		OrderBean orderitem = new OrderBean(this.item, this.getUser());
		orderList.add(orderitem);

		item = "";
		setUser("");
		return null;
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Request Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		orderList.remove((OrderBean) event.getObject());
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Request Edited", ((OrderBean) event.getObject()).getItem());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public ArrayList<OrderBean> getOrderList() {
		return orderList;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public OrderBean getOrder() {
		return order;
	}

	public void setOrder(OrderBean order) {
		this.order = order;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}