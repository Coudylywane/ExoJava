package allocation.models;



public class Chambre {
    private Integer id ;
    private Integer numCh ;
    private Integer numEtage ;
    private String etat ;
    private Pavillon pavillon ;




   
   
    public Pavillon getPavillon() {
        return pavillon;
    }
    public void setPavillon(Pavillon pavillon) {
        this.pavillon = pavillon;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getNumCh() {
        return numCh;
    }
    public void setNumCh(Integer numCh) {
        this.numCh = numCh;
    }
    public Integer getNumEtage() {
        return numEtage;
    }
    public void setNumEtage(Integer numEtage) {
        this.numEtage = numEtage;
    }

    public Chambre(Integer id) {
        this.id = id;
    }

    public Chambre (){}

    @Override
    public boolean equals(Object obj) {
        return  ((Chambre)obj).getId() == this.id;
       
    }
   





    


    





    

   

}
