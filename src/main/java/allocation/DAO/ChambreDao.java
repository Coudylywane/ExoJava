package allocation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import allocation.models.Chambre;
import allocation.models.Pavillon;

public class ChambreDao {

    private Connection con;

    public ChambreDao(Connection conn) {
        this.con = conn;
    }

    public ResultSet getAllChambres() throws SQLException{
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "SELECT * FROM chambre";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public boolean addChambre(Chambre chambre) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "INSERT INTO chambre(numCh,numEtage,etat) VALUES(?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, chambre.getNumCh());
            statement.setInt(2, chambre.getNumEtage());
            statement.setString(3, chambre.getEtat());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean addChambre(Chambre chambre, Pavillon pavillon) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "INSERT INTO chambre(numCh,numEtage,etat,id_pavillon) VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, chambre.getNumCh());
            statement.setInt(2, chambre.getNumEtage());
            statement.setString(3, chambre.getEtat());
            statement.setInt(4, pavillon.getId());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean modifChambre(Chambre chambre) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "UPDATE chambre SET numCh=? , numEtage=? , etat=? WHERE id = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, chambre.getNumCh());
            statement.setInt(2, chambre.getNumEtage());
            statement.setString(3, chambre.getEtat());
            statement.setInt(4, chambre.getId());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean delChambre(Chambre chambre) {
        if (con == null) {
            con = DB.getConnection();
        }
        String query = "DELETE FROM chambre  WHERE chambre.id = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, chambre.getId());

            statement.execute();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
    

