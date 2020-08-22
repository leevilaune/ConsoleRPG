package demo.domain.items.aquaticset;

import demo.domain.enums.Element;
import demo.domain.enums.Rarity;
import demo.domain.Gear;
import demo.domain.Stats;

public class AquaticHelmet extends Gear{
	
	public AquaticHelmet() {
		super("Helmet", "Aquatic Helmet", 40, Rarity.RARE, Element.WATER, new Stats(30,50));
	}
	
}
