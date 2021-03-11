package demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import demo.campaign.levels.forest.Forest1;
import demo.domain.DropController;
import demo.domain.Equipment;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.LevelingController;
import demo.domain.Player;
import demo.raid.levels.GoblinQueenRaid;
import demo.ui.Menu;
import demo.utility.Tester;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		
		Tester t = new Tester();
		
		//t.testGoblinQueenDrops(100);
		
		Random r = new Random();
		
		LevelingController lvlCtrl = new LevelingController();
		
		/*
		
		for(int i = 1; i<=150; i++) {
		//	System.out.println(i + ". " + lvlCtrl.getXpForLevel(i));
			int rXp = r.nextInt(10);
			System.out.println("Added xp: " + (rXp+1));
			lvlCtrl.addXP(rXp+1);
			System.out.println(lvlCtrl);
		}
		
		*/
		
		Menu menu = new Menu();
		menu.start();	
	}
}
