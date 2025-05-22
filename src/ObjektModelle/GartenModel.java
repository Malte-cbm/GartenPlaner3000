package ObjektModelle;
import java.util.*;
import Views.*;

public class GartenModel {
	
    private String adresse;
    private ArrayList<BeetModel> beete;
    private int breite;
    private int tiefe;
    private ArrayList<Subscriber> listeDerZuschauer;

    public GartenModel(){
	this.listeDerZuschauer = new ArrayList<Subscriber>();
	this.beete = new ArrayList<BeetModel>();
    }

    public void addObserver(Subscriber aha) {
        this.listeDerZuschauer.add(aha);
	System.out.println("Observer hinzugefügt im GartenModel!");
    }

    public void removeObserver(Subscriber soso) {
        this.listeDerZuschauer.remove(soso);
    }
    
    public void sendUpdate() {
        for (Subscriber pifpaf : this.listeDerZuschauer) {
	    	    
            pifpaf.update(this);
        }
    }

    public BeetModel getBeet( int x, int y )  {
	for( BeetModel beet : beete ) {
	    if( beet.hitTest(x,y) ) {
		return beet;
	    }
	}

	return null;
    }

    public void deselectAll( ) {
	for( BeetModel beet : beete ) {
	    beet.setSelected(false);
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
	
