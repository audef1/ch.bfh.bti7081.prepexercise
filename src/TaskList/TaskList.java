package TaskList;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TaskList {

	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	public TaskList(){
		Timestamp duedate = null;
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date date = null;
		try {
			date = dateFormat.parse("10.10.2016 16:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long time = date.getTime();
		duedate = new Timestamp(time);
		tasks.add(new Task("Einkaufen", duedate));
		
		dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		try {
			date = dateFormat.parse("12.10.2016 08:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		time = date.getTime();
		duedate = new Timestamp(time);
		tasks.add(new Task("Wäsche waschen", duedate));
		
		dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		try {
			date = dateFormat.parse("19.5.2016 12:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		time = date.getTime();
		duedate = new Timestamp(time);
		tasks.add(new Task("Hochzeit Patrick", duedate));
	}
	
	public void add(Task t){
		tasks.add(t);
		System.out.println("adding new Task: " + t.getDuedate() + " - " + t.getDescription());
		System.out.println("");
		System.out.println("");
	}
	
	public void remove(int i){
		tasks.remove(i);
		System.out.println("removing Task: " + i);
		System.out.println("");
		System.out.println("");
	}
	
	public Task get(int i){
		return tasks.get(i);
	}
	
	public void showTasks(){
			if (tasks.size() == 0){
				System.out.println("You dont have any tasks. YAY!");
				System.out.println("");
				System.out.println("");
			}
			else{
				for(int i = 0; i < tasks.size(); i++){
					System.out.println( i + ": " + tasks.get(i).toString());
				}
			}		
	}
	
	public void showClosedTasks(){
		ArrayList<Task> t = new ArrayList<Task>();
		for (Task task : tasks){
			if (task.getStatus() == Task.Status.DONE){
				t.add(task);
			}
		}
			
		for(int i = 0; i < t.size(); i++){
			System.out.println( i + ": " + tasks.get(i).toString());
		}
	}
	
	public void showOpenTasks(){
		ArrayList<Task> t = new ArrayList<Task>();
		for (Task task : tasks){
			if (task.getStatus() == Task.Status.OPEN){
				t.add(task);
			}
		}
			
		for(int i = 0; i < t.size(); i++){
			System.out.println( i + ": " + tasks.get(i).toString());
		}
	}
	
	public void sortTasks(String field, String dir){
		// sort by description
		Collections.sort(this.tasks, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
				
				if (field == "description"){
					return  task1.getDescription().compareTo(task2.getDescription());
				}
				else if(field == "duedate"){
					return  task1.getDuedate().compareTo(task2.getDuedate());
				}
				else{
					return  task1.getDescription().compareTo(task2.getDescription());
				}
			}
		});
		
		// asc desc
		if (dir == "DESC"){
			Comparator<Task> comparator = Collections.reverseOrder();
			Collections.sort(this.tasks, comparator);
		}
		
	}
	
	public void searchTask(String s){
		String word = s.toLowerCase();
		System.out.println("Search Results for '" + s + "':");
		System.out.println("----------------------------");
		for (Task t : tasks){
			String descr = t.getDescription().toLowerCase();
			if (descr.contains(word)){
				System.out.println(t.toString());
			}
		}
		System.out.println("----------------------------");
	}

}