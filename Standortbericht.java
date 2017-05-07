package XMLgedoens;

public class Standortbericht {
	private String informant;
	private boolean bestaetigung;
	private int x;
	private int y;
	
	Standortbericht(String info, int x, int y){
		informant = info;
		this.x = x;
		this.y = y;
	}
	
	public void setBestaetigung(boolean b){
		bestaetigung = b;
	}
	
	public String toString(){
		return informant + " x:"+x+" y:"+y+" Bestaetigung: " +(bestaetigung?"Ja":"Nein");
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	

}
