import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ReadImage2ndTest {
	static OkHttpClient client = new OkHttpClient();
	
    public static void main(String[] args) throws IOException {   	
    	final String key = "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCbu/SMoLcwwuco\n36JzZvzt3pjNFa3zKvlE15W4cGswIJteL0wK6mLdbOs3zC77QR7Y+wV0Ed/XUQm1\nIX3PaM5YT+Jxsl0ixijS2dE08oBT3g4zfP6bdgS6X41Y1n2dHq5ywJhHfP9o6oMF\n7RTS3mJf5xEPINYgnpJahvdnTOSOi2puPHDC2vxT0SJi4fYQF6d6+3fdJyhk6Zad\nBZDa75fbEVDVMhMD8L3NWUusamBalP1khRjng+RCMfgef3B+r/KbOjUvisMObfFu\nteqPPS0AnoOFqGqlP93Wcp0AjyK/vza5i59YTspkSBO8ULuKYfbbTCxz62It3Cby\nVdttCnJPAgMBAAECggEAD4sR3FtKDV7WjXjMkPINenxGCeoJA4UdfeZ6df8aY6JN\nf3f/AfPkzC7LxzTk14TnXEapg60pByd6bY6bLPFL7vqCIlDoBMl8V5cPz1YIwtYd\n2ru1+bQswqE4zU4TGXRvetqIGFJ8d284hoXkFyvE68d3J2hilrzc5JYl6TR+d0+A\n+bWuAoDL1CdGv4vZeJ9hBZLrXVmbZ6XdtbEjF4Tq+LsXmT7Bmhz/Tkah0/QB/qDg\nLSrrRZ+St8fK5JsunJiPZ/6xU5kb89I6d0dSPaakKc0gNpSDqoeViYJ4VJ1bGx2W\neuXkgMbqYUzPXs5uzchG/40wyBygdfnmjsGutc4ZMQKBgQDQlnizfKZvPLNsBMeG\nZZzG687NfxPJLn0pkvAqLH7NhOW5xoRHMHgkIakqES9zO/UwbEnSXjLnSrte/2t6\nyCbv+u09s5HXiS7qzZWDq8ZPn2vu1N8vtuOHYS3HQna0aPuG6qKwIhkxR5ESPiSU\n14EscVtJb4xGCVE5dqR3o/iO9wKBgQC/Ifu3oZl5cfNegqJwbiKstB9weOLZyDN3\nbZ3sCYOEpWHwg1Wp+h2gtGsMkQWLXiZdJsM5DUF5622R8Y7N/zUPSPr/7ThNNgY5\nzT4+Yc46PHmdghD1xeHpiLhWMHfcGhLg1C3NGLjmKnvhsFrRkNM37Y3G54LR/gRZ\n6HyJGo/paQKBgF7TqXffuUJk1CTNX2/oDggY9+FQXkxdyCT4WhqyM8t3GYEFkOlU\nTaoPa3pmaa33mhYzhLQQgw/HV7tuXwxopdr/to8QbcMQ6LVyVQCRPQzBqy3etMBa\nYsIPGeK2goSuHXtOfDuapN1Ubc1fVv4bouvzdM7D2X+ViMmY+FgzwTItAoGAJp/7\nenSRy1UX1XWY1hersjMEV3pWfaRTokLosxaJGXlCfZRM73i4HA3ZxERaVnvETPbU\nZOck4DqPffrO3RpB4sDg2G9b/V55i5zKg1jIkERAX3A1dTV0HfmfJuvMjRJH1l+K\nkfP5Cap0NnupHsihpp+/Ev8eFMm8n164LAzOIGECgYASHBfik+YYY6TViSuzMLzz\nhuVrLK4G4lWImDCHtSXR1SsPep05HP+r+cDLIq1BeOhpT8InQtIhMqOC2i3TDaxV\n5r96mNy/FkCtU4Hok9/fAfyQMXJUyUKoRIGgeo7eIlzMe6YbXAYEU4v0h6CVcVxq\nSV0mDAV9uk89Qxvm/lfuQg==\n-----END PRIVATE KEY-----\n";   
        //Image imageTest = ImageInputStream;
    	
    	Image image = null;
        try {
            /*// Read from a file
            File sourceimage = new File("source.gif");
            image = ImageIO.read(sourceimage);
         
            // Read from an input stream
            InputStream is = new BufferedInputStream(
                new FileInputStream("source.gif"));
            image = ImageIO.read(is);*/
         
            // Read from a URL
            URL url = new URL("https://www.comptoir-irlandais.com/2320-thickbox_default/molson-canadian-lager.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
        }
    	
    	
    	
    	
    	Request request = new Request.Builder()
          .url("https://vision.googleapis.com/v1/images:annotate?key=" + key)
          
          .build();
        
        Call call = client.newCall(request);
        Response response = call.execute();
        String reader = response.body().string();
        
        System.out.println(request);
        System.out.println("ok");
        System.out.println(response);
        System.out.println("ok");
        System.out.println(reader);
        
        
         
        // Use a label to display the image
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
