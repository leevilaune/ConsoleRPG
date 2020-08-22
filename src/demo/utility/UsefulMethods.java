package demo.utility;

import demo.domain.Gear;

public class UsefulMethods {
	
	public double doubleFormat(double num, double decimals) {
		
		StringBuilder numberBuilder = new StringBuilder();
		
		String number = String.valueOf(num);
		
		String[] split = number.split("\\.");
		
		if(split[1].length() <= decimals) {
			return Double.valueOf(number);
		}
		
		numberBuilder.append(split[0]);
		numberBuilder.append(".");
		for(int i = 0; i<decimals; i++) {
			numberBuilder.append(split[1].charAt(i));
		}
		
		number = String.valueOf(numberBuilder);
		
		return Double.valueOf(number);
	}
	public static String saveFileCode(String name, int ammount) {
		
		StringBuilder saveCode = new StringBuilder();
		
		String[] parts = name.split(" ");
		
		if(parts[0].length() < 3) {
			saveCode.append(parts[0]);
		}else {
			for(int i = 0; i<3; i++) {
				saveCode.append(parts[0].charAt(i));
			}
		}
		if(parts[1].length() < 3) {
			saveCode.append(parts[0]);
		}else {
			for(int i = 0; i<3; i++) {
				saveCode.append(parts[1].charAt(i));
			}
		}
		saveCode.append(" " + ammount);
		return String.valueOf(saveCode);
	}
	public boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
		    return true;
		} catch(NumberFormatException e){  
			  	return false;  
		}  
	}
}
