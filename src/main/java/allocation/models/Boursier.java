package allocation.models;

public class Boursier extends Etudiant{
    private TypeBourse typeBourse;
    private Integer valeur ;
    private Chambre chambre ;

   

    public TypeBourse getTypeBourse() {
        return typeBourse;
    }

    public void setTypeBourse(TypeBourse typeBourse) {
        this.typeBourse = typeBourse;
    }
    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Chambre getChambre() {
        return chambre;
    }

    @Override
    public String toString() {
        return super.toString()+"chambre=" + chambre + ", typeBourse=" + typeBourse + ", valeur=" + valeur ;
    }
}
