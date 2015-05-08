import static spark.Spark.get;


import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;



public class Server {

	public static void main(String[] args) {
		
		final MusicList list = new MusicList();
		
		list.addMusic(new Music("Note:Capo in the 3rd -- [G] How many special people change [F] How many lives...", new Specification("oasis", "champagnesupernova")));
		list.addMusic(new Music("Note:Capo in the 2rd -- [Em] Today is ...", new Specification("oasis", "wonderwall")));
		
		
		get(new Route("/tablature/:band/:music") {
	         @Override
	         public Object handle(Request request, Response response) {

	            response.header("Access-Control-Allow-Origin", "*");
	        	 
	     	    Music result = list.searchMusic(new Specification(request.params(":band"), request.params(":music")));

	     	    JSONObject jsonObj = new JSONObject();
	     	   
	     	    if(result!=null){
	     	    	
	     	    	
	     	    	try {
						jsonObj.put("chords", result.getChords());
						
					} catch (JSONException e) {
						
						e.printStackTrace();
					}
	     	    	
	     	    	return jsonObj;
	     	    	
	     	    } else {
	     	    	try {
						jsonObj.put("status", "erro");
						
					} catch (JSONException e) {
						
						e.printStackTrace();
					}
	     	    	return jsonObj;
	     	    }
	     	    
	     	    
		   	}
    	});
		
	}
	
}
