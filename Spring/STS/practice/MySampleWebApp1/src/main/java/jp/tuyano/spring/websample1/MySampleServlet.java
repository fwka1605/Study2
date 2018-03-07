package jp.tuyano.spring.websample1;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("/sample")
public class MySampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ApplicationContext app = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		app = new ClassPathXmlApplicationContext("/spring/application-config.xml");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MyBean mybean1 = (MyBean) app.getBean("mybean1");
		request.setAttribute("mybean", mybean1);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = request.getParameter("message");
		MyBean mybean1 = (MyBean) app.getBean("mybean1");
		mybean1.addMessage(message);
		response.sendRedirect("sample");
	}

}
