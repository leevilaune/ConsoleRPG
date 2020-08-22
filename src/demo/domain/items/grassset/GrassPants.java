package demo.domain.items.grassset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class GrassPants extends Gear{
	
	public GrassPants() {
		super("Pants", "Grass Pants", 35, Rarity.RARE, Element.EARTH, new Stats(30,40));
	}
}
