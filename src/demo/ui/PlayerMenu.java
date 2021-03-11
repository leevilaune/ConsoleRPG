package demo.ui;

import java.util.Scanner;

import demo.domain.Player;

public class PlayerMenu {
	
	private Player player;
	private Scanner reader;
	
	public PlayerMenu(Player p, Scanner r) {

		this.player = p;
		this.reader = r;
	}
	public void start() {
		printCommands();
		while(true) {
			System.out.print("> ");
			String command = reader.nextLine();
			if(command.equals("list")) {
				printCommands();
			}else if(command.equals("close")) {
				break;
			}else if(command.equals("info")) {
				System.out.println(player.info());
			}else if(command.contains("give")) {
				give(command);
			}
		}
		System.out.println("--Player Menu Closed--");
	}
	private void printCommands() {
		System.out.println("--Player Commands--");
		System.out.println("  close - closes menu");
		System.out.println("  list  - lists all commands");
		System.out.println("  info  - prints info about player");
	}
	private void give(String command) {
		String[] parts = command.split(" ");
		int amount = Integer.parseInt(parts[1]);
		this.player.getLevelingController().addXP(amount);
	}
}
