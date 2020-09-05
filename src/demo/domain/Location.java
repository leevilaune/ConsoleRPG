package demo.domain;

import java.util.List;
import java.util.Scanner;

public class Location {

	private String name;
	private boolean isLocked;
	private boolean isCompleted;
	
	private Scanner r;
	private Player p;
	
	private List<Level> levels;
	
	public Location(Scanner r, Player p, String name) {
		this.r = r;
		this.p = p;
		this.name = name;
		this.isCompleted = false;
		this.isLocked = true;
	}
	
	public void start() {
		printCommands();
		while(true) {
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.contains("start")) {
				startLevel(command);
				cycleLevels();
			}else if(command.equals("list levels")) {
				listLevels();
			}
		}
	}
	
	public void startLevel(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			for(Level l: this.levels) {
				if(l.getName().equals(parts[1])) {
					if(!l.isLocked()) {
						l.start();
					}else {
						System.out.println("Level is Locked");
					}
				}
			}
		}
	}
	public void listLevels() {
		for(Level l: this.levels) {
			System.out.println(l);
		}
	}
	private void cycleLevels() {
		for(Level l: this.levels) {
			l.setLocked(false);
			if(l.isCompleted()) {
				continue;
			}else {
				break;
			}
		}
		if(this.levels.get(this.levels.size()-1).isCompleted()) {
			this.isCompleted = true;
		}
	}
	private void printCommands() {
		System.out.println("--Location Commands--");
		System.out.println("  close         - closes location");
		System.out.println("  start [level] - start level");
		System.out.println("  list levels   - lists levels");
	}
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	public boolean isLocked() {
		return this.isLocked;
	}
	public void setLocked(boolean b) {
		this.isLocked = b;
	}
	public boolean isCompleted() {
		return this.isCompleted;
	}
	public void setCompleted(boolean b) {
		this.isCompleted = b;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name + "\n  Locked:    " + this.isLocked + "\n  Completed: " + this.isCompleted;
	}
	
}
