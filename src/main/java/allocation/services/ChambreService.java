package allocation.services;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import allocation.DAO.ChambreDao;
import allocation.interfaces.IChambre;
import allocation.models.Chambre;

public class ChambreService implements IChambre{
    ChambreDao chambreDao = new ChambreDao();
    List<Chambre> chambres = new ArrayList<>();



    @Override
    public boolean addChambre(Chambre chambre) {
        return chambreDao.addChambre(chambre);
    }


    @Override
    public List<Chambre> getAllChambres() {

        try {

            ResultSet rs = chambreDao.getAllChambres();
            if (rs != null) {

                while (rs.next()) {
                    Chambre chambre = new Chambre();
                    chambre.setId(rs.getInt("id"));
                    chambre.setNumCh(rs.getInt("numCh"));
                    chambre.setNumEtage(rs.getInt("numEtage"));
                    chambre.setEtat(rs.getString("etat"));

                    chambres.add(chambre);
                    
                }
                
            }

            
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return chambres;
    }


    @Override
    public boolean modifierChambre(Chambre chambre) {
        return chambreDao.modifChambre(chambre);

    }


    @Override
    public Chambre rechercherChambre(int id) {
        Chambre ch = new Chambre(id);
        for (Chambre chambre : chambres) {
            if (chambre.equals(ch)) {
                return chambre ;
            }
        }
        return null;
    }


    @Override
    public boolean deleteChambre(Chambre chambre) {
        return chambreDao.delChambre(chambre);

    }
    
}
