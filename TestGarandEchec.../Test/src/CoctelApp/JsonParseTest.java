package CoctelApp;
 //package com.javacodegeeks.javabasics.jsonparsertest;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
  
public class JsonParseTest {
	
	static OkHttpClient client = new OkHttpClient();
    static Request request = new Request.Builder()
        //.url("https://the-cocktail-db.p.rapidapi.com/lookup.php?i=11227")
    	.url("https://www.thecocktaildb.com/api/json/v1/1/random.php")
    	//.url("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=Green Goblin")
    	//.url("https://vision.googleapis.com/v1/images:annotate")
    		//.url("https://console.cloud.google.com/storage/browser/cloud-samples-data/vision/using_curl/shanghai.jpeg")
    	//.get()
        //.addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
        //.addHeader("x-rapidapi-key", "4527d57cc6msh768e09bb02bba03p172fd8jsn48546d794e1f")
        .build();
 
     
       
    public static void main(String[] args) throws Exception {
    	String reader = null;
    	/*Image image = Toolkit.getDefaultToolkit().getImage("LagerTest.png");
    	// Création du MediaTracker et enregistrement de l'image
    	MediaTracker tracker = new MediaTracker(null);
    	tracker.addImage(image, 0);
    	// Attente proprement dite
    	try { tracker.waitForID(0); }
    	catch(InterruptedException e) {}*/
    	  
    	System.out.println("ok");
    	try {
    		reader = client.newCall(request).execute().body().string();
    		//System.out.println(reader);
        	//System.out.println("we are in"); //DEBUG
 
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
 
            // get an array from the JSON object
            JSONArray lang = (JSONArray) jsonObject.get("drinks");

            Iterator i = lang.iterator();
 
            // take value from the json array separately
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("The name of the cocktail is " + innerObj.get("strDrink"));
                System.out.println("Here, the list of Ingredients : " + "\n");
               
                int j = 1;
                while(innerObj.get("strIngredient" + j) != null && j<=15) {
                	System.out.println("Ingredient : " + innerObj.get("strIngredient" + j));
  
                	System.out.println("Measure : " + innerObj.get("strMeasure" + j));
                	j++;
                }
                System.out.println("\n");
                System.out.println("Instructions : " + "\n" + innerObj.get("strInstructions") + "\n");
                
                System.out.println("photo : " + "\n" + innerObj.get("strDrinkThumb"));
                String ImagePath = (String) innerObj.get("strDrinkThumb");
                //String outputImagePath = "/home/rgarand/Bureau/" + innerObj.get("strDrink") +".png";
                String outputImagePath = "/home/rgarand/Documents/Git/CoctelAPP/Photo/" + innerObj.get("strDrink") +".png";
                //System.out.println(ImagePath);
                try {
                	int scaledWidth = 1024;
                    int scaledHeight = 768;
                    resizehere(ImagePath, outputImagePath, scaledWidth, scaledHeight);
                	
                } catch (Exception e) {
                	e.printStackTrace();
                }
                //System.out.println("The name is " + innerObj.get("strDrink") +
                		
                //        " with instructions : " + "\n" + innerObj.get("strInstructions"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void resizehere(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
    	
    	URL url = new URL(inputImagePath);
    	Image image = ImageIO.read(url);
        //File inputFile = new File(inputImagePath);
        
        //var inputImage = ImageIO.read(inputFile);
        //System.out.println(inputImagePath);
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
               scaledHeight, ((BufferedImage) image).getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
  
}