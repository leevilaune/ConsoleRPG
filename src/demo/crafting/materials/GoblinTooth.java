package demo.crafting.materials;

import demo.domain.Material;
import demo.domain.enums.Rarity;

public class GoblinTooth extends Material{

	public GoblinTooth() {
		super("Material", "Goblin Tooth", Rarity.COMMON);
	}
	public GoblinTooth(int a) {
		super("Material", "Goblin Tooth", Rarity.COMMON);
		super.setAmount(a);
	}

}
