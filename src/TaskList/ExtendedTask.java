package TaskList;
import java.sql.Timestamp;

public class ExtendedTask extends Task{

	private enum Repeat{DAILY,WEEKLY,MONTHLY,YEARL}
	private Repeat repeat;
	
	public ExtendedTask(String description, Timestamp duedate) {
		super(description, duedate);
	}
	
	public ExtendedTask(String description, Timestamp duedate, Repeat repeat){
		super(description, duedate);
		this.repeat = repeat;
	}

}
