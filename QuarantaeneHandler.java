package XMLgedoens;

import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class QuarantaeneHandler extends DefaultHandler {
	private Stadt stadt;
	private Bezirk bezirk;
	private Standortbericht sob;
	private String text;
	
	public Stadt getStadt(){
		return this.stadt;
	}
	
	
	public void startElement(String namespaceURI, String localname, String qName, Attributes attr){
		//Eine Neue Stadt initialisieren.
		if(qName=="Stadt"){
			stadt = new Stadt(attr.getValue("name"));
		}
		//Einen Neuen Bezirk oeffnen.
		if(qName.equals("Bezirk")){
			bezirk =new Bezirk(attr.getValue("name"));
		}
		//Einen neuen Standortbericht oeffnen.
		if(qName.equals("Standortbericht")){
			int y = Integer.parseInt(attr.getValue("y"));
			int x = Integer.parseInt(attr.getValue("x"));
			sob = new Standortbericht(attr.getValue("informant"), x, y);	

		}
		
	}
	
	public void endElement(String namespaceURI, String localname, String qName){
		//Der Stadt einen neuen Bezirk hinzufuegen.
		if(qName=="Bezirk"){
			stadt.addBezirk(bezirk);
		}
		//Dem aktuellem Bezirk einen neuen Standortbericht hinzufuegen.
		if(qName.equals("Standortbericht")){
			if(text.contains("Ja")){
				sob.setBestaetigung(true);
				
				int y = sob.getY();
				int x = sob.getX();
				
				//Gibt es bereits eine Qarantaenezone?
				if(bezirk.hasQZone()){
				//Grenzen für die Quarantaenezone ggf. anpassen.
					if(!(bezirk.getBottomLine()<y)){
						bezirk.setBottomLine(y);
					}
					if(!(bezirk.getRightLine()>x)){
						bezirk.setRightLine(x);
					}
					if(!(bezirk.getTopLine()>y)){
						bezirk.setTopLine(y);
					}
					if(!(bezirk.getLeftLine()<x)){
						bezirk.setLeftLine(x);
					}
				}
				//Wenn es noch keine Zone gibt 
				else{bezirk.setLeftLine(x);bezirk.setTopLine(y);
					 bezirk.setRightLine(x);bezirk.setBottomLine(y);}
			}
			else{sob.setBestaetigung(false);}
			bezirk.addSOB(sob);
		}
	}
	
	//Den Text der Standorberichte brauchbar machen und speichern.
	public void characters(char[] chs, int start, int length){
		text = String.valueOf(chs, start, length);
	}
}
