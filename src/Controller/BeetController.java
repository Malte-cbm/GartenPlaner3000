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
    
    public BeetView neuBeetModel(int x, int y, int b, int t){
	BeetModel jasohalt = new BeetModel(x, y);
	jasohalt.setzeMasse( b, t);
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
