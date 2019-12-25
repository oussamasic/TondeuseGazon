package TondeuseAuto.Tondeuse.service;

import TondeuseAuto.Tondeuse.model.Pelouse;
import TondeuseAuto.Tondeuse.model.Tondeuse;

public class Tondeuseservices {
	
	//Tondeuse tondeuse = new Tondeuse();
	Pelouse pelouse = new Pelouse();
	Mouvementservices mvservice = new Mouvementservices();
	

	public boolean isInsideLawn(int xPosition, int yPosition) {
		return xPosition > pelouse.getLongueur() || xPosition < 0 || yPosition > pelouse.getLargeur() || yPosition < 0 ? false : true;
	}
	

public boolean executeInstructions(Tondeuse tondeuse) {
		
		if(tondeuse.getInstructions() != null) {
		
			char[] letters = tondeuse.getInstructions().toCharArray();
			
			for (char letter : letters) {
				switch (letter) {
				case 'A':
					mvservice.avancer(tondeuse);
					break;
				case 'D':
					mvservice.tourneAdroite(tondeuse);
					break;
				case 'G':
					mvservice.tourneAgauche(tondeuse);
					break;
				default:
					return false;
				}
			}
			
			return true;
		}
		
		return false;
		
	}

}
