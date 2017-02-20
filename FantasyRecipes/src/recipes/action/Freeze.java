package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.Liquid;
import recipes.enums.Solid;
import recipes.util.Ingredient;

public class Freeze implements Action, PreparationStep{

	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		
		if(in.isLiquid()){
			Ingredient newIn = new Ingredient(in).setState(Solid.FROZEN);
			if(in.isState(Liquid.FOAMY))
				newIn.setState(Solid.CRYSTALLIZED);
			if(in.isState(Liquid.CREAMY)){
				newIn.setState(Solid.CRYSTALLIZED).addAttribute("sparkly");
			}
			out.add(newIn);
		}
		return out;
	}

}
