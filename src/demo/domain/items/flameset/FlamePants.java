package demo.domain.items.flameset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class FlamePants extends Gear {
	
	public FlamePants() {
		super("Pants", "Flame Pants", 60, Rarity.LEGENDARY, Element.FIRE, new Stats(75,45));
	}
}
