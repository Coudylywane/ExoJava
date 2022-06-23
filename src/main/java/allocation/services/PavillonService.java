package allocation.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import allocation.DAO.PavillonDao;
import allocation.interfaces.IPavillon;
import allocation.models.Chambre;
import allocation.models.Pavillon;

public class PavillonService implements IPavillon{


    PavillonDao pavillonDao = new PavillonDao();
    List<Pavillon> pavillons = new ArrayList<>();



    @Override
    public boolean addPavillon(Pavillon pavillon) {
        return pavillonDao.addPavillon(pavillon);
    }

    @Override
    public boolean addPavillon(Pavillon pavillon, ArrayList<Chambre> chambres) {
        pavillon.getChambres().addAll(chambres) ;
        return pavillons.add(pavillon);
    }


    @Override
    public List<Pavillon> getAllPavillons() {

        try {

            ResultSet rs = pavillonDao.getAllPavillons();
            if (rs != null) {

                while (rs.next()) {
                    Pavillon pavillon = new Pavillon();
                    pavillon.setId(rs.getInt("id"));
                    pavillon.setNum(rs.getInt("num"));
                    pavillon.setNbreEtage(rs.getInt("nbreEtage"));

                    pavillons.add(pavillon);
                    
                }
                
            }

            
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return pavillons;
    }


    @Override
    public boolean modifierPavillon(Pavillon pavillon) {
        return pavillonDao.modifPavillon(pavillon);

    }


    @Override
    public Pavillon rechercherPavillon(int id) {
        Pavillon pavillon = new Pavillon();
        try {
            ResultSet rs = pavillonDao.getOnePavillon(id);
            while (rs.next()) {
                pavillon.setId(rs.getInt("id"));
                pavillon.setNum(rs.getInt("num"));
                pavillon.setNbreEtage(rs.getInt("nbreEtage"));

            }
            return pavillon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean deletePavillon(Pavillon pavillon) {
        return pavillonDao.delPavillon(pavillon);

    }




    
}
