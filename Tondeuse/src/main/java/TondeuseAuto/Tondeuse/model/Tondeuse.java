package TondeuseAuto.Tondeuse.model;

import TondeuseAuto.Tondeuse.exceptions.TondeuseException;

public class Tondeuse {

	 int xPosition;
	
	 int yPosition;

	 char direction;

	 String instructions;

	 Pelouse pelouse;

	public Tondeuse(Pelouse pelouse,int xPosition, int yPosition, char direction, String instructions) throws TondeuseException{
	
		if(direction != 'N' && direction != 'E' && direction != 'S' && direction != 'W') {
    		throw new TondeuseException("TONDEUSE_DIRECTION_ERROR", "Erreur dans la description de la direction de la tondeuse.");
    	}
    	
		if(instructions == null) {
			throw new TondeuseException("NULL_INSTRUCTIONS", "Instructions absentes.");
		}
		else {
			this.instructions = instructions;
		}
	
    	if(pelouse == null) {
    		throw new TondeuseException("NULL_PELOUSE", "Description de la pelouse absente.");
    	}
    	else {
    		this.pelouse = pelouse;
		}
    	
    	this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
		

	
	}

	public Tondeuse() {
		super();
	}

	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public char getDirection() {
		return direction;
	}

	public String getInstructions() {
		return instructions;
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}

	@Override
	public String toString() {
		return "Tondeuse [xPosition=" + xPosition + ", yPosition=" + yPosition + ", direction=" + direction
				+ ", instructions=" + instructions + ", pelouse=" + pelouse + "]";
	}
	
	
	
	

}
