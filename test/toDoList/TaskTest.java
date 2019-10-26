package toDoList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.Task;

public class TaskTest {
	private Task task;

	@Before
	public void setUp() {
		task = new Task(10, "Identification", "28-10-2019", "29-10-2019", "Done");
	}

	@Test
	public void testTaskIdTrowError() {
		try {
			task.setTaskId(0);
			fail("0 taskId should throw error");
		}
		catch(IllegalArgumentException e) {
		}
		try {
			task.setTaskId(-1);
			fail("negative taskId should throw error");
		}
		catch(IllegalArgumentException e) {
		}
	}

	@Test
	public void testTaskId() {
		assertEquals(10, task.getTaskId());
		}
}