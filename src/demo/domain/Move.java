package demo.domain;

import demo.domain.interfaces.Character;

public interface Move {
	
	void printDescription();
	int getAttack();
	void setAttack();
	int getHeal();
	void setHeal();
	void execute(Character c);
	String getType();
	
}

