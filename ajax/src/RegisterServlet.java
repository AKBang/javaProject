
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获得注册表单的数据
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获得输出流
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String myinfo = request.getParameter("myinfo");
		String sex = request.getParameter("sex");
		String[] skill  = request.getParameterValues("skill");
		String city = request.getParameter("city");
		String id = request.getParameter("id");
		
		//打印输出
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		System.out.println("myinfo=" + myinfo);
		System.out.println("sex=" + sex);
		System.out.println("skill=" + Arrays.toString(skill));
		System.out.println("city=" + city);
		System.out.println("id=" + id);	
		
//		响应内容
		out.print("注册成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}