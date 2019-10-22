package toDoList;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskRegister {

	private static final String HEADER = null;
	private static final String taskDueDate = null;
	private static final char[] SaveAndQuite = null;

	String filePath = "/Users/patrickchimezie/TaskFile/task.txt";

	private ArrayList<Task> taskList = new ArrayList<Task>();
	private ArrayList<Project> project = new ArrayList<Project>();
	private FileWriter filewriter;
	private Scanner scanner;
	private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private String dueDate = "";

	public ArrayList<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}

	public void add() {
		Scanner input = new Scanner(System.in).useDelimiter("\n");
		System.out.println("Enter the Id");
		int taskId = input.nextInt();
		System.out.println("Enter task Title");

		String taskTitle = "";
		taskTitle = input.next();

		// Choose and enter the date format
		System.out.println("Enter the Date in this format DD-MM-YYYY");

		// Initialize date to null
		String taskDueDate = "";
		taskDueDate = input.next();

		try {

			// Parse the date
			Date date = null;

			date = (Date) dateFormat.parse(taskDueDate);

			// converting date to String format
			dueDate = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Default set task as Not Done
		//task.setStatus();
		// String taskStatus = task.getStatus();
		System.out.println(
				"Enter the Software System Development Project, Software Upgrade Project are the project lists");

		String projectTitle = "";
		projectTitle = input.next();

		// passing values to constructor
		Task task = new Task(taskId, taskTitle, dueDate, "start", projectTitle);

		// Adding Task to the taskList

		ArrayList<Task> taskList = new ArrayList<Task>();

		taskList.add(task);
		this.write(filePath, taskList);

		// Writing task to the file

	}

	// Enter task title

	public Task find(int taskId) {
		Task tmpTask;
		int i = 0;
		boolean find = false;
		int index = -1;

		while (i < this.getTaskList().size() && find == false) {
			tmpTask = this.getTaskList().get(i);
			if (tmpTask.getTaskId() == (taskId)) {
				index = i;
				find = true;
			}
			i++;
		}
		if (index != -1) {
			tmpTask = this.getTaskList().get(index);
		} else {
			tmpTask = null;
		}
		return tmpTask;
	}

	public void remove(int taskId) {
		Task tmpTask;
		int index;
		tmpTask = this.find(taskId);
		if (tmpTask != null) {
			index = taskList.indexOf(tmpTask);
			taskList.remove(index);
		}
	}

	public Project findProject(int taskId) {
		Task tmpTask;
		Project tmpProject;

		tmpTask = find(taskId);
		tmpProject = tmpTask.getProject();
		return tmpProject;
	}

	public void printAllTask() {
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println(" TaskId: " + taskList.get(i).getTaskId() + "Task title: "
					+ taskList.get(i).getTaskTitle() + " DueDate: " + taskList.get(i).getDueDate());
		}
	}

	public void update(int taskId, String taskTitle) {
		Task task = this.find(taskId);
		task.setTaskTitle(taskTitle);
	}

	public void write(String filePath, ArrayList<Task> taskList) {

		File file = new File(filePath);
		try {
			filewriter = new FileWriter(file,true);

			for (Task task : taskList) {

				filewriter.write(task.getTaskId() + ",");
				// filewriter.append(",");

				filewriter.write(task.getTaskTitle() + ",");
				// filewriter.append(",");

				filewriter.write(task.getStartDate() + ",");
				// filewriter.append(",");

				filewriter.write(task.getDueDate() + ",");
				// filewriter.append(",");

				filewriter.write(task.getStatus() + ",");
				// filewriter.append(",");
				filewriter.append("\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (filewriter != null) {
					filewriter.close();
				}

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void openFile() {

		try {

			File file = new File(filePath);
			BufferedReader read = new BufferedReader(new FileReader(filePath));
			String st = "";
			if (file.exists()) {
				while ((st = read.readLine()) != null) {

					System.out.println(st);

				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeFile() {
		scanner.close();
	}

	public void SaveAndQuite() {
		System.out.println(SaveAndQuite);
		
	}

}
