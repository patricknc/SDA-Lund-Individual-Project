package toDoList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import toDoList.Project;

public class ProjectTest {
	private Project project;

	@Before
	public void setUp() throws Exception {
		project = new Project(101, "Software System Development");
	}

	@Test
	public void testProjectIdTrowError() {
		try {
			project.setProjectId(100);
			fail("100 projectId should throw error");
		}
		catch(IllegalArgumentException e) {
		}
		try {
			project.setProjectId(-100);
			fail("negative projectId should throw error");
		}
		catch(IllegalArgumentException e) {
	}
	}
	@Test
	public void testProjectId() {
		assertEquals(101, project.getProjectId());
	}
}
