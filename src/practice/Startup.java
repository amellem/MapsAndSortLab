
package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amellem
 */
public class Startup {
    public static void main(String[] args) {
        
        Map<String,List<String>> favoriteCars = new HashMap<>();
        
        List<String> favFords = new ArrayList<>();
        favFords.add("Ford GT");
        favFords.add("Shelby GT350");
        
        List<String> favChevys = new ArrayList<>();
        favChevys.add("Corvette");
        favChevys.add("Camaro");
        
        favoriteCars.put("Ford", favFords);
        favoriteCars.put("Chevy", favChevys);
        
        List found = favoriteCars.get("Ford");
        
        System.out.println(found);
    }
          
}
