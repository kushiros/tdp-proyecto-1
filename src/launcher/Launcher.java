package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student Juan = new Student(130747, "Dominguez", "Juan Cruz", "jcdominguez01.jcd@gmail.com", "https://github.com/kushiros/tdp-proyecto-1", "/Images/kushis.jpg");
        		
            	SimplePresentationScreen interfaz = new SimplePresentationScreen(Juan);
				interfaz.setVisible(true);
            }
        });
    }
}