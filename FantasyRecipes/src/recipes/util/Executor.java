package recipes.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import recipes.action.*;

/*
 * Takes an Action Enum, gets the associated class and applies action to the
 * ingredient(s).
 */
public class Executor {
	
	private static boolean build = false;
	private static HashMap<recipes.util.Action, recipes.action.Action> actions;
	
	private static void build(){
		if(!build){
			actions = new HashMap<recipes.util.Action, recipes.action.Action>();
			actions.put(Action.CUT			, new Cut());
			actions.put(Action.CRUSH		, new Crush());
			actions.put(Action.PULVERIZE	, new Pulverize());
			build = true;
		}
		
	}
	public static List<Ingredient> apply(Ingredient i, Action a){
		build();
		List<Ingredient> input = new ArrayList<Ingredient>();
		List<Ingredient> output = new ArrayList<Ingredient>();
		
		input.add(i);
		if(actions.containsKey(a))
			output.addAll(actions.get(a).apply(input));
		
		if(output.isEmpty())	return input;
		return output;
	}
}
