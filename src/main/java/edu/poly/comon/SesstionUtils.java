package edu.poly.comon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SesstionUtils {
	public static void add(HttpServletRequest request, String name,Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
		
	}
	public static Object get(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		return session.getAttribute(name);
	}
	public static void invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.invalidate();  
	}
	public static boolean isLogin(HttpServletRequest request) {
		return get(request,"id") !=null;
	}
	public static String getLoginedUsername(HttpServletRequest request) {
		Object id = get(request, "id");
		return id == null? null: id.toString();
	}
}
