package demo.domain.items.oceanset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class OceanChestplate extends Gear{
	
	public OceanChestplate() {
		super("Chestplate", "Ocean Plate", 60, Rarity.LEGENDARY, Element.WATER, new Stats(30,90));
	}
	
}
