

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	private String name, id, pw, phone1, phone2, phone3, gender;
	HttpSession httpSession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		httpSession = request.getSession();
		
		name = request.getParameter("name");
		id = (String)httpSession.getAttribute("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		if(pwConfirm()) {
			System.out.println("OK");
			// UPDATE member SET NAME='name', PHONE1='phone1', PHONE2='phone2', PHONE3='phone3', GENDER='gender' WHERE ID='id'
			String query = "UPDATE member SET NAME='" + name + "', PHONE1='" + phone1 + "', PHONE2='" + phone2 + "', PHONE3='" + phone3 + "', GENDER='" + gender + "' WHERE ID='" + id + "'";
			// "UPDATE member SET NAME='" + name + "', PHONE1='" + phone1 + "', PHONE2='" + phone2 + "', PHONE3='" + phone3 + "', GENDER='" + gender + "' WHERE ID='" + id + "'"
			System.out.println(query);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "woojoo", "woojoo");
				stmt = connection.createStatement();
				int i = stmt.executeUpdate(query);
				
				if(i==1) {
					System.out.println("update sucess");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				} else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null) stmt.close();
					if(connection != null) connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Not Good..");
			response.sendRedirect("modify.jsp");
		}
	}
	private boolean pwConfirm() {
		// TODO Auto-generated method stub
		boolean rs = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			rs = true;
		} else {
			rs = false;
		}
		return rs;
	}
}
