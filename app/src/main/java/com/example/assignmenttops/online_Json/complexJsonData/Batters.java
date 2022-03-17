package com.example.assignmenttops.online_Json.complexJsonData;

import java.util.List;

public class Batters{
	private List<BatterItem> batter;

	public void setBatter(List<BatterItem> batter){
		this.batter = batter;
	}

	public List<BatterItem> getBatter(){
		return batter;
	}

	@Override
 	public String toString(){
		return 
			"Batters{" + 
			"batter = '" + batter + '\'' + 
			"}";
		}
}