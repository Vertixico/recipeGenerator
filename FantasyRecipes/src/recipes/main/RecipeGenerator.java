package recipes.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import recipes.enums.*;
import recipes.util.*;

public class RecipeGenerator {
	
	public static void main(String[] args){
		Set<Ingredient> stuff = new HashSet<Ingredient>();
		stuff.add(new Ingredient("milk", Liquid.FLUID));
		stuff.add(new Ingredient("milk", Liquid.CREAMY));
		stuff.add(new Ingredient("liver of dragon", Solid.CHOPPED));
		stuff.add(new Ingredient("water", Liquid.FLUID));
		stuff.add(new Ingredient("water", Solid.FROZEN).addAttribute("frozen"));
		stuff.add(new Ingredient("bison", Container.BODY));
		stuff.add(new Ingredient("deer", Container.BODY));
		stuff.add(new Ingredient("rabbit", Container.BODY));
		stuff.add(new Ingredient("cow", Container.BODY));
		stuff.add(new Ingredient("dog", Container.BODY));
		stuff.add(new Ingredient("wyvern", Container.BODY));
		stuff.add(new Ingredient("manticore", Container.BODY));
		stuff.add(new Ingredient("harpy", Container.BODY));
		stuff.add(new Ingredient("salt", Crushed.PULVERIZED));
		stuff.add(new Ingredient("pepper", Crushed.PULVERIZED));
		stuff.add(new Ingredient("curcuma", Crushed.PULVERIZED));
		stuff.add(new Ingredient("ingwer", Crushed.PULVERIZED));
		stuff.add(new Ingredient("chilly", Crushed.PULVERIZED));
		stuff.add(new Ingredient("robin's egg", Container.EGG));
		stuff.add(new Ingredient("tomato", Container.FRUIT));
		stuff.add(new Ingredient("tomato", Container.FRUIT));
		stuff.add(new Ingredient("apple", Container.FRUIT));
		stuff.add(new Ingredient("peach", Container.FRUIT));
		stuff.add(new Ingredient("strawberry", Container.FRUIT));
		stuff.add(new Ingredient("cucumber", Container.FRUIT));
		stuff.add(new Ingredient("lemon", Container.FRUIT));
		stuff.add(new Ingredient("walnut", Container.NUT));
		stuff.add(new Ingredient("hazelnut", Container.NUT));
		stuff.add(new Ingredient("chocobo-nut", Container.NUT));
		stuff.add(new Ingredient("coffebean", Container.NUT));
		stuff.add(new Ingredient("tomatosauce", Solid.STOCKED));
		stuff.add(new Ingredient("salt", Crushed.PULVERIZED).addAttribute("salty"));
		
		for(Ingredient i: stuff){
			System.out.println(i);
		}
		
		int k = 0;
		for(Action a : Action.values()){
			List<Ingredient> newStuff = new ArrayList<Ingredient>();
			for(Ingredient i : stuff){
				newStuff.addAll(Executor.apply(i, a));
			}
			stuff.addAll(newStuff);
			k++;
		}
		
		System.out.println("\n===================\n");
		int j = 0;
		for(Ingredient i: stuff){
			System.out.println(++j + ":\t" +i);
		}
		System.out.println("Did "+ k +" iterations!");
	}
}
