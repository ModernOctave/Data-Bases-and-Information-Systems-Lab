package jdbc_demo;

import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		try {
			//Get connection
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","om123");
			Statement myS=myConn.createStatement();
			//Queries
			listStudents(myS);
			listDepartments(myS);

			PreparedStatement myP=myConn.prepareStatement("select room_number from classroom left join section using (building, room_number) where building = ? and capacity > ? and room_number not in (select room_number from classroom left join section using (building, room_number) where semester = ? and year = ?);");
			listDepartments(myP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listStudents(Statement stmt)
	{
		try {
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM student");			//Display
			System.out.println("ID name");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("ID")+"  "+resultSet.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listDepartments(Statement stmt)
	{
		try {
			ResultSet resultSet = stmt.executeQuery("SELECT dept_name, num_students, COUNT(dept_name) AS num_instructors FROM (SELECT dept_name, COUNT(dept_name) AS num_students FROM department NATURAL JOIN student GROUP BY dept_name) AS tab NATURAL JOIN instructor GROUP BY dept_name ORDER BY dept_name asc;");
			System.out.println();
			System.out.println("dept_name num_students num_instructors");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("dept_name")+" "+resultSet.getInt("num_students")+" "+resultSet.getInt("num_instructors"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void listDepartments(PreparedStatement stmt)
	{
		try {
			stmt.setString(1, "Watson");
			stmt.setInt(2, 30);
			stmt.setString(3, "Fall");
			stmt.setInt(4, 2022);

			ResultSet resultSet = stmt.executeQuery();
			System.out.println();
			System.out.println("room_number");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("room_number"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
