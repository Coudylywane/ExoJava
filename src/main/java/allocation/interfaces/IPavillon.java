package allocation.interfaces;

import java.util.List;

import allocation.models.Pavillon;

public interface IPavillon {
    boolean addPavillon(Pavillon pavillon);
    boolean modifierPavillon(Pavillon pavillon);
    List <Pavillon> getAllPavillons();
    Pavillon rechercherPavillon(int id);
    boolean deletePavillon(Pavillon pavillon);
}
