package demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

	private String name;
	private MaterialInventory mInv;
	private List<Material> required;
	
	public Recipe(String n,MaterialInventory mi) {
		this.name = n;
		this.mInv = mi;
		this.required = new ArrayList<>();
	}
	
	public void setRequirements(List<Material> req) {
		this.required = req;
	}
	
	public boolean areMet(List<Material> inv) {
		for(Material m: this.required) {
			for(Material m2: inv) {
				if(m.getName().equals(m2.getName())) {
					if(m2.getAmount() >= m.getAmount()) {
						continue;
					}else {
						System.out.println("Not enough " + m.getName());
						break;
					}
				}
			}
			return true;
		}
		return false;
	}
	public void craft() {
		for(Material m: this.required) {
			mInv.removeMaterials(m, m.getAmount());
		}
	}
	private String printRequirement() {
		StringBuilder builder = new StringBuilder();
		for(Material m: this.required) {
			builder.append("    " + m + " " + m.getAmount() + "\n");
		}
		return String.valueOf(builder);
	}
	@Override
	public String toString() {
		return this.name + " "
				+ "\n  Recipe:\n" + this.printRequirement();
	}
}
