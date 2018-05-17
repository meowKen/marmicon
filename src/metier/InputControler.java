package metier;

public class InputControler {

	public static boolean isUniform(String str, char car) {
		try {
			int n = 0;
			for(char c : str.toCharArray()) {
				if(c == car) {
					n++;
				}
			}
			if(n == str.length()) {
				return true;	
			} else {
				return false;
			} 
		} catch(NullPointerException npe) {
			return true;
		}
	}
	
	public static boolean isNumeric(String str) {
		for(char c : str.toCharArray()) {
			if(c < 48 && c > 57) {
				return false;
			}
		}
		return true;
	}
}
