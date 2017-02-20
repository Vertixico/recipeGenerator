package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.*;
import recipes.util.Ingredient;

public class Crush implements Action, PreparationStep {

	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		
		if(in.isSolid()){
			Solid state = (Solid) in.getState();
			switch(state){
			case WHOLE:
			case PIECES:
			case CHOPPED:
			case STOCKED:
				out.add(new Ingredient(in).setState(Liquid.MASHED));
				break;
			case CRYSTALLIZED:
			case FROZEN:
				out.add(new Ingredient(in).setState(Crushed.PULVERIZED));
				break;
			default:
				out.add(new Ingredient(in).addAttribute("slightly cracked"));
				break;
			}
			return out;
		}
		if(in.isState(Crushed.GRATED)){
			out.add(new Ingredient(in).setState(Liquid.MASHED));
		}
		
		return out;
	}

}
