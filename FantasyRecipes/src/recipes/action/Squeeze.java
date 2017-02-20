package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.Crushed;
import recipes.enums.Liquid;
import recipes.util.Ingredient;

public class Squeeze implements Action, PreparationStep{
	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		if(in.isSolid()){
			Ingredient newIn = new Ingredient(in);
			if(newIn.hasAttribute("dried") || newIn.hasAttribute("frozen")){
				newIn.setState(Crushed.PULVERIZED);
				out.add(newIn);
				return out;
			}
			newIn.setState(Liquid.MASHED);
			out.add(newIn);
			if(newIn.hasAttribute("oily")){
				out.add(new Ingredient(newIn).setState(Liquid.OIL));
			} else {
				out.add(new Ingredient(newIn).setState(Liquid.JUICE));
			}
		}
		return out;
	}
}
