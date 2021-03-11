package demo.ui;

import java.util.Scanner;

import demo.raid.Raid;

public class RaidMenu {
	
	private Raid raid;
	private Scanner r;
	
	public RaidMenu(Raid rd, Scanner r) {
		this.raid = rd;
		this.r = r;
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
			}
		}
	}
	private void startLevel(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			raid.start(parts[1]);
		}
	}
	private void printCommands() {
		System.out.println("--Raid Commands--");
		System.out.println("  list         - list commands");
		System.out.println("  start [name] - starts raid");
	}
}
