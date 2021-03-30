

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;
	private String name, id, pw, phone1, phone2, phone3, gender;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("actionDo");
		request.setCharacterEncoding("EUC-KR");
		
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		String query = "INSERT INTO member VALUES('" + name + "', '" + id + "', '" + pw + "', '" + phone1 + "', '" + phone2 + "', '" + phone3 + "', '" + gender +"')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "woojoo", "woojoo");
			statement = connection.createStatement();
			int i = statement.executeUpdate(query);
			if(i == 1) {
				System.out.println("Insert Success.");
				response.sendRedirect("joinResult.jsp");
			} else {
				System.out.println("Insert Fail.");
				response.sendRedirect("join.jsp");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {}
		}
	}

}
