package TaskList;
import java.sql.Timestamp;

public class Task implements Comparable<Task>{

	private enum Status{ OPEN,DONE }
	private Status status = Status.OPEN;
	public String description;
	public Timestamp duedate;
	
	public Task(String description, Timestamp duedate){
		this.description = description;
		this.duedate = duedate;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public void done(){
		this.status = Status.DONE;
	}
	
	public String toString(){
		return description + " " + duedate;
	}
	
	public void setTimestamp(Timestamp t){
		this.duedate = t;
	}

	@Override
	public int compareTo(Task task) {
		return	this.description.compareTo(task.description);
	}
	
}