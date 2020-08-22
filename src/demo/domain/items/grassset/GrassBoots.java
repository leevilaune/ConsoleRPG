package demo.domain.items.grassset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class GrassBoots extends Gear{
	
	public GrassBoots() {
		super("Boots", "Grass Boots", 35, Rarity.RARE, Element.EARTH, new Stats(35,35));
	}
	
}
