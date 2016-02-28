package TaskList;
import java.util.ArrayList;

public class TaskList {

	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void add(Task t){
		tasks.add(t);
		System.out.println("adding new Task: " + t.duedate + " - " + t.description);
		System.out.println("");
		System.out.println("");
	}
	
	public void remove(int i){
		tasks.remove(i);
		System.out.println("removing Task: " + i);
		System.out.println("");
		System.out.println("");
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
	
	public void sortTasks(String field, String dir){
		
	}

}