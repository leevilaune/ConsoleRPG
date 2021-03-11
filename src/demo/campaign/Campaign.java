package demo.campaign;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.storylines.*;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Location;
import demo.domain.Player;
import demo.domain.Storyline;

public class Campaign {
	
	private List<Storyline> storylines;
	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Campaign(Player p, Scanner r, DropController dc) {
		this.storylines = new ArrayList<>();
		this.p = p;
		this.r = r;
		this.dc = dc;
		setStorylines();
	}
	public void start(String level) {
		unlockAll();
		for(Storyline s: this.storylines) {
			if(s.getName().equals(level)) {
				if(!s.isLocked()) {
					s.start();
					cycleStorylines();
				}else {
					System.out.println("Level is Locked");
				}
			}
		}
	}
	private void unlockAll() {
		for(Storyline s: this.storylines) {
			s.setLocked(false);
		}
	}
	private void cycleStorylines() {
		for(Storyline s: this.storylines) {
			s.setLocked(false);
			if(s.isCompleted()) {
				continue;
			}else {
				break;
			}
		}
	}
	public void setStorylines() {
		this.storylines.add(new Earth(p, r, dc));
		this.storylines.add(new Water(p, r, dc));
	}

	public List<Level> getSave() {
		List<Level> lvls = new ArrayList<>();
		for(Storyline s: this.storylines) {
			for(Location l: s.getLocations()) {
				for(Level lvl: l.getLevels()) {
					lvls.add(lvl);
					//System.out.println(lvl.getSave());
				}
			}
		}
		return lvls;
	}
	public void listStorylines() {
		for(Storyline s: this.storylines) {
			System.out.println(s);
		}
	}
	private Storyline getStorylineByName(String name) {
		for(Storyline s: this.storylines) {
			if(s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	public boolean isStorylineCompleted(String level) {
		return getStorylineByName(level).isCompleted();
	}
}
