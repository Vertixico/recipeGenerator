package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.Crushed;
import recipes.enums.Liquid;
import recipes.enums.Solid;
import recipes.util.Ingredient;

public class Batter implements Action, PreparationStep{

	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		
		if(in.isLiquid()){
			Liquid state = (Liquid) in.getState();
			if(in.hasAttribute("thin")){
				//	Useless to batter anything that will never make foam
				// 	Like... water.
				return out;
			}
			Ingredient newIn = new Ingredient(in);
			switch(state){
			case FLUID:
			case OIL:
			case JUICE:
				newIn.setState(Liquid.CREAMY);
				break;
			case CREAMY:
				newIn.setState(Liquid.FOAMY);
				break;
			case FOAMY:
				newIn.setState(Solid.STOCKED);
				break;
			default:
				newIn.addAttribute("well stirred");
			}
			out.add(newIn);
		}
		return out;
	}
}
