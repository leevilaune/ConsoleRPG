package demo.campaign.levels;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.GenericBot;
import demo.domain.Bot;
import demo.domain.Level;
import demo.domain.Player;

public class TutorialLevel extends Level{
	
	public TutorialLevel(Player p, Scanner r) {
		super(p, r, setBots(), "Tutorial");
		super.setLocked(false);
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		for(int i = 1; i <= 3; i++) {
			bots.add(new GenericBot(i));
		}
		return bots;
	}
}
