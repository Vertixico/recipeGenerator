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
			actions.put(Action.BATTER		, new Batter());
			actions.put(Action.BLESS		, new Bless());
			actions.put(Action.CUT			, new Cut());
			actions.put(Action.CRUSH		, new Crush());
			actions.put(Action.CURSE		, new Curse());
			actions.put(Action.ENCHANT		, new Enchant());
			actions.put(Action.FREEZE		, new Freeze());
			actions.put(Action.MELT			, new Melt());
			actions.put(Action.PULVERIZE	, new Pulverize());
			actions.put(Action.SHAKE		, new Shake());
			actions.put(Action.SHAME		, new Shame());
			actions.put(Action.SQUEEZE		, new Squeeze());
			actions.put(Action.STIRR, new Stirr());
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
