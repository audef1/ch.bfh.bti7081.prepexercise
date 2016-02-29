package TaskList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
		// sort by description
		Collections.sort(this.tasks, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
				
				if (field == "description"){
					return  task1.description.compareTo(task2.description);
				}
				else if(field == "duedate"){
					return  task1.duedate.compareTo(task2.duedate);
				}
				else{
					return  task1.description.compareTo(task2.description);
				}
			}
		});
		
		// asc desc
		if (dir == "DESC"){
			Comparator<Task> comparator = Collections.reverseOrder();
			Collections.sort(this.tasks, comparator);
		}
		
	}

}