package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ObjektModelle.*;
import Views.BeetView;
import Views.GV2;
import java.util.ArrayList;

public class BeetController{

    private ArrayList<BeetModel> bm;
    private GartenModel gm;
    private GartenController gc;
    
    public BeetController(){
	this.bm = new ArrayList<BeetModel>();
	//this.gc = gc;
    }
    
    public void addBV(BeetView bv, GV2 gv){
	gv.addBeet(bv);
    }

    public void setGM(GartenModel gm){
	this.gm = gm;
    }

    public int getSelected(){
	int selection = 0;
	for(BeetModel b : bm){
	    if(b.isSelected()){
		selection = b.getID();
	    }
	}
	return selection;
    }

    public ArrayList<Integer> getSelectedData(int id){
	ArrayList<Integer> res = new ArrayList<Integer>();
	for (BeetModel beet : this.bm){
	    if (beet.getID() == id){
		res.add(beet.getX());
		res.add(beet.getY());
		res.add(beet.getBreite());
		res.add(beet.getTiefe());
	    }
	}
	return res;
    }
	    
		
    
    public BeetView neuBeetModel(int x, int y, int b, int t, boolean n, int id){
	BeetModel jasohalt = new BeetModel(x, y);
	jasohalt.setzeMasse( b, t);
	if (n){
	    jasohalt.setNew();
	}
	else {
	    jasohalt.setID(id);
	}
	this.bm.add(jasohalt);
	sendeBeetAnGM(jasohalt);

	BeetView keinplanmann = new BeetView(jasohalt);
	return keinplanmann;
    }
    public void sendeBeetAnGM(BeetModel b){
	this.gm.addBeet(b);
    }
	
    public boolean formValidator(String x, String y, String b, String t){

	try {
	    Integer.parseInt(x);
	    Integer.parseInt(y);
	    Integer.parseInt(b);
	    Integer.parseInt(t);
	    return true;
	}
	catch (NumberFormatException e){
	    return false;
	}
    }
}
