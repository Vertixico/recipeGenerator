package recipes.action;

import java.util.List;

import recipes.util.Ingredient;

public interface Action {
	public List<Ingredient> apply(List<Ingredient> input);
}
