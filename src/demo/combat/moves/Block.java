package demo.combat.moves;

import demo.domain.Move;
import demo.domain.interfaces.Character;

public class Block implements Move{

	private String name;
	
	public Block(String name) {
		this.name = name;
	}
	
	@Override
	public String printDescription() {
		return "";
		
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Character c) {
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getTurnsUntilUse() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void waitATurn() {
		// TODO Auto-generated method stub
		
	}

}
