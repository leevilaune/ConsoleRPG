package demo.domain;

import java.util.Scanner;

public class City {
	
	private Scanner r;
	
	public City(Scanner r) {
		
		this.r = r;
		
	}
	
	public void start() {
		while(true) {
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")){
				break;
			}
		}
	}
}
