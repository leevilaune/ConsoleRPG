package demo.campaign.locations.earth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.levels.ruins.*;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Location;
import demo.domain.Player;

public class Ruins extends Location{

	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Ruins(Scanner r, Player p, DropController dc) {
		super(r, p, "Ruins");
		
		this.p = p;
		this.r = r;
		this.dc = dc;
		
		super.setLevels(setLevels());
	}
	public List<Level> setLevels(){
		List<Level> levels = new ArrayList<>();
		levels.add(new Ruins1(p, r, dc));
		levels.add(new Ruins2(p, r, dc));
		levels.add(new Ruins3(p, r, dc));
		levels.add(new Ruins4(p, r, dc));
		levels.add(new RuinsBoss(p, r, dc));
		return levels;
	}
}
