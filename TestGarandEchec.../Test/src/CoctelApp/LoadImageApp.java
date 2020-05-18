package CoctelApp;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 
/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {
           
    BufferedImage img;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
 
    public LoadImageApp() {
       try {
           img = ImageIO.read(new File("/home/rgarand/Bureau/LagerTest.png"));
       } catch (IOException e) {
       }
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
        System.out.println(img.getWidth() + " and " + img.getHeight());
        if(img.getHeight()>1080) {         
        	BufferedImage resizedImage = new BufferedImage(img.getWidth(), img.getHeight(),img.getType());
        	Graphics2D g = resizedImage.createGraphics();
        	g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
        	g.dispose();
        	System.out.println("on est la");
        	return new Dimension(img.getWidth(null), img.getHeight(null));
        } else {
        
           //return new Dimension(500,500);
           return new Dimension(img.getWidth(null), img.getHeight(null));
        }
       }
    }
    
 
    public static void main(String[] args) {
 
        JFrame f = new JFrame("Load Image Sample");
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.add(new LoadImageApp());
        f.pack();
        f.setVisible(true);
    }
}