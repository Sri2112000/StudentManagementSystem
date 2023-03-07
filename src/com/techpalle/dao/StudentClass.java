package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.StudentDetails;

public class StudentClass 
{
    private static Connection con=null;
    private static  Statement s=null;
    private static  PreparedStatement ps=null;
    private static  ResultSet rs=null;
    
    private static final String dburl="jdbc:mysql://localhost:3306/project";
    private static final String dbusername="root"; 
    private static final String dbpassword="admin";
    
    private static final String insertQury="insert into student(name,email,password,state) values (?,?,?,?)";
    private static final String updateQury="update student set name=?,password=?,state=? where email=?";
    private static final String deleteQury="delete from student where email=?";
    private static final String selectQury="select * from student";
    
    
    public static void inserting( StudentDetails sd)
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps=con.prepareStatement(insertQury);
			
			ps.setString(1,sd.getName());
			ps.setString(2,sd.getEmail());
			ps.setString(3,sd.getPassword());
			ps.setString(4,sd.getState());
			
			ps.executeUpdate();
    	}
    	
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if(ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			} 
    		catch (SQLException e) 
    		{
				e.printStackTrace();
			}
    	}
    }
    public static void updating( String name,String password,String state,String email)
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps=con.prepareStatement(updateQury);
			
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,state);
			ps.setString(4,email);
			
			ps.executeUpdate();
    	}
    	
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if(ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			} 
    		catch (SQLException e) 
    		{
				e.printStackTrace();
			}
    	}
    }
    public static void deleting( String email)
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps=con.prepareStatement(deleteQury);
			
			
			ps.setString(1,email);
			
			ps.executeUpdate();
    	}
    	
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if(ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			} 
    		catch (SQLException e) 
    		{
				e.printStackTrace();
			}
    	}
    }
    public static ArrayList<StudentDetails> showAll()
    {
    	ArrayList<StudentDetails> al=new ArrayList<StudentDetails>();
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			
			s=con.createStatement();
			
			rs=s.executeQuery(selectQury);
			while(rs.next())
			{
				int sid=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String password=rs.getString(4);
				String state=rs.getString(5);
				
				StudentDetails sd=new StudentDetails(sid,name,email,password,state);
				al.add(sd);
			}
    	}
    	
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if(rs!=null)
    				rs.close();
    			if(s!=null)
    				s.close();
    			if(con!=null)
    				con.close();
			} 
    		catch (SQLException e) 
    		{
				e.printStackTrace();
			}
    	}
		return al;
    }
}
