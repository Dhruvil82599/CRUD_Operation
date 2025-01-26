package crud.op.Static.Query;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteData {
	public static void main(String[] args) {
		System.out.println("Delete Data Using Student Id");

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/aj_jdbc?user=postgres&password=root";

			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();

			Scanner scanner = new Scanner(System.in);
			int id = scanner.nextInt();

			String delete = "delete from student_table where id=" + id;

			int effect = statement.executeUpdate(delete);

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
