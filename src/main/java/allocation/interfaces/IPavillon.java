package allocation.interfaces;

import java.util.ArrayList;
import java.util.List;

import allocation.models.Chambre;
import allocation.models.Pavillon;

public interface IPavillon {
    boolean addPavillon(Pavillon pavillon);
    public boolean addPavillon(Pavillon pavillon , ArrayList<Chambre> chambres);

    boolean modifierPavillon(Pavillon pavillon);
    List <Pavillon> getAllPavillons();
    Pavillon rechercherPavillon(int id);
    boolean deletePavillon(Pavillon pavillon);
}
