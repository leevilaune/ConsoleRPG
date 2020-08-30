package demo.ui;

import java.util.Scanner;

import demo.campaign.Campaign;

import demo.domain.DropController;
import demo.domain.Player;

public class CampaignMenu {
	
	private Campaign campaign;
	private Scanner scanner;

	public CampaignMenu(Scanner r, Player p, DropController dc) {
		this.scanner = r;
		this.campaign = new Campaign(p, r, dc);
	}
	public void start() {
		printCommands();
		while(true) {
			System.out.print("> ");
			String command = scanner.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.equals("list levels")) {
				campaign.listLevels();
			}else if(command.equals("list")) {
				printCommands();
			}else if(command.contains("start")) {
				startLevel(command);
			}
		}
	}
	private void printCommands() {
		System.out.println("--Campaign Commands--");
		System.out.println("  close         - closes campaign");
		System.out.println("  list          - lists commands");
		System.out.println("  list levels   - lists levels");
		System.out.println("  start [level] - starts level");
	}
	public void startLevel(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			campaign.start(parts[1]);
		}
	}
	public boolean isCompleted(String name) {
		return campaign.isLevelCompleted(name);
	}
}
