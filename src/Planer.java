import Views.*;
import Controller.*;
import ObjektModelle.*;

public class Planer{

    public static void main(String[] args){
	Controller.GartenController gc = new Controller.GartenController();	
	Controller.BeetController bc = new Controller.BeetController();
	gc.setBC(bc);
	Views.Funktionen ff = new Views.Funktionen(gc, bc);
	Views.Hauptfenster hf = new Views.Hauptfenster(gc, ff);
	ff.setHauptfenster(hf);

    }

}
