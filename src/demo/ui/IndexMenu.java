package demo.ui;

import java.util.Scanner;

import demo.domain.Gear;
import demo.domain.ItemIndex;

public class IndexMenu {
	
	private ItemIndex index;
	private Scanner reader;
	
	public IndexMenu(Scanner r, ItemIndex ii) {
		this.index = ii;
		this.reader = r;
	}
	public void start() {
		this.printCommands();
		while(true) {
			System.out.print("> ");
			String command = reader.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.equals("list")) {
				printCommands();
			}else if(command.equals("index")) {
				index.listItems();
			}else if(command.contains("find")){
				find(command);
			}else if(command.contains("details")) {
				details(command);
			}
			else {
				System.out.println("Invalid Command");
			}
		}
		System.out.println("--Index Closed--");
	}
	public void details(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			this.index.getDetails(parts[1]);
		}
	}
	public void find(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length > 1) {
			index.setFound(parts[1]);
		}else {
			System.out.println("  You need to use 'find [item name]'");
		}
	}
	private void printCommands() {
		System.out.println("--Index Menu Commands--");
		System.out.println("  close   - closes index menu");
		System.out.println("  list	  - list index menu commands");
		System.out.println("  index	  - prints all items");
		System.out.println("  details - prints item with details");
	}
}

