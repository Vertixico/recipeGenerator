package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.enums.*;
import recipes.util.Ingredient;

public class Cut implements Action, PreparationStep{

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
			case STOCKED:
			case FROZEN:
				out.add(new Ingredient(in).setState(Solid.PIECES));
				break;
			case PIECES:
				out.add(new Ingredient(in).setState(Solid.CHOPPED));
				break;
			default:
				out.add(new Ingredient(in).setState(Crushed.MINCED));
				break;
			}
		}
		if(in.isContainer()){
			Container state = (Container) in.getState();
			String base = in.getBase();
			switch(state){
			case BODY:
				out.add(new Ingredient(in).setBase("Hide of "+base)
						.addAttribute("unmeltable")
						.setState(Inedible.HIDE));
				out.add(new Ingredient(in).setBase(base+"'s meat")
						.setState(Solid.WHOLE)
						.addAttribute("unmeltable")
						.addAttribute("raw"));
				out.add(new Ingredient(in).setBase(base+"'s heart")
						.setState(Solid.WHOLE)
						.addAttribute("unmeltable")
						.addAttribute("raw"));
				out.add(new Ingredient(in).setBase(base+"'s liver")
						.setState(Solid.WHOLE)
						.addAttribute("unmeltable")
						.addAttribute("raw"));
				out.add(new Ingredient(in).setBase(base+"'s spleen")
						.setState(Solid.WHOLE)
						.addAttribute("unmeltable")
						.addAttribute("raw"));
				out.add(new Ingredient(in).setBase(base+"'s lung")
						.setState(Solid.WHOLE)
						.addAttribute("unmeltable")
						.addAttribute("raw"));
				out.add(new Ingredient(in).setBase(base+"'s blood")
						.setState(Liquid.FLUID));
				out.add(new Ingredient(in).setBase("bones of a "+base)
						.addAttribute("unmeltable")
						.setState(Inedible.BONE));
				out.add(new Ingredient(in).setBase(base + "'s claws")
						.addAttribute("unmeltable")
						.setState(Inedible.CLAW));
				out.add(new Ingredient(in).setBase(base + "'s skull")
						.addAttribute("unmeltable")
						.setState(Inedible.BONE));
				break;
			case FRUIT:
				out.add(new Ingredient(in).setBase("flesh of "+base)
						.setState(Solid.WHOLE)
						);
				out.add(new Ingredient(in).setBase("core of "+base)
						.addAttribute("unmeltable")
						.setState(Solid.WHOLE)
						);
				out.add(new Ingredient(in).setBase(base)
						.addAttribute("unmeltable")
						.setState(Inedible.PEEL)
						);
			case EGG:
				out.add(new Ingredient(in).setBase("yolk of "+base)
						.addAttribute("oily")
						.setState(Liquid.FLUID)
						);
				out.add(new Ingredient(in).setState(Inedible.SHELL)
						);
				break;
			default:
				out.add(new Ingredient(in).setState(Solid.PIECES));
				break;
			
			}
		}
		return out;
	}

}
