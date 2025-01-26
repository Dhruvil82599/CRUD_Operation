package crud.op.Static.Query;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
	public static void main(String[] args) {

		System.out.println("Insert Student Data");
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Student Id:-");
		int id = sc.nextInt();

		System.out.print("Enter Student Name:-");
		String name = sc.next();

		System.out.print("Enter Student Branch:-");
		String branch = sc.next();

		System.out.print("Enter Student Division:-");
		char division = sc.next().charAt(0);

		try {
			// Step:- 1 :- Load and Register Driver
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/aj_jdbc?user=postgres&password=root";

			// Step:-2 :- Establish Connection
			Connection connection = DriverManager.getConnection(url);

			// Step:-3 :- Prepare Statement
			//String insert = "insert into student_table values" + id + "," + name + "," + branch + "," + division + "";
			String insert = "INSERT INTO student_table VALUES (" + id + ", '" + name + "', '" + branch + "', '" + division + "')";
			Statement statement = connection.createStatement();

			int update = statement.executeUpdate(insert);

			if (update > 0) {
				System.out.println("Data Inserted Successfully...");
			} else {
				System.out.println("Data Not Inserted");
			}

			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
