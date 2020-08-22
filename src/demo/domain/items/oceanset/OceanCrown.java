package demo.domain.items.oceanset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class OceanCrown extends Gear {

	public OceanCrown() {
		super("Helmet", "Ocean Crown", 60, Rarity.LEGENDARY, Element.WATER, new Stats(55,65));
	}
}
