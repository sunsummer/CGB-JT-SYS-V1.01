package com.jt.order.entity;
/**
 * Order映射实体类
 */
public class Order {
	
	private Integer id;
	private String item;
	private String name;
	private Integer num;
	private String order_no;
	private String order_type;
	private Double price;
	private String shows;
	
	public Order() {
		super();
	}
	public Order(Integer id, String order_no, String order_type, String name, Integer num, String item, Double price,
			String shows) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.order_type = order_type;
		this.name = name;
		this.num = num;
		this.item = item;
		this.price = price;
		this.shows = shows;
	}
	public Integer getId() {
		return id;
	}
	public String getItem() {
		return item;
	}
	public String getName() {
		return name;
	}
	public Integer getNum() {
		return num;
	}
	public String getOrder_no() {
		return order_no;
	}
	public String getOrder_type() {
		return order_type;
	}
	public Double getPrice() {
		return price;
	}
	public String getShow() {
		return shows;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setShow(String shows) {
		this.shows = shows;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", order_type=" + order_type + ", name=" + name + ", num="
				+ num + ", item=" + item + ", price=" + price + ", shows=" + shows + "]";
	}
}
