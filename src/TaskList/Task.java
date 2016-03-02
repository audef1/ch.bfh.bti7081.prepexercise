package TaskList;
import java.sql.Timestamp;

public class Task implements Comparable<Task>{

	public enum Status{ OPEN,DONE }
	private Status status = Status.OPEN;
	private String description;
	private Timestamp duedate;
	
	public Task(String description, Timestamp duedate){
		this.setDescription(description);
		this.setDuedate(duedate);
	}
	
	public Status getStatus(){
		return status;
	}
	
	public void done(){
		if (this.status == Status.OPEN)
			this.status = Status.DONE;
		else
			this.status = Status.OPEN;
	}
	
	public String toString(){
		return getDuedate() + " | " + status + " | Note: " + getDescription();
	}
	
	public void setTimestamp(Timestamp t){
		this.setDuedate(t);
	}

	@Override
	public int compareTo(Task task) {
		return	this.getDescription().compareTo(task.getDescription());
	}

	public Timestamp getDuedate() {
		return duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}