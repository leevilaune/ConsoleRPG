package demo.crafting.materials;

import demo.domain.Material;
import demo.domain.enums.Rarity;

public class EarthShard extends Material{

	public EarthShard() {
		super("Material", "Earth Shard", Rarity.RARE);
	}
	public EarthShard(int a) {
		super("Material", "Earth Shard", Rarity.RARE);
		super.setAmount(a);
	}

}
