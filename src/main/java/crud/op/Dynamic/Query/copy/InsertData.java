package crud.op.Dynamic.Query.copy;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			String insert = "INSERT INTO student_table VALUES (?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, branch);
			preparedStatement.setString(4, String.valueOf(division));

			// Step:-4 :- Execute Query
			int update = preparedStatement.executeUpdate();

			if (update > 0) {
				System.out.println("Data Inserted Successfully...");
			} else {
				System.out.println("Data Not Inserted");
			}

			preparedStatement.close();
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
