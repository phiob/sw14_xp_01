package at.tugraz.sw.hoi.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import at.tugraz.sw.hoi.TestConstants;
import at.tugraz.sw.hoi.model.Contact;
import at.tugraz.sw.hoi.model.EMFService;

import com.google.appengine.api.datastore.dev.LocalDatastoreService;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestChatServlet {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());

	private Contact to;

	@SuppressWarnings("static-access")
	@Before
	public void setUp() {
		helper.setUp();
		LocalDatastoreService dsService = (LocalDatastoreService) helper
				.getLocalService(LocalDatastoreService.PACKAGE);
		dsService.setNoStorage(true);

		EntityManager em = EMFService.get().createEntityManager();

		to = new Contact(TestConstants.EMAIL, TestConstants.REG_ID);
//		Contact from = new Contact(TestConstants.EMAIL, TestConstants.REG_ID);

		em.persist(to);
		em.close();
//
//		em = EMFService.get().createEntityManager();
//		em.persist(from);
//		em.close();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void testChatFail() throws IOException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		StringWriter sr = new StringWriter();
		PrintWriter writer = new PrintWriter(sr);
		Mockito.when(response.getWriter()).thenReturn(writer);

		Mockito.when(request.getParameter(Configuration.FROM)).thenReturn(
				to.getEmail());
		Mockito.when(request.getParameter(Configuration.TO)).thenReturn(
				to.getEmail());
		Mockito.when(request.getParameter(Configuration.MSG)).thenReturn(
				"This is a message.");

		new ChatServlet().doPost(request, response);
		writer.flush();
		writer.close();

		Assert.assertFalse(sr.toString().startsWith(Configuration.FAILURE));
	}

	@Test
	public void testChatSuccess() throws IOException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		StringWriter sr = new StringWriter();
		PrintWriter writer = new PrintWriter(sr);
		Mockito.when(response.getWriter()).thenReturn(writer);

		Mockito.when(request.getParameter(Configuration.FROM)).thenReturn(
				to.getEmail());
		Mockito.when(request.getParameter(Configuration.TO)).thenReturn(
				to.getEmail());
		Mockito.when(request.getParameter(Configuration.MSG)).thenReturn(
				"This is a message.");

		new ChatServlet().doPost(request, response);
		writer.flush();
		writer.close();
		System.out.println(sr.toString());
		Assert.assertTrue(sr.toString().startsWith(Configuration.SUCCESS));
	}
}
