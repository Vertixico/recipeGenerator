package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.*;
import recipes.util.Ingredient;

public class Pulverize implements Action, PreparationStep{
	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		
		if(in.isSolid() || in.isCrushed()){
			out.add(new Ingredient(in).setState(Crushed.PULVERIZED));
			return out;
		}
		if(in.isInedible()){
			Inedible state = (Inedible) in.getState();
			Ingredient newIn = new Ingredient(in);
			if(newIn.hasAttribute("dried")){
				switch(state){
				case HIDE:
					newIn.addAttribute("stringy");
					break;
				case BONE:
					newIn.addAttribute("bitter");
					break;
				case PEEL:
					newIn.addAttribute("sour");
					break;
				case SHELL:
					newIn.addAttribute("salty");
					break;
				case CLAW:
					newIn.addAttribute("potent");
					break;
				default:
					break;
				}
				newIn.setState(Crushed.PULVERIZED);
			}else{
				switch(state){
				case BONE:
				case SHELL:
				case CLAW:
					newIn.addAttribute("mysterious").setState(Crushed.PULVERIZED);
				default:
					newIn.addAttribute("poisonous")
						.setState(Liquid.MASHED);
				}
			}
			out.add(newIn);
		}
		
		return out;
	}
}
