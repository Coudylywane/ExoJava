package allocation.models;

import java.util.Date;

abstract public class Etudiant extends Personne{
    protected String matricule ;
    protected String telephone ;
    protected Date dateNaisse;




    public Etudiant(){}

    public Etudiant(String nomString , String email , String matricule , String telephone , String dateNaiss){

    }

    @Override
    public String toString() {
        return super.toString()+ "dateNaisse=" + dateNaisse + ", matricule=" + matricule + ", telephone=" + telephone ;
    }

}
