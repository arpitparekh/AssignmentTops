package com.example.assignmenttops.online_Json.complexJsonData;

import java.util.List;

public class FoodItem{
	private double ppu;
	private Batters batters;
	private String name;
	private String id;
	private String type;
	private List<ToppingItem> topping;

	public void setPpu(double ppu){
		this.ppu = ppu;
	}

	public double getPpu(){
		return ppu;
	}

	public void setBatters(Batters batters){
		this.batters = batters;
	}

	public Batters getBatters(){
		return batters;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTopping(List<ToppingItem> topping){
		this.topping = topping;
	}

	public List<ToppingItem> getTopping(){
		return topping;
	}

	@Override
 	public String toString(){
		return 
			"FoodItem{" + 
			"ppu = '" + ppu + '\'' + 
			",batters = '" + batters + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",topping = '" + topping + '\'' + 
			"}";
		}
}