package shared.communicator;
/**
 * Dumb data holder
 * @author Jonathan
 *
 */
public class SaveGameResults {
	String status;
	boolean success;
	
	public SaveGameResults(String status)
	{
		this.status = status;
	}

	public SaveGameResults() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSuccess(boolean b) {
		this.success = b;
	}
	
	

}
