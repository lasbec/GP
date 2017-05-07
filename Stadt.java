package XMLgedoens;

import java.util.ArrayList;

public class Stadt {
	private String name;
	protected ArrayList<Bezirk> bezirke = new ArrayList<Bezirk>();
	
	Stadt(String name){
		this.name = name;
	}
	
	public void addBezirk(Bezirk bez){
		bezirke.add(bez);
	}
	
	public String toString(){
		String bez = new String();
		for(Bezirk b: bezirke){
			bez = bez + b.toString() + "\n";
		}
		return "Stadtname: "+ name +"\n\n"+bez;
	}
	
	

}
