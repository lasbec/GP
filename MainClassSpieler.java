package threadGedoens;

public class MainClassSpieler {
	public static void main(String[] args){
		
		Spieler sm = new Spieler("skinny Mat");
		Spieler ba = new Spieler("big Alberto");
		sm.setGegner(ba);
		ba.setGegner(sm);
		
		sm.start();
		ba.start();
		
	}
}
