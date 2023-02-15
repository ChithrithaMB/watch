package com.example.demo.watch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Watch2")

public class Watch {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String Brand;
	private int Cost;
	private int Instock;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public int getInstock() {
		return Instock;
	}
	public void setInstock(int instock) {
		Instock = instock;
	}
	public Watch(Long id, String brand, int cost, int instock) {
		super();
		this.id = id;
		Brand = brand;
		Cost = cost;
		Instock = instock;
	}
	@Override
	public String toString() {
		return "Watch [id=" + id + ", Brand=" + Brand + ", Cost=" + Cost + ", Instock=" + Instock + "]";
	}
	
	public Watch() {
		
	}
}




   
	
