package allocation.interfaces;

import java.util.List;

import allocation.models.Chambre;

public interface IChambre {

    boolean addChambre(Chambre chambre);
    boolean modifierChambre(Chambre chambre);
    List <Chambre> getAllChambres();
    Chambre rechercherChambre(int id);
    boolean deleteChambre(Chambre chambre);
    
}
