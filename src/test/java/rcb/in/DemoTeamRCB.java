package rcb.in;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

public class DemoTeamRCB {
	
	static String country_value="India";
	static String player="player";
    static String country_key="country";
    static String role_key="role";
    static String role_value="wicket-keeper";
    
    @Test
    public void verifyTeamPlayers () throws FileNotFoundException, IOException, ParseException {
    	
    	Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\DemoTeamRCB\\src\\test\\resources\\teamdetails.json"));
    	JSONObject jo = (JSONObject) obj;
    	JSONArray ja = (JSONArray) jo.get(player);
    	int country_count=0;
    	int wk_count=0;
    	Iterator itr2 = ja.iterator();
         while(itr2.hasNext()) {
        	Iterator itr1 =((Map) itr2.next()).entrySet().iterator();
        	while (itr1.hasNext()) {
        		Map.Entry pair = (java.util.Map.Entry) itr1.next();
        		if(pair.getKey().equals(country_key)) {
        			if(pair.getValue().equals(country_value)) {
        		}
        			else {country_count++;}
        		}
        		if (pair.getKey().equals(role_key)) {
        			if(pair.getValue().equals(role_value))
        			{ wk_count++;
        		}
        	}	
        }
        	if(country_count==4) {
        		System.out.println("Team has overseas player it is verified sucessfully");
        	}
    		else {
        		System.out.println("Team has not having required overseas player");
        		Assert.assertFalse(true);
        	}
    	if(wk_count==4) {
    		System.out.println("Team has a WicketKeeper");
    	}
    	else {
    		System.out.println("Team has not having WicketKeeper");
    		Assert.assertFalse(true);
    	}
    }  
    }
    }
