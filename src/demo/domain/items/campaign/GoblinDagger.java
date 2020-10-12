package demo.domain.items.campaign;

import java.util.ArrayList;
import java.util.List;

import demo.crafting.materials.*;
import demo.domain.Gear;
import demo.domain.Material;
import demo.domain.MaterialInventory;
import demo.domain.Recipe;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class GoblinDagger extends Gear{

	private Recipe recipe;
	private MaterialInventory mInv;
	
	public GoblinDagger() {
		
		super("Weapon", "Goblin Dagger", 20, Rarity.COMMON, Element.NONELEMENTAL, new Stats(30,10));
	}

	@Override
	public void setMaterialInventory(MaterialInventory mi) {
		this.mInv = mi;
		this.setRequiredMaterials();
	}
	@Override
	public void setRequiredMaterials() {
		Recipe r = new Recipe(this.name, this.mInv);
		
		List<Material> materials = new ArrayList<>();
		materials.add(new GoblinTooth(10));
		materials.add(new EarthShard(2));
		
		r.setRequirements(materials);
		
		this.recipe = r;

	}
	
	@Override
	public void printRecipe() {
		System.out.println(recipe);
	}

	@Override
	public void setRecipe(Recipe r) {
		this.recipe = r;
	}

	@Override
	public Recipe getRecipe() {
		return this.recipe;
	}
}
