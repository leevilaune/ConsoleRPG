package demo.domain.items.flameset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class FlameBoots extends Gear{
	public FlameBoots() {
		super("Boots", "Flame Boots", 60, Rarity.LEGENDARY, Element.FIRE, new Stats(70,50));
	}
}
