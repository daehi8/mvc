package test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/mvc/HelloServlet
// 서블릿이 실행되는 주소 마음대로 작성 가능
@WebServlet("/HelloServlet")

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }
        
    // 결국 get method 에서 모두 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// servlet에서 html 만드는 방법
		String id = request.getParameter("id");
		response.getWriter().append("<h1>hello"+id+"servlet</h1> ");
	}
	
	// post method overriding
	// get method start
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
