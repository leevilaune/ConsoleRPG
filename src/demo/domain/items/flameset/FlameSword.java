package demo.domain.items.flameset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class FlameSword extends Gear{

	public FlameSword() {
		super("Weapon", "Flame Sword", 60, Rarity.LEGENDARY, Element.FIRE, new Stats(90,30));
	}

}
