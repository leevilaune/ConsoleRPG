package demo.domain.items.starterset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class AdventurerSword extends Gear{
	
	public AdventurerSword() {
		super("Weapon", "Basic Sword", 20, Rarity.COMMON, Element.NONELEMENTAL, new Stats(20,20));
	}
	
}