package ObjektModelle;
import java.util.*;
import Views.*;

public class GartenModel {
	
    private String adresse;
    private ArrayList<BeetModel> beete;
    private int breite;
    private int tiefe;

    private ArrayList<deimuddi> listeDerZuschauer;

    public GartenModel(){
	this.listeDerZuschauer = new ArrayList<deimuddi>();
    }

    public void addObserver(deimuddi aha) {
        this.listeDerZuschauer.add(aha);
	System.out.println("Observer hinzugefügt im GartenModel!");
    }

    public void removeObserver(deimuddi soso) {
        this.listeDerZuschauer.remove(soso);
    }
    
    public void sendUpdate() {
        for (deimuddi pifpaf : this.listeDerZuschauer) {
            pifpaf.update(this);
        }
    }

    public void setzeMasse( int b, int t){
	this.breite = b;
	this.tiefe = t;
    }

    public int getBreite(){
	return this.breite;
    }

    public int getTiefe(){
	return this.tiefe;
    }
    
    public void setzeAdresse(String a){
	this.adresse = a;
	}

    public String nenneAdresse(){
	return this.adresse;
    }

    public void addBeet(BeetModel b){
	this.beete.add(b);
    }

    public ArrayList<BeetModel> zeigeAlleBeete(){
	return this.beete;
    }

}
	
