package ObjektModelle;

public class PflanzeModel {

    private String name;
    private int saisonStart;
    private int saisonEnde;
    private int aussaatStart;
    private int aussaatEnde;

    public void setName(String name){
	this.name = name;
    }

    public void setSaisonStart(int start){
	this.saisonStart = start;
    }
    public void setSaisonEnde (int ende){
	this.saisonEnde = ende;
    }

    public void setAussaatStart(int start){
	this.aussaatStart = start;
    }
    public void setAussaatEnde(int ende){
	this.aussaatEnde = ende;
    }
    
    public String getName(){
	return this.name;
    }
    
    public int getSaisonStart(){
	return this.saisonStart;
    }
    public int getSaisonEnde(){
	return this.saisonEnde;
    }

    public int getAussaatStart(){
	return this.aussaatStart;
    }
    public int getAussaatEnde(){
	return this.aussaatEnde;
    }
}
