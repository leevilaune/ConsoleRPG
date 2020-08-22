package demo.domain.items.grassset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class GrassChestplate extends Gear{
	
	public GrassChestplate() {
		super("Chestplate", "Grass Chestplate", 35, Rarity.RARE, Element.EARTH, new Stats(25,45));
	}
	
}
