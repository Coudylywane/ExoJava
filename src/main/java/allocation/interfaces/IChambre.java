package allocation.interfaces;

import java.util.List;

import allocation.models.Chambre;
import allocation.models.Pavillon;

public interface IChambre {

    boolean addChambre(Chambre chambre);
    boolean addChambre(Chambre chambre , Pavillon pavillon);
    boolean modifierChambre(Chambre chambre);
    List <Chambre> getAllChambres();
    Chambre rechercherChambre(int id);
    boolean deleteChambre(Chambre chambre);
    
}
