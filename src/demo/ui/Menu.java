package demo.ui;

import java.util.Scanner;

import demo.combat.CombatTestScene;
import demo.domain.ChestInventory;
import demo.domain.DropController;
import demo.domain.Equipment;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.Player;

public class Menu {
	
	private Scanner r;
	private ItemIndex index;
	private IndexMenu indMenu;
	private Inventory inv;
	private InventoryMenu invMenu;
	private ChestInventory chestInv;
	private ChestMenu chestMenu;
	private Equipment equip;
	private Player player;
	private CombatTestScene combat;
	private DropController dc;
	private CampaignMenu campMenu;
	
	public Menu() {
		this.r = new Scanner(System.in);
		this.equip = new Equipment();
		this.index = new ItemIndex();
		this.indMenu = new IndexMenu(r, index);
		this.inv = new Inventory(index);
		this.chestInv = new ChestInventory();
		this.invMenu = new InventoryMenu(inv, index, equip, r);
		this.chestMenu = new ChestMenu(r, index, inv, chestInv);
		this.player = new Player(this.equip);
		this.dc = new DropController(inv, chestInv);
		this.campMenu = new CampaignMenu(r, player, dc);
	}
	public void start() {
		
		printCommandList();
		
		while(true) {
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.equals("list")) {
				printCommandList();
			}else if(command.equals("index")){
				indMenu.start();
			}else if(command.equals("inv")){
				invMenu.start();
			}else if(command.equals("chest")) {
				chestMenu.start();
			}else if(command.equals("combat")) {
				this.combat = new CombatTestScene(player, r);
				combat.start();
			}else if(command.equals("campaign")) {
				campMenu.start();
			}
			else {
				System.out.println("Invalid command");
			}
		}
		System.out.println("--Closed--");
	}
	private void printCommandList() {
		System.out.println("--Main Menu Commands--");
		System.out.println("  close    - closes the game");
		System.out.println("  list 	   - lists all commands");
		System.out.println("  index    - opens index menu");
		System.out.println("  inv	   - opens inventory menu");
		System.out.println("  chest    - opens chest menu");
		System.out.println("  combat   - opens combat menu");
		System.out.println("  campaign - opens campaign menu");
	}
}
