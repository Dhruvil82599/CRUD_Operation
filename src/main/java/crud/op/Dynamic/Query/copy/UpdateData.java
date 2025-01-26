package crud.op.Dynamic.Query.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {
	public static void main(String[] args) {

		System.out.println("Update Student Data");
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Student New Name:-");
		String name = sc.next();

		System.out.print("Enter Student New Branch:-");
		String branch = sc.next();

		System.out.print("Enter Student New Division:-");
		String division = sc.next();

		System.out.print("Enter Id Which Data YOu Want to update:- ");
		int id = sc.nextInt();

		try {
			// Step:- 1 :- Load and Register Driver
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/aj_jdbc?user=postgres&password=root";

			// Step:-2 :- Establish Connection
			Connection connection = DriverManager.getConnection(url);

			// Step:-3 :- Prepare Statement
			String update_data = "UPDATE student_table SET name = ?, branch = ?, division = ? WHERE id = ?";

			PreparedStatement statement = connection
					.prepareStatement("UPDATE student_table SET name = ?, branch = ?, division = ? WHERE id = ?");
			statement.setString(1, name);
			statement.setString(2, branch);
			statement.setString(3, division);
			statement.setInt(4, id); // If `id` is a string, use pstmt.setString(4, id)

			statement.executeUpdate();

			int update = statement.executeUpdate();

			if (update > 0) {
				System.out.println("Data updated Successfully...");
			} else {
				System.out.println("Data Not Updated");
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
