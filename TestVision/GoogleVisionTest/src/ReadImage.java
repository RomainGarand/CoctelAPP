import java.io.IOException;
import java.io.PrintStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//import com.google.cloud.vision.v1.*;

public class ReadImage {
	//export GOOGLE_APPLICATION_CREDENTIALS = "/home/rgarand/Bureau/Key.json";
	static OkHttpClient client = new OkHttpClient();
    /*static Request request = new Request.Builder()
    		//.url("https://www.thecocktaildb.com/api/json/v1/1/random.php")
    		.url("https://www.googleapis.com/robot/v1/metadata/x509/romain%40coctelapp-276715.iam.gserviceaccount.com")
    		
    		.build();*/

    public static void main(String[] args) throws IOException {
    	
    	String postBody = "test post";
    	String key = "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCbu/SMoLcwwuco\n36JzZvzt3pjNFa3zKvlE15W4cGswIJteL0wK6mLdbOs3zC77QR7Y+wV0Ed/XUQm1\nIX3PaM5YT+Jxsl0ixijS2dE08oBT3g4zfP6bdgS6X41Y1n2dHq5ywJhHfP9o6oMF\n7RTS3mJf5xEPINYgnpJahvdnTOSOi2puPHDC2vxT0SJi4fYQF6d6+3fdJyhk6Zad\nBZDa75fbEVDVMhMD8L3NWUusamBalP1khRjng+RCMfgef3B+r/KbOjUvisMObfFu\nteqPPS0AnoOFqGqlP93Wcp0AjyK/vza5i59YTspkSBO8ULuKYfbbTCxz62It3Cby\nVdttCnJPAgMBAAECggEAD4sR3FtKDV7WjXjMkPINenxGCeoJA4UdfeZ6df8aY6JN\nf3f/AfPkzC7LxzTk14TnXEapg60pByd6bY6bLPFL7vqCIlDoBMl8V5cPz1YIwtYd\n2ru1+bQswqE4zU4TGXRvetqIGFJ8d284hoXkFyvE68d3J2hilrzc5JYl6TR+d0+A\n+bWuAoDL1CdGv4vZeJ9hBZLrXVmbZ6XdtbEjF4Tq+LsXmT7Bmhz/Tkah0/QB/qDg\nLSrrRZ+St8fK5JsunJiPZ/6xU5kb89I6d0dSPaakKc0gNpSDqoeViYJ4VJ1bGx2W\neuXkgMbqYUzPXs5uzchG/40wyBygdfnmjsGutc4ZMQKBgQDQlnizfKZvPLNsBMeG\nZZzG687NfxPJLn0pkvAqLH7NhOW5xoRHMHgkIakqES9zO/UwbEnSXjLnSrte/2t6\nyCbv+u09s5HXiS7qzZWDq8ZPn2vu1N8vtuOHYS3HQna0aPuG6qKwIhkxR5ESPiSU\n14EscVtJb4xGCVE5dqR3o/iO9wKBgQC/Ifu3oZl5cfNegqJwbiKstB9weOLZyDN3\nbZ3sCYOEpWHwg1Wp+h2gtGsMkQWLXiZdJsM5DUF5622R8Y7N/zUPSPr/7ThNNgY5\nzT4+Yc46PHmdghD1xeHpiLhWMHfcGhLg1C3NGLjmKnvhsFrRkNM37Y3G54LR/gRZ\n6HyJGo/paQKBgF7TqXffuUJk1CTNX2/oDggY9+FQXkxdyCT4WhqyM8t3GYEFkOlU\nTaoPa3pmaa33mhYzhLQQgw/HV7tuXwxopdr/to8QbcMQ6LVyVQCRPQzBqy3etMBa\nYsIPGeK2goSuHXtOfDuapN1Ubc1fVv4bouvzdM7D2X+ViMmY+FgzwTItAoGAJp/7\nenSRy1UX1XWY1hersjMEV3pWfaRTokLosxaJGXlCfZRM73i4HA3ZxERaVnvETPbU\nZOck4DqPffrO3RpB4sDg2G9b/V55i5zKg1jIkERAX3A1dTV0HfmfJuvMjRJH1l+K\nkfP5Cap0NnupHsihpp+/Ev8eFMm8n164LAzOIGECgYASHBfik+YYY6TViSuzMLzz\nhuVrLK4G4lWImDCHtSXR1SsPep05HP+r+cDLIq1BeOhpT8InQtIhMqOC2i3TDaxV\n5r96mNy/FkCtU4Hok9/fAfyQMXJUyUKoRIGgeo7eIlzMe6YbXAYEU4v0h6CVcVxq\nSV0mDAV9uk89Qxvm/lfuQg==\n-----END PRIVATE KEY-----\n";
    	
        
        Request request = new Request.Builder()
          //.url("https://www.googleapis.com/robot/v1/metadata/x509/romain%40coctelapp-276715.iam.gserviceaccount.com")
          .url("https://westus.api.cognitive.microsoft.com/vision/v2.1/analyze?visualFeatures=Description,Tags&subscription-key=" + "lol")
          //.addHeader("Authorization", Credentials.basic("username", "password"))
          //.post(RequestBody.create(MediaType.parse("text/x-markdown"), postBody))
          //.url("https://language.googleapis.com/v1/documents:analyzeEntities?key=" + key)
          //.url("https://vision.googleapis.com/v1/images:annotate?key=" + key)
          .build();
     
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println("ok");
        String reader = response.body().string();
        System.out.println(response);
        System.out.println("ok");
        
        System.out.println(request);
        System.out.println("ok");
        System.out.println(reader);
        System.out.println("ok");
    }
    
    /*
    public static void detectLocalizedObjects(String filePath, PrintStream out)
            throws Exception, IOException {
    	
          List<AnnotateImageRequest> requests = new ArrayList<>();

          ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

          Image img = Image.newBuilder().setContent(imgBytes).build();
          AnnotateImageRequest request =
              AnnotateImageRequest.newBuilder()
                  .addFeatures(Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION))
                  .setImage(img)
                  .build();
          requests.add(request);

          // Perform the request
          try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            // Display the results
            for (AnnotateImageResponse res : responses) {
              for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
                out.format("Object name: %s\n", entity.getName());
                out.format("Confidence: %s\n", entity.getScore());
                out.format("Normalized Vertices:\n");
                entity
                    .getBoundingPoly()
                    .getNormalizedVerticesList()
                    .forEach(vertex -> out.format("- (%s, %s)\n", vertex.getX(), vertex.getY()));
              }
            }
         }
        }
 /*   
    	String reader = null;
    	System.out.println("ok");
    	try {
    		reader = client.newCall(request).execute().body().string();
    		System.out.println(reader);
        	//System.out.println("we are in"); //DEBUG
 
            //JSONParser jsonParser = new JSONParser();
            //JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
*/
}
