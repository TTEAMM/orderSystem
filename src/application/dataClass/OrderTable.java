package application.dataClass;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderTable {

	private IntegerProperty salesOrderNumber;
	private IntegerProperty quantity;
	private StringProperty status;
	private StringProperty orderDate;
	private StringProperty comment;
	private IntegerProperty subTotal;
	private StringProperty itemName;
	private StringProperty Business;
	// private CheckBoxTCell checkbox;
	private BooleanProperty isCheck;
	private StringProperty address;

	// public checkbox cb = new checkbox();
	public void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}

	public String getAddress() {
		return address.get();
	}

	public void setIsCheck(boolean isCheck) {
		this.isCheck = new SimpleBooleanProperty(isCheck);
	}

	public Boolean getIsCheck() {
		return isCheck.getValue();
	}

	public void setBusiness(String business) {
		this.Business = new SimpleStringProperty(business);
	}

	public void setComment(String comment) {
		this.comment = new SimpleStringProperty(comment);
	}

	public void setItemName(String itemName) {
		this.itemName = new SimpleStringProperty(itemName);
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = new SimpleStringProperty(orderDate);
	}

	public void setQuantity(int quantity) {
		this.quantity = new SimpleIntegerProperty(quantity);
	}

	public void setSalesOrderNumber(int salesOrderNumber) {
		this.salesOrderNumber = new SimpleIntegerProperty(salesOrderNumber);
	}

	public void setStatus(String status) {
		this.status = new SimpleStringProperty(status);
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = new SimpleIntegerProperty(subTotal);
	}

	public String getBusiness() {
		return Business.get();
	}

	public String getComment() {
		return comment.get();
	}

	public String getItemName() {
		return itemName.get();
	}

	public String getOrderDate() {
		return orderDate.get();
	}

	public int getQuantity() {
		return quantity.get();
	}

	public int getSalesOrderNumber() {
		return salesOrderNumber.get();
	}

	public String getStatus() {
		return status.get();
	}

	public int getSubTotal() {
		return subTotal.get();
	}
}
