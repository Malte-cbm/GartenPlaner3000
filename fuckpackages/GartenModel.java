import java.util.ArrayList;

public class GartenModel extends Raum {

    private String adresse;
    private ArrayList<BeetModel> beete;
    private int breite;
    private int tiefe;

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

}
	
