package demo.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.Goblin;
import demo.combat.bots.TargetDummy;
import demo.domain.Bot;
import demo.domain.Player;

public class CombatTestScene {
	
	private TargetDummy dummy;
	private List<Bot> bots;
	private Player player;
	private Scanner scanner;
	
	public CombatTestScene(Player p, Scanner r) {
		this.bots = new ArrayList<>();
		this.player = p;
		this.scanner = r;
		this.dummy = new TargetDummy();
		this.setBots();
		
	}
	private void setBots() {
		for(int i = 1; i <= 3; i++) {
			this.bots.add(new Goblin(1,1));
		}
	}
	public void start() {
		this.printCommands();
		while(true) {
			System.out.println(player);
			System.out.print("> ");
			String command = scanner.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.contains("attack")) {
				attack(command);
				cycleBots();
			}else if(command.equals("reset")) {
				this.setBots();
			}else if(command.equals("list bots")) {
				this.listBots();
			}
		}
	}
	private void printCommands() {
		System.out.println("--Combat Commands--");
		System.out.println("  close         - closes combat view");
		System.out.println("  list bots     - list all bots");
		System.out.println("  attack [bot] 	- attacks selected bot");
		System.out.println("  heal          - heals player");
		System.out.println("  reset         - resets target dummy");
	}
	private void attack(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			Bot b = (getByName(parts[1]));
			if(b != null) {
				player.attack(b);
			}
		}
	}
	private void listBots() {
		for(Bot b: this.bots) {
			System.out.println(b);
		}
	}
	private void cycleBots() {
		ArrayList<Bot> dead = new ArrayList<>();
		for(Bot b: this.bots) {
			if(b.getHP() < 0) {
				System.out.println(b.getName() + " Killed");
				dead.add(b);
			}else {
				b.makeMove(this.player);
				System.out.println(b);
			}
		}
		this.bots.removeAll(dead);
	}
	private Bot getByName(String name) {
		for(Bot b: this.bots) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		return null;
	}
}
