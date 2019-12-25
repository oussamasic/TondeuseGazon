package TondeuseAuto.Tondeuse.service;

import java.util.LinkedList;
import java.util.List;

import TondeuseAuto.Tondeuse.exceptions.FileException;
import TondeuseAuto.Tondeuse.model.Pelouse;
import TondeuseAuto.Tondeuse.model.Tondeuse;



public abstract class AbstractTondeuse {
	
	Tondeuseservices tservice = new Tondeuseservices();
	
	 // Tondeuses ajoutées
	 
	protected List<Tondeuse> tondeuses = new LinkedList<Tondeuse>();

	//ajouter une tondeuse
	public void ajouterTondeuse(Tondeuse tondeuse) throws FileException {
		
		if(!isValidDirection(tondeuse.getDirection())) {
			throw new FileException("TONDEUSE_DIRECTION_ERROR", "Direction d'une tondeuse invalide.");
		}
		
		if(!isValidInstructionsInfo(tondeuse.getInstructions())) {
			throw new FileException("TONDEUSE_INSTRUCTIONS_ERROR", "Erreur dans les instructions d'une tondeuse.");
		}
		
		if(!isValidPosition(tondeuse.getPelouse(), tondeuse.getxPosition(), tondeuse.getyPosition())) {
			throw new FileException("ERROR_TONDEUSE_DESCRIPTION", "Erreur dans la description d'une tondeuse.");
		}
		
		tondeuses.add(tondeuse);
		
	}
	
// démarrer la tndeuse
	public String starTondeuse() {
		
		StringBuilder tondeusesPositions = new StringBuilder();
		
		Tondeuse tondeuse = null;
		
		while(!hasNexttondeuse()) {
			tondeuse = tondeusesuivante();
			tservice.executeInstructions(tondeuse);
			
			tondeusesPositions.append(tondeuse).append("\n");
		}
		
		return tondeusesPositions.toString();
	}
	
// Vérifie la validité d'une instruction

	protected boolean isValidInstructionsInfo(String instructions) {
		
		if(instructions != null) {
		
			char[] letters = instructions.toCharArray();
			
			for (char letter : letters) {
				if(	   !new Character('A').equals(letter)
					&& !new Character('D').equals(letter)
					&& !new Character('G').equals(letter))
				{
					return false;
				}
			}
			
		}
		else {
			return false;
		}
		
		return true;
	}
	
// Vérifie la validité de la direction

	protected boolean isValidDirection(char direction) {
		if(!new Character('N').equals(direction)
		&& !new Character('E').equals(direction)
		&& !new Character('S').equals(direction)
		&& !new Character('W').equals(direction)) {
			return false;
		}
		
		return true;
	}
	

	protected boolean isValidPosition(Pelouse pelouse, int xPosition, int yPosition) {
		if(pelouse != null) {
			return xPosition > pelouse.getLargeur() || xPosition < 0 || yPosition > pelouse.getLongueur() || yPosition < 0 ? false : true;
		}
		else {
			return false;
		}
	}
	

	
	public Tondeuse tondeusesuivante() {
		return ((LinkedList<Tondeuse>)tondeuses).poll();
	}
	
public boolean hasNexttondeuse() {
		return ((LinkedList<Tondeuse>)tondeuses).isEmpty();
	}
	
	protected List<Tondeuse> getTondeuses() {
		return tondeuses;
	}

}
