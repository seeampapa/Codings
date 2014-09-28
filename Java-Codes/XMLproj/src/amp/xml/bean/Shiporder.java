package amp.xml.bean;

public class Shiporder {
	private String orderPerson;
	private ShipTo shipTo;
	public String getOrderPerson() {
		return orderPerson;
	}
	public void setOrderPerson(String orderPerson) {
		this.orderPerson = orderPerson;
	}
	public ShipTo getShipTo() {
		return shipTo;
	}
	public void setShipTo(ShipTo shipTo) {
		this.shipTo = shipTo;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	private Item item;
}
