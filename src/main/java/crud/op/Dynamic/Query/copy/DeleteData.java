package crud.op.Dynamic.Query.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	public static void main(String[] args) {
		System.out.println("Delete Data Using Student Id");

		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/aj_jdbc?user=postgres&password=root";

			Connection connection = DriverManager.getConnection(url);

			// Step 3: Create Statement
			String sql = "delete from student_table where id =?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			int effect = statement.executeUpdate();

			if (effect > 0) {
				System.out.println("Data Deleted Successfully...");
			} else {
				System.out.println("Data not Deleted...");
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
