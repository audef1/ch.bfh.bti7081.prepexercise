package TaskList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu {

	private TaskList t;
	
	public Menu(TaskList t){
		this.t = t;
		showMainMenu();
	}
	
	public void showMainMenu(){
		// Main Menu
	    System.out.println("TASKS - MAIN MENU");
	    System.out.println("============================");
	    System.out.println("Options:");
	    System.out.println("	1. Show Tasks");
	    System.out.println("	2. New Task");
	    System.out.println("	3. Close Task");
	    System.out.println("	4. Delete Task");
	    System.out.println("	5. Sort Tasks");
	    System.out.println("	6. Search Task");
	    System.out.println("	99. Exit");
	    System.out.println("============================");

		KeyInput keys = new KeyInput();
		
	    int selection;
	    selection = keys.inInt("Select option: ");

	    switch (selection) {
	    case 1:
	      System.out.println("Show Tasks...");
	      showTasks();
	      showMainMenu();
	      break;
	    case 2:
	    	System.out.println("Creating new Task...");
		    newTask();
		    t.showTasks();
		    showMainMenu();
	    	break;
	    case 3:
	    	System.out.println("Closing Task...");
		    closeTask();
		    t.showTasks();
		    showMainMenu();
	    	break;
	    case 4:
	    	System.out.println("Deleting Task...");
	    	deleteTask();
	    	t.showTasks();
		    showMainMenu();
	    	break;
	    case 5:
	    	System.out.println("Sort Tasks...");
	    	sortTasks();
	    	t.showTasks();
		    showMainMenu();
	    	break;
	    case 6:
	    	System.out.println("Search Tasks...");
	    	searchTask();
		    showMainMenu();
	    	break;
	    case 99:
	      System.out.println("Exiting...");
	      System.exit(0);
	    default:
	      System.out.println("Invalid selection");
	      break;
	    }
	    
	}
	
	public void newTask(){
		String description = "";
		Timestamp duedate = null;
		
		// New Task 
	    System.out.println("Please enter a description: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   
		 try {
	     	description = in.readLine();
		 } catch (IOException e) {
			 System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		 }
		 
		 System.out.println("Please enter a due date (10.02.2016 10:00): ");
		 in = new BufferedReader(new InputStreamReader(System.in));
		   
		 try {
			 DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
			 Date date = dateFormat.parse(in.readLine());
			 long time = date.getTime();
			 duedate = new Timestamp(time);
		 } catch (IOException e) {
			 System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		 } catch (ParseException e) {
			 System.out.println("Date Error, switching to Main Menu.");
	         showMainMenu();
		}
		
		t.add(new Task(description, duedate));
	}
	
	public void deleteTask(){
		// Delete Task
		t.showTasks();
		int del = 0;
		
	    System.out.println("Which Task should be removed: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   
		 try {
	     	del = Integer.parseInt(in.readLine());
		 } catch (IOException e) {
			 System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		 }
		 
		 t.remove(del);
	}
	
	public void closeTask(){
		// Close Task
		t.showTasks();
		int close = 0;
		
	    System.out.println("Which Task should be closed: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   
		 try {
	     	close = Integer.parseInt(in.readLine());
		 } catch (IOException e) {
			 System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		 }
		 
		 t.get(close).done();
	}
	
	public void showTasks(){
		// show Task
		int show = 0;

		System.out.println("Show tasks: ");
		System.out.println("  1. All");
		System.out.println("  2. OPEN");
		System.out.println("  3. DONE");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			   
		try {
			show = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			System.out.println("IO Error, switching to Main Menu.");
			showMainMenu();
		}
		
		switch (show) {
	    case 1:
	    	System.out.println("Show all Tasks...");
	    	t.showTasks();
	    	showMainMenu();
	    	break;
	    case 2:
	    	System.out.println("Show all OPEN Tasks...");
		    t.showOpenTasks();
			showMainMenu();
			break;
	    case 3:
	    	System.out.println("Show all CLOSED Tasks...");
	    	t.showClosedTasks();
			showMainMenu();
			break;
		}
	}
	
	public void searchTask(){
		// Search Task
		String s = "";
	    System.out.println("Search: ");
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    try {
			s = in.readLine();
		} catch (IOException e) {
			System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		}
	    
	    t.searchTask(s);
	}
	
	public void sortTasks(){
		// Sort Task
		int sort = 0;
		String descr = "";
		String dir = "";
		
	    System.out.println("What should be sorted: ");
	    System.out.println("  1. Date");
	    System.out.println("  2. Description");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   
		 try {
	     	sort = Integer.parseInt(in.readLine());
		 } catch (IOException e) {
			 System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		 }
		 
		 if (sort == 1){
			 descr = "description";
		 }
		 else{
			 descr = "duedate";
		 }
		 
		 System.out.println("Sort Direction: ");
		 System.out.println("  1. ASC");
		 System.out.println("  2. DESC");
		 
		 in = new BufferedReader(new InputStreamReader(System.in));
		   
		 try {
	     	sort = Integer.parseInt(in.readLine());
		 } catch (IOException e) {
			 System.out.println("IO Error, switching to Main Menu.");
	         showMainMenu();
		 }
		 
		 if (sort == 1){
			 dir = "ASC";
		 }
		 else{
			 dir = "DESC";
		 }
		 
		 t.sortTasks(descr, dir);

	}
	
	
	private class KeyInput {
		public void printPrompt(String prompt) {
			System.out.print(prompt + " ");
		    System.out.flush();
		}

		public void inputFlush() {
			int dummy;
		    int bAvail;

		    try {
		    	while ((System.in.available()) != 0)
		    		dummy = System.in.read();
		    } catch (java.io.IOException e) {
		    	System.out.println("Input error");
		    }
		}

		public String inString(String prompt) {
		    inputFlush();
		    printPrompt(prompt);
		    return inString();
		}

		public String inString() {
			int aChar;
		    String s = "";
		    boolean finished = false;

		    while (!finished) {
		      try {
		        aChar = System.in.read();
		        if (aChar < 0 || (char) aChar == '\n')
		          finished = true;
		        else if ((char) aChar != '\r')
		          s = s + (char) aChar;
		      }

		      catch (java.io.IOException e) {
		        System.out.println("Input error");
		        finished = true;
		      }
		    }
		    return s;
		}

		public int inInt(String prompt) {
		    while (true) {
		    	inputFlush();
		      	printPrompt(prompt);
		      	try {
		    	  return Integer.valueOf(inString().trim()).intValue();
		      	}

		      	catch (NumberFormatException e) {
		    	  	System.out.println("Invalid input. Not an integer");
		      	}
		    }
		}

		public char inChar(String prompt) {
		    int aChar = 0;

		    inputFlush();
		    printPrompt(prompt);

		    try {
		      aChar = System.in.read();
		    }

		    catch (java.io.IOException e) {
		      System.out.println("Input error");
		    }
		    inputFlush();
		    return (char) aChar;
		}

		public double inDouble(String prompt) {
			while (true) {
				inputFlush();
				printPrompt(prompt);
				try {
			        return Double.valueOf(inString().trim()).doubleValue();
			 	}
	
			 	catch (NumberFormatException e) {
			        System.out.println("Invalid input. Not a floating point number");
			  	}
			}
		}
	}
}