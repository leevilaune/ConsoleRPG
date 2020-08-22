package demo.domain.items.oceanset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class OceanBlades extends Gear{
	
	public OceanBlades() {
		super("Weapon", "Ocean Blades", 60, Rarity.LEGENDARY, Element.WATER, new Stats(50,70));
	}
	
}
