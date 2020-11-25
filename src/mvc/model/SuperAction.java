package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperAction {
	// 상수와 추상메소드만 정의 가능
	public String requestAction(HttpServletRequest request, HttpServletResponse response);
		
	
}
