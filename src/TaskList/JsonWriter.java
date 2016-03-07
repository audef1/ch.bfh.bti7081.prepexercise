package TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriter {

	private ArrayList<Task> tasks;
	
	public JsonWriter(ArrayList<Task> tasks){
		this.tasks = tasks;
	}
	
	@SuppressWarnings("unchecked")
	public void write() throws IOException {
			JSONObject obj = new JSONObject();
			
			for (Task t : tasks) {
				JSONArray task = new JSONArray();
				task.add("Duedate: " + t.getDuedate());
				task.add("Status: " + t.getStatus().toString());
				task.add("Description: " + t.getDescription().toString());
				if (t instanceof ExtendedTask){
					task.add("Period: " + ((ExtendedTask) t).getPeriod().toString());
				}
				obj.put("task" + tasks.indexOf(t), task);
			}
			String path = System.getProperty("user.home") + "/Desktop/tasks.txt";
			File file = new File(path);
			try (FileWriter fw = new FileWriter(file)) {
				fw.write(obj.toJSONString());
				System.out.println("Successfully Copied JSON Object to File '" + path + "'!");
				System.out.println("\nJSON Object: " + obj);
			}
	}
}