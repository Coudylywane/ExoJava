package allocation.models;

 public  abstract class Personne {
   protected int id;
   protected String nomComplet ;
   protected String email ;
   protected TypePersonne type ;






    

public Personne(){}

public Personne(String nomComplet , String email){}


public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNomComplet() {
    return nomComplet;
}

public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public void setType(TypePersonne type) {
    this.type = type;
}

public TypePersonne getType() {
    return type;
}

@Override
public String toString() {
    return "Personne [email=" + email + ", id=" + id + ", nomComplet=" + nomComplet + ", type=" + type + "]";
}

@Override
public boolean equals(Object obj) {
    return ((Personne)obj).getId()== id;
}


}
