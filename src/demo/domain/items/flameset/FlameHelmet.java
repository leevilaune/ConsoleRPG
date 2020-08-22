package demo.domain.items.flameset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class FlameHelmet extends Gear{
	
	public FlameHelmet() {
		super("Helmet", "Flame Helmet", 60, Rarity.LEGENDARY, Element.FIRE, new Stats(50,30));
	}
}
