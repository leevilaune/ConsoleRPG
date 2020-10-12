package demo.domain.interfaces;

import demo.domain.MaterialInventory;
import demo.domain.Recipe;

public interface Craftable {
	
	void setMaterialInventory(MaterialInventory mi);
	void setRequiredMaterials();
	void printRecipe();
	void setRecipe(Recipe r);
	Recipe getRecipe();
	
}
