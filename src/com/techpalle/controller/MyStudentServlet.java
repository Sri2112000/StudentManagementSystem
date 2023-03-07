package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.StudentClass;
import com.techpalle.model.StudentDetails;

@WebServlet("/")
public class MyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		switch(path)
		{
		case"/My":
			String s=request.getParameter("crud");
			if("insert".equalsIgnoreCase(s))
			{
				inserting(request,response);
			}
			else if("update".equalsIgnoreCase(s))
			{
				updating(request,response);
			}
			else if("delete".equalsIgnoreCase(s))
			{
				deleting(request,response);
			}
			else
			{
				showAll(request,response);
			}
			break;
			default:
				getStarUpPage(request,response);
				break;
		}
	}

	private void showAll(HttpServletRequest request, HttpServletResponse response) 
	{
		ArrayList<StudentDetails> arr=StudentClass.showAll();
		request.setAttribute("showAll",arr);
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	private void deleting(HttpServletRequest request, HttpServletResponse response) 
	{
		String e=request.getParameter("tbEmail");
		
		StudentClass.deleting(e);
	}

	private void updating(HttpServletRequest request, HttpServletResponse response) 
	{
		String n=request.getParameter("tbName");
		String p=request.getParameter("tbPass");
		String s=request.getParameter("ddlState");
		String e=request.getParameter("tbEmail");
		
		StudentClass.updating(n, p, s, e);
	}

	private void getStarUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
				try 
				{
					RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
					rd.forward(request, response);
				} 
				catch (ServletException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
		
	}

	private void inserting(HttpServletRequest request, HttpServletResponse response) 
	{
			String n=request.getParameter("tbName");
			String e=request.getParameter("tbEmail");
			String p=request.getParameter("tbPass");
			String s=request.getParameter("ddlState");
		
			StudentDetails sd=new StudentDetails(n,e,p,s);
			
			StudentClass.inserting(sd);
			
			try 
			{
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
				rd.forward(request, response);
			} 
			catch (ServletException e1) 
			{
				e1.printStackTrace();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
