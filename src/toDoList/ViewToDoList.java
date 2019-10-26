package toDoList;

import java.util.ArrayList;
import java.util.Scanner;

import model.Task;

public class ViewToDoList {

	public static void main(String[] args) {

		Project project1 = new Project();
		project1.setProjectTitle("Software System Development");

		Project project2 = new Project();
		project2.setProjectTitle("System Upgrade");

		TaskRegister aTaskRegister = new TaskRegister();

		 Task task1 = new Task(10, "Identification", "28-10-2019", "29-10-2019", "Done");
		 
		 project1.setTask(task1); 
		 //task1.setProject(project1);

		char quit = 'n';
		String input;
		int choice = 0;

		Scanner scanner = new Scanner(System.in);
		while (quit != 'y') {
			ArrayList<Task> readTaskList = new ArrayList<Task>();
			readTaskList = aTaskRegister.TaskList();
			System.out.println("Welcome to ToDoList" + "\nYou have X tasks todo and Y tasks are done!" + "\nPick an option:"
					+ "\n1. Show Task List(by date or project)" 
					+ "\n2. Add New Task"
					+ "\n3. Remove Task" 
					+ "\n4. Save and Quite");
			
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
			aTaskRegister.openFile();
			System.out.println();
			break;	
			case 2:
			aTaskRegister.add();
			break;
			case 3:
			aTaskRegister.remove(readTaskList);
			break;
			case 4:
			System.exit(1);
			break;
			default:
				System.out.println("That was't a choice.");
			}
			System.out.print("Would you like to quit y/n? ");
			input = scanner.next().toLowerCase();
			quit = input.charAt(0);
		}
	}
}

