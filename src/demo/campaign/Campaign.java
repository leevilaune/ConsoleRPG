package demo.campaign;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.levels.beach.*;
import demo.campaign.levels.forest.*;
import demo.campaign.levels.mistral.*;
import demo.campaign.storylines.Earth;
import demo.domain.DropController;
import demo.domain.Level;
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
	}
	/*
	private void setLevels() {
		//setting The Forest levels
		this.levels.add(new Forest1(p, r, dc));
		this.levels.add(new Forest2(p, r, dc));
		this.levels.add(new Forest3(p, r, dc));
		this.levels.add(new Forest4(p, r, dc));
		this.levels.add(new ForestBoss(p, r, dc));
		
		//setting The Beach levels
		this.levels.add(new Beach1(p, r, dc));
		this.levels.add(new Beach2(p, r, dc));
		this.levels.add(new Beach3(p, r, dc));
		this.levels.add(new Beach4(p, r, dc));
		this.levels.add(new BeachBoss(p, r, dc));
		
		//setting Mistral levels
		this.levels.add(new Mistral1(p, r, dc));
	}
	*/
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
