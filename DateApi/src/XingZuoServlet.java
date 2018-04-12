
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * 查询星座数据
 */
@WebServlet("/XingZuoServlet")
public class XingZuoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		String consName = request.getParameter("consName");//星座名称
		String type = request.getParameter("type");//时间范围
		
		System.out.println(consName);
		System.out.println(type);
			
		consName = URLEncoder.encode(consName, "utf-8");
		
		System.out.println("consName=" + consName);
		System.out.println("type=" + type);		

		HttpClient httpClient = new HttpClient();

		String url = "http://api.avatardata.cn/Constellation/Query?key=df810f5f01d048cd9f893b6b02fc4411&consName="
				+ consName + "&type=" + type;
		
		GetMethod getMethod = new GetMethod(url);
		
		int status = httpClient.executeMethod(getMethod);

		if (status != 200) {
			System.out.println("请求错误," + status);
			return;
		}

		String result = getMethod.getResponseBodyAsString();

		System.out.println(result);
		out.print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}