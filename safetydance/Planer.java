import Views.*;
import Controller.*;
import ObjektModelle.*;

public class Planer{

    public static void main(String[] args){
	
	Controller.GartenController gc = new Controller.GartenController();
	Views.Funktionen ff = new Views.Funktionen(gc);
	Views.Hauptfenster hf = new Views.Hauptfenster(gc, ff);
	ff.setHauptfenster(hf);

    }

}
