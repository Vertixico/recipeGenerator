package recipes.enums;

import java.io.Serializable;

public enum Crushed implements IngredientState, Serializable {
	MINCED("minced"), 
	PULVERIZED("pulverized"), 
	GRATED("grate"), 
	CRUSHED("crushed");
	
	String identifier;
	private Crushed(String name){
		this.identifier = name;
	}
	
	@Override
	public String toString(){
		return this.identifier;
	}
}
