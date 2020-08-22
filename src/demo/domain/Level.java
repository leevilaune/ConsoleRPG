package demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level {
	
	private boolean isLocked;
	private boolean isCompleted;
	private String name;
	
	private Player player;
	private Scanner scanner;
	
	private List<Bot> bots;
	private List<Bot> firstWave;
	
	public Level(Player p, Scanner r, List<Bot> fw, String name) {
		this.player = p;
		this.bots = fw;
		this.firstWave = bots;
		this.scanner = r;
		this.isLocked = true;
		this.isCompleted = false;
		this.name = name;
	}
	public void start() {
		player.resetHP();
		this.firstWave = bots;
		this.printCommands();
		while(true) {
			if(this.firstWave.size() == 0) {
				System.out.println("Level Cleared!");
				this.firstWave.addAll(bots);
				this.player.resetHP();
				this.isCompleted = true;
				break;
			}
			System.out.print("> ");
			String command = scanner.nextLine();
			if(command.equals("close")||player.getHP() <= 0) {
				System.out.println("You lost the level");
				break;
			}else if(command.equals("list bots")) {
				listBots();
			}else if(command.equals("attack")){
				this.attack();
				cycleBots();
			}else if(command.contains("attack")) {
				this.attack(command);
				cycleBots();
			}else if(command.equals("heal")) {
				this.player.heal();
				cycleBots();
			}
			System.out.println(this.player);
		}
		
	}
	
	private void printCommands() {
		System.out.println("--Combat Commands--");
		System.out.println("  close         - closes combat view");
		System.out.println("  list bots     - list all bots");
		System.out.println("  attack        - attack first bot");
		System.out.println("  attack [bot] 	- attacks selected bot");
		System.out.println("  heal          - heals player");
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
	private void attack() {
		Bot b = getFirstBot();
		player.attack(b);
		System.out.println(b.getHP());
		
	}
	private void listBots() {
		for(Bot b: this.firstWave) {
			System.out.println(b);
		}
	}
	
	private void cycleBots() {
		ArrayList<Bot> dead = new ArrayList<>();
		for(Bot b: this.firstWave) {
			if(b.getHP() < 0) {
				System.out.println(b.getName() + " Killed");
				dead.add(b);
			}else {
				b.makeMove(this.player);
				System.out.println(b);
			}
		}
		this.firstWave.removeAll(dead);
	}
	
	private Bot getByName(String name) {
		for(Bot b: this.firstWave) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		return null;
	}
	private Bot getFirstBot() {
		return this.firstWave.get(0);
	}
	public void setCompleted(boolean b) {
		this.isCompleted = b;
	}
	public boolean isCompleted() {
		return this.isCompleted;
	}
	public void setLocked(boolean b) {
		this.isLocked = b;
	}
	public boolean isLocked() {
		return this.isLocked;
	}
	public void setName(String s) {
		this.name = s;
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return this.name + "\n  Locked:    " + this.isLocked + "\n  Completed: " + this.isCompleted;
	}
}