package demo.domain.items.flameset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class FlameChestplate extends Gear{
	
	public FlameChestplate() {
		super("Chestplate", "Flame Plate", 60, Rarity.LEGENDARY, Element.FIRE, new Stats(80,40));
	}
}
