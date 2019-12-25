package TondeuseAuto.Tondeuse.service;

import TondeuseAuto.Tondeuse.model.Tondeuse;

public class Mouvementservices {
	
	Tondeuse tondeuse = new Tondeuse();
	Tondeuseservices tservice = new Tondeuseservices();

	public void avancer(Tondeuse td) {
		int nextXPosition = td.getxPosition();
		int nextYPosition = td.getyPosition();
		
		switch(td.getDirection()) {
			case 	'N': nextYPosition += 1;
					break;
			case 	'E': nextXPosition += 1;
					break;
			case 	'S': nextYPosition -= 1;
					break;
			case 	'W': nextXPosition -= 1;
					break;
		}
		
		if(tservice.isInsideLawn(nextXPosition, nextYPosition)) {

			
			tondeuse.setxPosition(nextXPosition);
			tondeuse.setyPosition(nextYPosition);
		}
	}
	

	public void tourneAdroite(Tondeuse td) {

			switch(td.getDirection()) {
			case 	'N': td.setDirection('E');
					break;
			case 	'E': td.setDirection('S');
					break;
			case 	'S': td.setDirection('W');
					break;
			case 	'W': td.setDirection('N');
					break;
		}

	}
	public void tourneAgauche(Tondeuse td) {
			switch(td.getDirection()) {
			case 	'E': td.setDirection('N');
					break;
			case 	'S': td.setDirection('E') ;
					break;
			case 	'W': td.setDirection('S') ;
					break;
			case 	'N': td.setDirection('W') ;
					break;
		}
	}
	

}
