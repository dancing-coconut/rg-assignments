import java.sql.*;

public class EmployeeJDBC {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/employeedb";
        String username = "postgres";
        String password = "";

        String select_all_sql = "SELECT * FROM employees;";

        String create_sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?), (?, ?, ?);";
        String read_sql = "SELECT * FROM employees WHERE id = ?;";
        String update_sql = "UPDATE employees SET id = ?, name = ?, department = ? WHERE id = ?;";
        String delete_sql = "DELETE FROM employees WHERE id = ?;";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            // CREATE (C)
            try {
                PreparedStatement preparedStatement = con.prepareStatement(create_sql);

                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "Employee 1");
                preparedStatement.setString(3, "Department 1");

                preparedStatement.setInt(4, 2);
                preparedStatement.setString(5, "Employee 2");
                preparedStatement.setString(6, "Department 2");

                preparedStatement.executeUpdate();

                PreparedStatement viewStatement = con.prepareStatement(select_all_sql);
                ResultSet rs = viewStatement.executeQuery();

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Department: " + rs.getString("department") + "\n");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // READ (R)
            try {
                PreparedStatement preparedStatement = con.prepareStatement(read_sql);

                preparedStatement.setInt(1, 1);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Department: " + rs.getString("department") + "\n");
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // UPDATE (U)
            try {
                PreparedStatement preparedStatement = con.prepareStatement(update_sql);

                preparedStatement.setInt(1, 3);
                preparedStatement.setString(2, "Employee 3");
                preparedStatement.setString(3, "Department 3");

                preparedStatement.setInt(4, 2);

                preparedStatement.executeUpdate();

                PreparedStatement viewStatement = con.prepareStatement(select_all_sql);
                ResultSet rs = viewStatement.executeQuery();

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Department: " + rs.getString("department") + "\n");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // DELETE (D)
            try {
                PreparedStatement preparedStatement = con.prepareStatement(delete_sql);

                preparedStatement.setInt(1, 3);

                preparedStatement.executeUpdate();

                PreparedStatement viewStatement = con.prepareStatement(select_all_sql);
                ResultSet rs = viewStatement.executeQuery();

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Department: " + rs.getString("department" + "\n") + "\n");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
