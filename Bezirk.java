package XMLgedoens;

import java.util.ArrayList;

public class Bezirk {
	private String name;
	private ArrayList<Standortbericht> standorte = new ArrayList<Standortbericht>();
	//Grenzen fur die Qarantaenezone
	private boolean QZone=false; 
	private int topLine;
	private int bottomLine;
	private int rightLine;
	private int leftLine;
	
	
	
	public boolean hasQZone(){
		return QZone;
	}
	
	public void setTopLine(int topLine) {
		this.topLine = topLine;
		QZone = true;
	}

	public int getTopLine() {
		return topLine;
	}

	public int getRightLine() {
		return rightLine;
	}

	public int getBottomLine() {
		return bottomLine;
	}

	public int getLeftLine() {
		return leftLine;
	}

	public void setRightLine(int rightLine) {
		this.rightLine = rightLine;
		QZone = true;
	}

	public void setBottomLine(int bottomLine) {
		this.bottomLine = bottomLine;
		QZone = true;
	}

	public void setLeftLine(int leftLine) {
		this.leftLine = leftLine;
		QZone = true;
	}

	Bezirk(String name){
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}

	public void addSOB(Standortbericht sob){
		standorte.add(sob);
	}

	public String toString(){
		String s = new String();
		for(Standortbericht sob: standorte){
			s = s + sob.toString() + "\n";
		}
		return "Bezirksname: "+ name +
				"\n Quarantaenezone: "+
				"\n Nord Grenze: " +topLine+
				"\n Sued Grenze: " +bottomLine+
				"\n Ost  Grenze: " +rightLine+
				"\n West Grenze: " +leftLine+
				"\n\n"+ s ;
	}
}
