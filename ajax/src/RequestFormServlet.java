import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestFormServlet")
public class RequestFormServlet extends HttpServlet {

	//对应客户端发送的get请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获得表单中的用户名和密码（请求参数）
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
//		打印输出到控制台
		System.out.println("用户名：" + username);
		System.out.println("密码：" + userpwd);
		
		System.out.println("doGet...");
		
		//响应数据输出流
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>get登陆成功</h1>");		
	}

//	对应客户端发送的post请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获得表单中的用户名和密码（请求参数）
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
//		打印输出到控制台
		System.out.println("用户名：" + username);
		System.out.println("密码：" + userpwd);
		
		System.out.println("doPost...");
		
		//响应数据输出流
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>post登陆成功</h1>");			
	}

}