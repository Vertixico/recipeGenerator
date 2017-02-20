package recipes.enums;

import java.io.Serializable;

public enum Solid implements IngredientState, Serializable{
	WHOLE(""), PIECES("pieces of"), CHOPPED("chopped up"), FROZEN("frozen"), 
	CRYSTALLIZED("crystals of"), STOCKED("hardened");
	String identifier;
	private Solid(String name){
		this.identifier = name;
	}
	@Override
	public String toString(){
		return this.identifier;
	}
}
