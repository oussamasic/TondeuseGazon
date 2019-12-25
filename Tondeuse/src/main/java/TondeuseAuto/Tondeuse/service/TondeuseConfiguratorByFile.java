package TondeuseAuto.Tondeuse.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import TondeuseAuto.Tondeuse.exceptions.FileException;
import TondeuseAuto.Tondeuse.exceptions.TondeuseException;
import TondeuseAuto.Tondeuse.model.Pelouse;
import TondeuseAuto.Tondeuse.model.Tondeuse;

public class TondeuseConfiguratorByFile extends AbstractTondeuse {
	

	public TondeuseConfiguratorByFile(String filename) throws FileException {
		Scanner scanner = readFile(filename);
		createtondeusesFromFile(scanner);
	}
	
//Démarre les tondeuses configurées

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
	
//vérification du fichier de configuration des tondeuses

	private Scanner readFile(String fileName) throws FileException {
		Scanner scanner = null;

		if(fileName == null) {
			throw new FileException("NO_FILE", "Fichier non trouvé.");
		}
		
		try {
			scanner = new Scanner(new File(fileName));
		} 
		catch (FileNotFoundException e) {
			throw new FileException("NO_FILE", "Fichier non trouvé.");
		}
		
		if(!scanner.hasNextLine()) {
			throw new FileException("EMPTY_FILE", "Fichier vide.");
		}
		
		return scanner;
	}
	
//Crée les tondeuses d'un fichier de configuration

	private void createtondeusesFromFile(Scanner scanner) throws FileException {
		Pelouse pelouse = null;
		
		String line = scanner.nextLine();
		String[] pelousetaille = line.split(" ");
		
		if(pelousetaille.length == 2) {
			try {
				pelouse = new Pelouse(Integer.parseInt(pelousetaille[0]), Integer.parseInt(pelousetaille[1]));
			}
			catch(NumberFormatException e) {
				throw new FileException("PELOUSE_SIZE_ERROR", "Taille de la pelouse non valide.");
			} 
		}
		else {
			throw new FileException("PELOUSE_SIZE_ERROR", "Erreur dans la description de la taille pelouse.");
		}
		
		if(!scanner.hasNextLine()) {
			throw new FileException("NO_TONDEUSE_ERROR", "Pas d'information de tondeuse.");
		}
		
while (scanner.hasNextLine()) {
		    String Info = scanner.nextLine();
		    String[] tondeuseInfo = Info.split(" ");
		    String instructionsInfo;
		    int xPosition;
		    int yPosition;
		    Tondeuse tondeuse;
		    
		 
			if(tondeuseInfo.length == 3) {
				
				Character direction = tondeuseInfo[2].charAt(0);
				
				if(!isValidDirection(direction)) {
					throw new FileException("TONDEUSE_DIRECTION_ERROR", "Direction d'une tondeuse invalide.");
				}
				
				try {
					xPosition = Integer.parseInt(tondeuseInfo[0]);
					yPosition = Integer.parseInt(tondeuseInfo[1]);
					
					if(!isValidPosition(pelouse, xPosition, yPosition)) {
						throw new FileException("ERROR_TONDEUSE_DESCRIPTION", "Erreur dans la description d'une tondeuse.");
					}
					
				}
				catch(NumberFormatException e) {
					throw new FileException("ERROR_TONDEUSE_DESCRIPTION", "Erreur dans la description d'une tondeuse.");
				} 
			}
			else {
				throw new FileException("ERROR_TONDEUSE_DESCRIPTION", "Erreur dans la description d'une tondeuse.");
			}
			
		
			if(scanner.hasNextLine()) {
				instructionsInfo = scanner.nextLine();
				
				if(!isValidInstructionsInfo(instructionsInfo)) {
					throw new FileException("TONDEUSE_INSTRUCTIONS_ERROR", "Erreur dans les instructions d'une tondeuse.");
				}
			}
			else {
				throw new FileException("ERROR_NO_TONDEUSE_INSTRUCTION", "Pas d'instruction pour une tondeuse.");
			}
			
			try {
				tondeuse = new Tondeuse(pelouse, xPosition, yPosition, tondeuseInfo[2].charAt(0), instructionsInfo);
			}
			catch (TondeuseException e) {
				throw new FileException(e.getMessageCourt(), e.getMessageLong());
			}

			ajouterTondeuse(tondeuse);
		 
		}
		 
		scanner.close();
			
	}
	

	public Tondeuse tondeusesuivante() {
		return ((LinkedList<Tondeuse>)tondeuses).poll();
	}
	

	public boolean hasNexttondeuse() {
		return ((LinkedList<Tondeuse>)tondeuses).isEmpty();
	}

}
