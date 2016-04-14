package org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.Dao;
import org.model.Ontology;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet(description = " ", urlPatterns = { "/FindServlet" })
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Ontology> list = new Dao().findOntology();
		JSONArray jsonArray = JSONArray.fromObject(list);
		
		
		response.setContentType("application/json;charset=UTF-8"); // 设置响应内容类型
		response.setCharacterEncoding("UTF-8");
		
		// System.out.println(jsonArray);
		response.getWriter().append(jsonArray.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
