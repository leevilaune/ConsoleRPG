package demo.domain.items.emberset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class EmberHelmet extends Gear{

	public EmberHelmet() {
		super("Helmet", "Ember Helmet", 40, Rarity.RARE, Element.FIRE, new Stats(50,30));
	}

}
