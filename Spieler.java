package threadGedoens;

public class Spieler extends Thread{
	private Spieler Gegner;
	private int Punkte = 0;
	
	Spieler(String name){
		super(name);
	}
	
	public void setGegner(Spieler geg){
		this.Gegner = geg;
	}


	public void run() {
		for(int i=0; i<4; i++){
			greifePfeil();
			wirf();
			verspotte();
			
		}
	}
	//Der Spieler greift sich ein Pfeil, währenddessen kann er verspottet werden und reagieren.
	private void greifePfeil(){
		try{Thread.sleep((int)(Math.random()*101));}
		catch (InterruptedException e) {System.out.println(this.getName()+": Das wollen wir doch mal sehen!");}
	}
	
	
	//Der Spieler wirft eine zufällige Anzahl an Punkten zischen 0 und einschließlich 20.
	private void wirf(){
		int Punkte = (int)(Math.random()*21);
		this.Punkte = this.Punkte + Punkte;
		System.out.println(this.getName()+": "+this.Punkte);
	}
	//Der Spieler verspottet zu 50% seinen Gegner.
	private void verspotte(){
		if((int)(Math.random()*2)==1){
			System.out.println(this.getName()+": Ich bin der Größte!");
			Gegner.interrupt();
		}
	}
	

}
