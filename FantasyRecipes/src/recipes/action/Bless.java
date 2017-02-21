package recipes.action;

import java.util.ArrayList;
import java.util.List;

import recipes.util.Ingredient;

public class Bless implements Action, PreparationStep {
	@Override
	public List<Ingredient> apply(List<Ingredient> input) {
		List<Ingredient> out = new ArrayList<Ingredient>();
		if(input == null || input.size() == 0)
			return out;
		
		Ingredient in = input.get(0);
		Ingredient newIn = new Ingredient(in).addAttribute("blessed")
				.removeAttribute("cursed").removeAttribute("shaken")
				.removeAttribute("confused").removeAttribute("stirred");
		out.add(newIn);
		
		return out;
	}
}
