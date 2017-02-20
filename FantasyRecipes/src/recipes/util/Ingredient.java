package recipes.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import recipes.enums.*;
/**
 * Central class representing an Ingredient.
 * Each Ingrediant has a stat, that, based on it's base, further determines
 * the name of the Ingredient. Also Attributes are possible.
 * This way, based on say "liver" you can have "chopped liver", "pieces of liver"
 * and even "chopped crystalized liver seasoned with oregano"
 * @author vertixico
 *
 */
public class Ingredient implements Serializable, Cloneable{
	// <Attribute(s)> <State> <Base> <Additions>
	/*	e.g.
	 *  Holy frozen crushed liver of Pig
	 *  Spicy minced flesh of Papaya
	 */
	private List<String> attributes = new ArrayList<String>();
	private IngredientState state;
	private String base;
	private String addition;
	
	public Ingredient(String base, IngredientState state){
		this.state = state;
		this.base = base;
	}
	/**
	 * Creates a shallow copy of an ingredient
	 * @param model
	 */
	public Ingredient(Ingredient model){
		this.state = model.state;
		this.base = model.base;
		this.attributes = new ArrayList<String>(model.attributes);
		this.addition = model.addition;
	}
	
	
	public String toString(){
		String pre = "";
		if(!attributes.isEmpty()){
			for(String i : attributes){
				pre += " "+ i + ",";
			}
			pre = pre.trim();
			pre = pre.replaceAll(",\\$", "");
		}
		
		String a = String.format("%s %s", this.state.toString(), this.base);
		String result = (pre + " " + a).replaceAll("\\s+", " ").trim();
		return result;
	}
	public String getBase(){
		return this.base;
	}
	public boolean isSolid(){
		return this.state instanceof Solid;
	}
	public boolean isLiquid(){
		return this.state instanceof Liquid;
	}
	public boolean isCrushed(){
		return this.state instanceof Crushed;
	}
	public boolean isInedible(){
		return this.state instanceof Inedible;
	}
	public boolean isContainer(){
		return this.state instanceof Container;
	}
	public boolean isState(IngredientState s){
		return this.state == s;
	}
	public Ingredient setState(IngredientState state){
		this.state = state;
		return this;
	}
	public IngredientState getState(){
		return this.state;
	}
	/**
	 * This method treats our array List like a set: It checks for duplicates before
	 * adding a new attribute. Adds only, if attribute not yet existing.
	 * @param attribute
	 */
	public Ingredient addAttribute(String attribute){
		if(this.attributes.indexOf(attribute) == -1)
		this.attributes.add(attribute);
		return this;
	}
	/**
	 * Removes ALL previous attributes and adds the new attribute 
	 * @param attribute
	 */
	public Ingredient setAttribute(String attribute){
		this.attributes.clear();
		this.attributes.add(attribute);
		return this;
	}
	public boolean hasAttribute(String attribute){
		return(this.attributes.indexOf(attribute) != -1);
	}
	/**
	 * Looks up a specific attribute and replaces it with a new attribute
	 * @param oldAtt
	 * @param newAtt
	 */
	public Ingredient replaceAttribute(String oldAtt, String newAtt){
		int i = this.attributes.indexOf(oldAtt);
		if(i == -1){
			this.addAttribute(newAtt);
			return this;
		}
		this.attributes.set(i, newAtt);
		return this;
	}
	public Ingredient removeAttribute(String old){
		int i = this.attributes.indexOf(old);
		if(i != -1){
			this.attributes.remove(i);
		}
		return this;
	}
	/**
	 * Sets the addition to a specific value;
	 * @param addition
	 */
	public Ingredient addAddition(String addition){
		this.addition = addition;
		return this;
	}
	public Ingredient clearAddition(){
		this.addAddition("");
		return this;
	}
	public Ingredient setBase(String base){
		this.base = base;
		return this;
	}
}
