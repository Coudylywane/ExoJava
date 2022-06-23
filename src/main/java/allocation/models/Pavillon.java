package allocation.models;

import java.util.ArrayList;

public class Pavillon {
    private Integer id ;
    private Integer  num;
    private Integer nbreEtage ;
    private ArrayList <Chambre> chambres ;


    public Pavillon(Integer id) {
        this.id = id;
    }

    public Pavillon() {
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbreEtage() {
        return nbreEtage;
    }

    public void setNbreEtage(Integer nbreEtage) {
        this.nbreEtage = nbreEtage;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Pavillon [chambres=" + chambres + ", id=" + id + ", nbreEtage=" + nbreEtage + ", num=" + num + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return  ((Pavillon)obj).getId() == this.id;
       
    }

    public boolean add(Pavillon pavillon) {
        return false;
    }

   
}
