package recipes.enums;

import java.io.Serializable;

public enum Container implements IngredientState, Serializable{
	//	These starting points for states do not need identifiers. 
	//	"Body of Dragon" or "Bodypart of Dragonarm" is redundant
	FRUIT(""), BODY(""), BODYPART(""), ORGAN(""), NUT(""), EGG("");
	String identifier;
	private Container(String id){
		identifier = id;
	}
	@Override
	public String toString(){
		return this.identifier;
	}
}
