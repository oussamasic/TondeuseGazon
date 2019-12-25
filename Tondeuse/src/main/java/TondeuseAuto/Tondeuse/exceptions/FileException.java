package TondeuseAuto.Tondeuse.exceptions;

public class FileException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String messageCourt;	
	private String messageLong;
	
	public FileException(String messageCourt, String messageLong) {
		this.messageCourt = messageCourt;
		this.messageLong = messageLong;
	}

	public String getMessageCourt() {
		return messageCourt;
	}

	public String getMessageLong() {
		return messageLong;
	}

}
