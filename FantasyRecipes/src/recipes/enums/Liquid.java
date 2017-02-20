package recipes.enums;

import java.io.Serializable;

public enum Liquid implements IngredientState, Serializable{
	FLUID(""), CREAMY("cream of"), FOAMY("foam of"), MASHED("mashed"),
	GELATINOUS("jelly of"), JUICE("juice of"), OIL("oil of");
	String identifier;
	private Liquid(String name){
		this.identifier = name;
	}
	@Override
	public String toString(){
		return this.identifier;
	}
}
