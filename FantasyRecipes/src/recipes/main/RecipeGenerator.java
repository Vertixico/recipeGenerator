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
		stuff.add(new Ingredient("water", Solid.FROZEN).addAttribute("frozen"));
		stuff.add(new Ingredient("bison", Container.BODY));
		stuff.add(new Ingredient("salt", Crushed.PULVERIZED));
		stuff.add(new Ingredient("robin's egg", Container.EGG));
		stuff.add(new Ingredient("tomatosauce", Solid.STOCKED));
		
		Ingredient a = new Ingredient("salt", Crushed.PULVERIZED);
		Ingredient b = new Ingredient(a);
		
		List<Ingredient> nextStep = new ArrayList<Ingredient>();
		for(Ingredient i : stuff){
			System.out.println(i);
			nextStep.addAll(Executor.apply(i, Action.CRUSH));
			
		}
		System.out.println("\n===================\n");
		for(Ingredient i: nextStep){
			System.out.println(i);
		}
		
	}
}
