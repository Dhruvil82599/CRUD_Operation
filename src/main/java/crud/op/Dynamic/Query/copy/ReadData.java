package crud.op.Dynamic.Query.copy;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
	public static void main(String[] args) {
		System.out.println("Read Data");

		try {
			String url = "jdbc:postgresql://localhost:5432/aj_jdbc?user=postgres&password=root";

			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String read = "select * from student_table";

			PreparedStatement preparedStatement = connection.prepareStatement(read);
			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("ID\t\tName\t\tBranch\t\tDivision");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String branch = resultSet.getString(3);
				String division = resultSet.getString(4);

				System.out.println(id + "\t\t" + name+ "\t\t" + branch+ "\t\t" + division);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
