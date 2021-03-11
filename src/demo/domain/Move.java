package demo.domain;

import demo.domain.interfaces.Character;

public interface Move {
	
	String printDescription();
	int getAttack();
	void setAttack();
	int getHeal();
	void setHeal();
	void execute(Character c);
	int getTurnsUntilUse();
	void waitATurn();
	String getType();
	
}

