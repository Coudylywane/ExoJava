package allocation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import allocation.models.Pavillon;

public class PavillonDao {
    private Connection con;
    
    public PavillonDao(Connection conn) {
        this.con = conn;
    }

    public ResultSet getAllPavillons() throws SQLException{
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "SELECT * FROM pavillon";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public ResultSet getOnePavillon(int id) throws SQLException{
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "SELECT * FROM pavillon WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public boolean addPavillon(Pavillon pavillon) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "INSERT INTO pavillon(num,nbreEtage) VALUES(?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, pavillon.getNum());
            statement.setInt(2, pavillon.getNbreEtage());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean modifPavillon(Pavillon pavillon) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "UPDATE pavillon SET num=? , nbreEtage=?  WHERE id = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, pavillon.getNum());
            statement.setInt(2, pavillon.getNbreEtage());
            statement.setInt(3, pavillon.getId());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean delPavillon(Pavillon pavillon) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "DELETE FROM pavillon  WHERE pavillon.id = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, pavillon.getId());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void add(Pavillon pavillon) {
    }
}
