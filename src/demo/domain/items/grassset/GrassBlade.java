package demo.domain.items.grassset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class GrassBlade extends Gear{
	
	public GrassBlade() {
		super("Weapon", "Grass Blade", 35, Rarity.RARE, Element.EARTH, new Stats(45,25));
	}
}
