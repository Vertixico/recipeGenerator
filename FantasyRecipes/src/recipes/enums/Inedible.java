package recipes.enums;

import java.io.Serializable;

public enum Inedible implements IngredientState, Serializable {
	HIDE("hide of"), BONE("bone of"), PEEL("peel of"), CLAW("claw of"), SHELL("shell of");
	String identifier;
	private Inedible(String name){
		this.identifier = name;
	}
	
	@Override
	public String toString(){
		return this.identifier;
	}
}
