package jp.co.aforce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Bean.CusBean;
import jp.co.aforce.DAO.CusDAO;

@WebServlet(urlPatterns = { "/jp.co.aforce/Login" })
public class Login extends HttpServlet {

	public void doPost(
		 HttpServletRequest request,HttpServletResponse response
		 ) throws ServletException, IOException {
		    PrintWriter out = response.getWriter();


		 String id=request.getParameter("id");
		 String password=request.getParameter("password");
//		 String name=request.getParameter("name");

		 CusDAO dao = new CusDAO();

		 try {

			 CusBean cb = dao.search(id, password);

			 String logId = cb.getId();

			 if(logId != null) {
			     request.setAttribute("customer", cb);
			     request.getRequestDispatcher("../jsp/success.jsp") .forward(request, response);
			 }else {
				 out.println("<p>IDもしくはパスワードが違います。</p>");
				 request.setAttribute("ID", cb.getId());
			 }

		 }catch(Exception e) {
			 e.printStackTrace();
		 }

	}

}
