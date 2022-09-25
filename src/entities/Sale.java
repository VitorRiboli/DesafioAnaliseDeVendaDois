package entities;

import java.util.Objects;

public class Sale {
	private Integer month;
	private Integer year;
	private String saller;
	private Integer items;
	private Double total;
	
	public Sale() {
		super();
	}

	public Sale(Integer month, Integer year, String saller, Integer items, Double total) {
		super();
		this.month = month;
		this.year = year;
		this.saller = saller;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSaller() {
		return saller;
	}

	public void setSeller(String seller) {
		this.saller = seller;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(saller);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(saller, other.saller);
	}

	public double averagePrice() {
		return total / items;
	}

	@Override
	public String toString() {
		return saller + " - " + String.format("%.2f", total);
	}
	
	
}
