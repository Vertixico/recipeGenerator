package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.Liquid;
import recipes.enums.Solid;
import recipes.util.Ingredient;

public class Melt implements Action, PreparationStep{
	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		
		if(in.isLiquid()){
			Liquid state = (Liquid) in.getState();
			Ingredient newIn = new Ingredient(in);
			if(in.hasAttribute("oily") && !in.isState(Liquid.OIL)){
				//	Oily stuff that is not oil anymore turns back to oil ofc
				out.add(in.setState(Liquid.OIL));
				return out;
			}
			
			switch(state){
			case FOAMY:
			case CREAMY:
				newIn.setState(Liquid.FLUID);
				newIn.removeAttribute("frozen");
				break;
			case FLUID:
			case MASHED:
			case OIL:
			case JUICE:
			default:
				newIn.replaceAttribute("raw", "heated");
			}
			out.add(newIn);
		}
		if(in.isSolid()){
			if(!in.hasAttribute("dried") && !in.hasAttribute("unmeltable")){
				if(in.hasAttribute("oily")){
					out.add(new Ingredient(in).setState(Liquid.OIL));
				} else {
					out.add(new Ingredient(in).setState(Liquid.FLUID));
				}
			}
		}
		return out;
	}
}
