package recipes.main;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.*;
import recipes.util.*;

public class RecipeGenerator {
	
	public static void main(String[] args){
		List<Ingredient> stuff = new ArrayList<Ingredient>();
		stuff.add(new Ingredient("milk", Liquid.FLUID));
		stuff.add(new Ingredient("liver of dragon", Solid.CHOPPED));
		stuff.add(new Ingredient("water", Solid.FROZEN));
		stuff.add(new Ingredient("bison", Inedible.HIDE));
		stuff.add(new Ingredient("flesh of bison", Solid.WHOLE));
		stuff.add(new Ingredient("salt", Crushed.PULVERIZED));
		stuff.add(new Ingredient("robin's egg", Container.EGG));
		stuff.add(new Ingredient("tomatosauce", Solid.STOCKED));
		
		Ingredient a = new Ingredient("salt", Crushed.PULVERIZED);
		Ingredient b = new Ingredient(a);
		System.out.println(a);
		System.out.println(b);
		
		List<Ingredient> nextStep = new ArrayList<Ingredient>();
		for(Ingredient i : stuff){
			System.out.println(i);
			if (i.isSolid()){
				nextStep.addAll(Executor.apply(i, Action.CUT));
			}
		}
		System.out.println("\n===================\n");
		for(Ingredient i: nextStep){
			System.out.println(i);
		}
		
	}
}
