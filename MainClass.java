package XMLgedoens;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainClass {
	public static void main(String[] args) throws Exception{
		SAXParserFactory fac = SAXParserFactory.newInstance();
		SAXParser parser = fac.newSAXParser();
		QuarantaeneHandler QH = new QuarantaeneHandler();
		parser.parse("src/XMLgedoens/daten.xml", QH);
		
		Stadt Pb = QH.getStadt();
		
		for(Bezirk bez: Pb.bezirke){
			int[] borders = {bez.getTopLine(), //Array ist nach dem "Nie ohne Seife waschen"-Prinip aufgebaut.
							 bez.getRightLine(),
							 bez.getBottomLine(),
							 bez.getLeftLine()};
			System.out.println(bez.getName()+" Quarantaenezone:");
			System.out.println("Punkt 1: (" + borders[0] +","+borders[1]+")" );
			System.out.println("Punkt 2: (" + borders[0] +","+borders[3]+")" );
			System.out.println("Punkt 3: (" + borders[2] +","+borders[1]+")" );
			System.out.println("Punkt 4: (" + borders[2] +","+borders[3]+")" );
			
		}
		
		
	}

}
