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
		if(!in.isSolid())
			return out;
		
		Solid state = (Solid) in.getState();
		String base = in.getBase();
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
		return out;
	}

}
