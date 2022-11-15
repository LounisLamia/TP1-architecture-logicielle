package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	private static final String Color = null;


	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// cr�ation de la fen�tre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// cr�ation de la z�ne de dessin dans la fen�tre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fen�tre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		//
		
		Visage unvisage = new Visage(d, 200, 100, 100, 120);
		d.ajouterObjet(unvisage);
		
		Etoile etoile = new Etoile(200,100,50,10,new Color(0,(float) Math.random(),0),new Color(0,(float) Math.random(),0));
		d.ajouterObjet(etoile);
		
		PolygoneRegulier polygone= new PolygoneRegulier(6,300,200,50,10,new Color(0,0,0),new Color(0,0,0));
		d.ajouterObjet(polygone);
		
		//Etoile etoilejeune = new Etoile(200,100,50,10,new Color((float) Math.random(),(float) Math.random(),0 ),new Color((float) Math.random(),(float) Math.random(),0));
         
		//AnimationForme animationforme =new AnimationForme(etoilejeune,new MvtCirculaire(250,250,180,0,5));
		
		//d.ajouterObjet(animationforme);
		
		//PolygoneRegulier polygonegris = new PolygoneRegulier(6,300,200,50,10,new Color((float) Math.random(),(float) Math.random(),(float) Math.random()),new Color((float) Math.random(),(float) Math.random(),(float) Math.random()));
		//AnimationForme animation =new AnimationForme(polygonegris,new MvtCirculaire(250,250,100,0,5));
		
		//d.ajouterObjet(animation);
		
				
				
				
		while(true) {
		// la zone de dessin se r�affiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//r�aliser � tous les trains un d�placement �l�mentaire
		d.animer();
		
		}

	}

}
