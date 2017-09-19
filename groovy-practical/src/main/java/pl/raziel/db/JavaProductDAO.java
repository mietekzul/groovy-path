package pl.raziel.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaProductDAO implements ProductDAO {
    private static final String URL = "jdbc:h2:./build/test";
    private static final String DRIVER = "org.h2.Driver";

    public JavaProductDAO() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        createAndPopulateTable();
    }

    private void createAndPopulateTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
            stmt.execute("drop table product if exists;");
            stmt.execute("create table product (id int primary key, name varchar(25), price double);");
            stmt.executeUpdate("insert into product values (1,'baseball',4.99),(2,'football',14.95),(3,'basketball',14.99)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionStatement(conn, stmt);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        Connection conn = null;
        PreparedStatement pst = null;
        List<Product> results = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                results.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionStatement(conn, pst);
        }
        return results;
    }

    @Override
    public Product findProductById(int id) {
        Product p = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from product where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionStatement(conn, pst);
        }
        return p;
    }

    @Override
    public void insertProduct(Product p) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("insert into product (id,name,price) values (?,?,?)");
            pst.setInt(1, p.getId());
            pst.setString(2, p.getName());
            pst.setDouble(3, p.getPrice());
            int uc = pst.executeUpdate();
            if (uc != 1) throw new SQLException("insert of product failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionStatement(conn, pst);
        }
    }

    @Override
    public void deleteProduct(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("delete from product where id=?");
            pst.setInt(1, id);
            int uc = pst.executeUpdate();
            if (uc != 1) throw new SQLException("delete of product failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionStatement(conn, pst);
        }
    }

    private void closeConnectionStatement(Connection conn, Statement stmt) {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
