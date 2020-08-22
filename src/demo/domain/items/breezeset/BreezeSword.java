package demo.domain.items.breezeset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class BreezeSword extends Gear{
	
	public BreezeSword() {
		super("Weapon", "Breeze Sword", 55, Rarity.RARE, Element.AIR, new Stats(40,30));
	}
}
