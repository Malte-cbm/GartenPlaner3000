package ObjektModelle;

import java.util.ArrayList;
import Views.*;

public class BeetModel {

    private int id;
    private int breite;
    private int tiefe;
    private int posX;
    private int posY;
    private boolean selected;
    private ArrayList<PlantPoint> belegung;

    private ArrayList<Subscriber> listeDerZuschauer;

    public BeetModel(int x, int y){
	this.belegung = new ArrayList<PlantPoint>();
	this.listeDerZuschauer = new ArrayList<Subscriber>();
	this.posX = x;
	this.posY = y;
    }

    public void addObserver(Subscriber aha) {
        this.listeDerZuschauer.add(aha);
	System.out.println("Observer hinzugefügt im BeetModel!");
    }

    public void removeObserver(Subscriber soso) {
        this.listeDerZuschauer.remove(soso);
    }
    
    public void sendUpdate() {
        for (Subscriber pifpaf : this.listeDerZuschauer) {
            pifpaf.update(this);
        }
    }

    public void setSelected( boolean selected ) {
	this.selected = selected;
    }

    public boolean isSelected() {
	return this.selected;

    }

    public boolean hitTest( int x, int y ) {

	return x >= this.posX && x <= this.posX + this.breite  && y >= this.posY && y <= this.posY + this.tiefe;
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

    public int getX(){
	return this.posX;
    }

    public int getY(){
	return this.posY;
    }

    public void setzePP( PlantPoint pp ){
	this.belegung.add(pp);
    }

    public ArrayList<PlantPoint> zeigeAllePP(){
	return this.belegung;
    }
}
