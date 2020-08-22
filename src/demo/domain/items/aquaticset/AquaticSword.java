package demo.domain.items.aquaticset;

import demo.domain.enums.Element;
import demo.domain.enums.Rarity;
import demo.domain.Gear;
import demo.domain.Stats;

public class AquaticSword extends Gear{
	
	public AquaticSword() {
		super("Weapon", "Aquatic Sword", 40, Rarity.RARE, Element.WATER, new Stats(35,45));
	}
	
}
