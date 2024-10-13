package org.example.cafeweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public Connection openConnectToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cafe"; // Thay "tên_cơ_sở_dữ_liệu" bằng tên cơ sở dữ liệu của bạn
        String userName = "root";
        String password = "1234";

        Connection connection = null;
        try  {
            // Tạo kết nối
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
//            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
//            System.out.println("Kết nối thất bại!");
//            e.printStackTrace();
            throw new IllegalStateException("error sql: ", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
