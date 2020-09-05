package demo.campaign.storylines;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.locations.Forest;
import demo.domain.DropController;
import demo.domain.Location;
import demo.domain.Player;
import demo.domain.Storyline;

public class Earth extends Storyline{

	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Earth(Player p, Scanner r, DropController dc) {
		super(p, r);
		
		this.p = p;
		this.r = r;
		this.dc = dc;
		
		super.setName("Earth");
		super.setLocations(setLocations());
	}
	
	public List<Location> setLocations() {
		List<Location> locations = new ArrayList<>();
		locations.add(new Forest(r,p, dc));
		
		return locations;
	}
	
}
