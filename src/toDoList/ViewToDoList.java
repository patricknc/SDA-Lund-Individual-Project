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

		 Task task1 = new Task(10, "Planning", "4-11-2019", "16-11-2019", "Done");
		 
		 Task task2 = new Task(20, "Requirements", "18-11-2019", "23-11-2019","Done"); 
		 Task task3 = new Task(30, "Design and Prototyping", "25-11-2019","30-11-2019", "Done"); 
		 Task task4 = new Task(40, "Software development", "2-12-2019", "14-12-2019", "Not Done"); 
		 Task task5 = new Task(50, "Testing","16-12-2019", "21-12-2019", "Not Done"); 
		 Task task6 = new Task(60, "Deployment", "23-12-2019", "25-12-2019", "Not Done"); 
		 Task task7 = new Task(70, "Maintenance", "26-12-2019", "31-12-2019", "Not Done");
		 

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

