/**
 * Classe do tipo do arranjo
 */
package base;

public class Camp {
	//Variaveis para os campos do arranjo
	private String camp1;	
	private String camp2;
	
	public Camp(String camp1, String camp2){
		this.camp1 = camp1;
		this.camp2 = camp2;
	}
	
	public String getCamp1() {
		return camp1;
	}
	
	public void setCamp1(String camp1) {
		this.camp1 = camp1;
	}
	
	public String getCamp2() {
		return camp2;
	}
	
	public void setCamp2(String camp2) {
		this.camp2 = camp2;
	}
	
}
