package toDoList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import model.Task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskRegister {

	String filePath = "/Users/patrickchimezie/TaskFile/task.txt";

	private ArrayList<Task> taskList = new ArrayList<Task>();
	private FileWriter filewriter;
	private Scanner scanner;
	private Scanner scan1 = new Scanner(System.in);
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
		String taskDueDate = "";
		taskDueDate = input.next();

		try {
			Date date = null; // Initialize date to null and Parse the date
			date = (Date) dateFormat.parse(taskDueDate);

			// converting date to String format
			dueDate = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Default set task as Not Done
		System.out.println("Enter Software System Development, System Upgrade as project type");

		String projectTitle = "";
		projectTitle = input.next();

		// passing values to constructor

		Task task = new Task(taskId, taskTitle, dueDate, "start", projectTitle);
		taskList = new ArrayList<Task>(); // Adding Task to the taskList
		taskList.add(task);
		this.writeTask(filePath, taskList); // Writing task to the file
	}

	public Task find(int taskId, ArrayList<Task> readTaskList) {
		Task tmpTask;
		boolean find = false;
		int index = -1;
		for (int i = 0; i < readTaskList.size() && !find; i++) {
			tmpTask = readTaskList.get(i);
			System.out.println(tmpTask.getTaskId());
			if (tmpTask.getTaskId() == (taskId)) {
				index = i;
				find = true;
			}
		}
		if (index != -1) {
			tmpTask = readTaskList.get(index);
		} else {
			tmpTask = null;
		}
		return tmpTask;
	}

	public ArrayList<Task> TaskList() {
		ArrayList<Task> readTaskList = new ArrayList<Task>();
		try {
			File file = new File(filePath);
			BufferedReader read = new BufferedReader(new FileReader(file));
			String st = "";
			if (file.exists()) {
				while ((st = read.readLine()) != null) {
					String fileContent[] = st.split(",");
					if (!st.contains("taskId")) {
						Task task = new Task(Integer.parseInt(fileContent[0]), fileContent[1], fileContent[2],
								fileContent[3], fileContent[4]);
						readTaskList.add(task);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readTaskList;
	}

	public void remove(ArrayList<Task> readTaskList) {
		
		System.out.println("Enter the task id to edit:");
		int taskId = 0;
		taskId = scan1.nextInt();
		Task tmpTask;
		int index;
		tmpTask = this.find(taskId, readTaskList);
		if (tmpTask != null) {
			index = readTaskList.indexOf(tmpTask);
			System.out.println("index " + index);
			readTaskList.remove(index);
		}		
		writeUpdate(filePath, readTaskList);

	}

	/*
	 * public Project findProject(int taskId) { Task tmpTask; Project tmpProject;
	 * tmpTask = find(taskId); tmpProject = tmpTask.getProject(); return tmpProject;
	 * }
	 */

	public void printAllTask() {
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println(" TaskId: " + taskList.get(i).getTaskId() + "Task title: "
					+ taskList.get(i).getTaskTitle() + " DueDate: " + taskList.get(i).getDueDate());
		}
	}

	public void update(ArrayList<Task> readTaskList) {
		System.out.println("Enter the task id to edit:");
		int taskId = scanner.nextInt();
		System.out.println("Enter the new title");
		String newTitle = scanner.next();
		Task task = this.find(taskId, readTaskList);
		task.setTaskTitle(newTitle);
		writeUpdate(filePath, readTaskList);
	}

	public void writeTask(String filePath, ArrayList<Task> taskList) {
		File file = new File(filePath);
		try {
			filewriter = new FileWriter(file, true);
			for (Task task : taskList) {
				filewriter.write(task.getTaskId() + ",");
				filewriter.write(task.getTaskTitle() + ",");
				filewriter.write(task.getDueDate() + ",");
				filewriter.write(task.getStatus() + ",");
				filewriter.write(task.getProject());

				filewriter.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (filewriter != null) {
					filewriter.close();
				}
			} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeFile() {
		scanner.close();
	}
	public void writeUpdate(String filePath, ArrayList<Task> taskList) {
		File file = new File(filePath);
		try {
			filewriter = new FileWriter(file, false);
			for (Task task : taskList) {
				filewriter.write(task.getTaskId() + ",");
				filewriter.write(task.getTaskTitle() + ",");
				filewriter.write(task.getDueDate() + ",");
				filewriter.write(task.getStatus() + ",");
				filewriter.write(task.getProject());

				filewriter.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (filewriter != null) {
					filewriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
