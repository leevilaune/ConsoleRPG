package demo.domain.items.oceanset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class OceanPants extends Gear{
	
	public OceanPants() {
		super("Pants", "Ocean Pants", 60, Rarity.LEGENDARY, Element.WATER, new Stats(40,80));
	}
	
}
