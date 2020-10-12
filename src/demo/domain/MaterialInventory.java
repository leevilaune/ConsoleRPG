package demo.domain;

import java.util.ArrayList;
import java.util.List;

public class MaterialInventory {
	
	private List<Material> materials;
	
	public MaterialInventory() {
		this.materials = new ArrayList<>();
	}
	
	public void addMaterial(Material m, int a) {
		if(this.containsMaterial(m)) {
			this.findMaterial(m).setAmount(findMaterial(m).getAmount()+a);
		}else {
			Material mtrl = m;
			mtrl.setAmount(a);
			this.materials.add(mtrl);
		}
	}
	
	public void removeMaterials(Material m, int a) {
		if(this.containsMaterial(m)) {
			this.findMaterial(m).setAmount(findMaterial(m).getAmount()+a);
		}else{
			System.out.println("Material not found");
		}
	}
	
	public List<Material> getMaterials(){
		return this.materials;
	}
	private boolean containsMaterial(Material m) {
		for(Material mt: this.materials) {
			if(mt.getName().equals(m.getName())){
				return true;
			}
		}
		return false;
	}
	private Material findMaterial(Material m) {
		Material mtrl = null;
		for(Material mt: this.materials) {
			if(mt.equals(m)) {
				mtrl = m;
				break;
			}
		}
		return mtrl;
	}
	
	public void listMaterials() {
		for(Material m: this.materials) {
			System.out.println(m);
		}
	}
	
	public void getMaterial(String name) {
		
	}
}
