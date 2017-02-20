package recipes.util;

import java.io.Serializable;
import java.util.List;

public class Step implements Serializable {
	List<Ingredient> input;
	Action action;
	List<Ingredient> output;
	
	public Step(List<Ingredient> input, Action action, List<Ingredient> output){
		this.input 	= input;
		this.action = action;
		this.output = output;
	}
	
	@Override
	public String toString(){
		if(input == null || input.isEmpty() || action == null || output == null)
			return "";
		StringBuilder b = new StringBuilder();
		if(input.size() > 1){
			
		}else{
			
		}
		return b.toString();
	}
	
}
