package demo.domain.items.starterset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class BasicPants extends Gear{
	
	public BasicPants() {
		super("Pants", "Basic Pants", 20, Rarity.COMMON, Element.NONELEMENTAL, new Stats(20,20));
	}
}
