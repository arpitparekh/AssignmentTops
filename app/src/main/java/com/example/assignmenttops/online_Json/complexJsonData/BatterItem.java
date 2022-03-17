package com.example.assignmenttops.online_Json.complexJsonData;

public class BatterItem{
	private String id;
	private String type;

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

	@Override
 	public String toString(){
		return 
			"BatterItem{" + 
			"id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
