package allocation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import allocation.models.Chambre;
import allocation.models.Pavillon;

public class ChambreDao {

    public ResultSet getAllChambres() throws SQLException{
        Connection con = DB.getConnection();
        String query = "SELECT * FROM chambre";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public boolean addChambre(Chambre chambre) {
        Connection conn = DB.getConnection();
        String query = "INSERT INTO chambre(numCh,numEtage,etat) VALUES(?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, chambre.getNumCh());
            statement.setInt(2, chambre.getNumEtage());
            statement.setString(3, chambre.getEtat());

            statement.execute();
            statement.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean addChambre(Chambre chambre, Pavillon pavillon) {
        Connection conn = DB.getConnection();
        String query = "INSERT INTO chambre(numCh,numEtage,etat,id_pavillon) VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, chambre.getNumCh());
            statement.setInt(2, chambre.getNumEtage());
            statement.setString(3, chambre.getEtat());
            statement.setInt(4, pavillon.getId());

            statement.execute();
            statement.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean modifChambre(Chambre chambre) {
        Connection conn = DB.getConnection();
        String query = "UPDATE chambre SET numCh=? , numEtage=? , etat=? WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, chambre.getNumCh());
            statement.setInt(2, chambre.getNumEtage());
            statement.setString(3, chambre.getEtat());
            statement.setInt(4, chambre.getId());

            statement.execute();
            statement.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean delChambre(Chambre chambre) {
        Connection conn = DB.getConnection();
        String query = "DELETE FROM chambre  WHERE chambre.id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, chambre.getId());

            statement.execute();
            statement.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
    

