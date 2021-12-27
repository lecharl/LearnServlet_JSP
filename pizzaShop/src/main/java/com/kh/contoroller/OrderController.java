package com.kh.contoroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.kh.common.JdbcTemplate.*;
import com.kh.vo.PizzaModel;

@WebServlet("/order")
public class OrderController extends HttpServlet {
//	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		
//		System.out.println(pizza);
//		System.out.println(String.join(", ", topping));
//		System.out.println(String.join(", ", side));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String orderResult = "주문 실패";
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String id = "kh";
			String pwd = "kh";
			
			//3.
			conn = DriverManager.getConnection(url, id, pwd);
            //오토커밋 끄기
            conn.setAutoCommit(false);
			
			String sql = "INSERT INTO PIZZA_TABLE (PIZZA, TOPPING, SIDE) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pizza);
			if(topping != null) {
				pstmt.setString(2, String.join(",", topping));
			} else {
				pstmt.setString(2, "NONE");
			}
			if(side != null) {
				pstmt.setString(3, String.join(",", side));
			}else {
				pstmt.setString(3, "NONE");
			}
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("주문 정상 접수");
				orderResult = "주문 성공";
			} 
			
			//4. jdbc 뒷정리			
			commit(conn);
			
			//2.
		} catch (ClassNotFoundException e) {
			System.out.println("classNotFound error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql error");
			e.printStackTrace();
			//4.
			rollback(conn);
		} catch (Exception e){
			System.out.println("error!!");
			e.printStackTrace();
//			rollback(conn);
		} finally {
			close(conn);
			close(pstmt);
		}
		
		//화면에 주문성공 여부 보여주자
		//request에 orderResult가 없기 때문에 setAttribute()해야함
//		request.setAttribute("model", orderResult);
		
		PizzaModel pizzaModel = new PizzaModel(pizza, topping, side, orderResult);
		request.setAttribute("pizzaModel", pizzaModel);
		
		request.setAttribute("key01", "value01");
		
		request.getSession().setAttribute("sessionKey", "sessionVal");
		
		request.setAttribute("testKey", "testValueRequest");
		request.getSession().setAttribute("testKey", "testValueSession");
		request.getServletContext().setAttribute("testKey", "testValueApplication");
		
		request.getRequestDispatcher("/WEB-INF/views/orderResult.jsp").forward(request, response);
	}

}
