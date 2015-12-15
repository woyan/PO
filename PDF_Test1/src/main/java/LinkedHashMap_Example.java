import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class LinkedHashMap_Example {
    public static void main(String[] args){
    	// Map representing (Company, share price) as (key, value) pair
    	
    		        Map<String, List<String>> linkedHashMap = new LinkedHashMap<String, List<String>>();
    		        List<String> strings1 = new ArrayList();
    		        List<String> strings2 = new ArrayList();
    		        List<String> strings3 = new ArrayList();
    		        List<String> strings4 = new ArrayList();
    		        List<String> strings5 = new ArrayList();
    		        strings1.add("001");
    		        strings2.add("21");
    		        strings3.add("math");
    		        strings3.add("informatik");
    		        strings4.add("2");
    		        
    	
    		        linkedHashMap.put("apple",strings1 );
    	
    		        linkedHashMap.put("Sony", strings2);
    	
    		        linkedHashMap.put("Dell",strings3);
    	
    		        linkedHashMap.put("HP", strings4);
    	
    		        
    		        System.out.println(MyDrawString.longest_string(strings3));
    		        // Displaying the contents of the LinkedHashMap
    	
    		        System.out.println("Contents of LinkedHashMap : " + linkedHashMap);
    	
    		 
    	
    		        // One of the ways of iterating over the map
    	
    		        // Notice the order of the elements is same as the order of insertion
    	
    		        System.out.println("\nValues of map after iterating over it : ");
    	            for (String key : linkedHashMap.keySet()) {
    	               System.out.println(key + ":\t" + linkedHashMap.get(key));
    
    		        }
    	
    	            List<String> keys_List = new ArrayList();
    	    		for (String key : linkedHashMap.keySet()) {
    		               keys_List.add(key);
    		               System.out.println(key + ":\t" + linkedHashMap.get(key));
    	            }
    	    		String[] keys = new String[keys_List.size()];
    	    		keys = keys_List.toArray(keys);

    	    		for(String s : keys)
    	    		    System.out.println(s);
    	
    		        // Getting the value for a particular key
    	
    		        System.out.println("\nThe current share price of HP is : "
    	
    		                + linkedHashMap.get("HP"));
    	
    		        // Getting the size of the LinkedHashMap
    	
    		        System.out
    	
    		                .println("\nThe size of the LinkedHashMap is : " + linkedHashMap.size());
    	
    		        // Checking whether the LinkedHashMap is empty
    
    		        System.out.println("\nIs LinkedHashMap empty? : " + linkedHashMap.isEmpty());
    	
    		 
    
    		        //Checking whether Map contains a particular key or value
    
    		        System.out.println("\nLinkedHashMap contains Sony as key? : " + linkedHashMap.containsKey("Sony"));
    	
    		        System.out.println("LinkedHashMap contains 999.0 as value? : " + linkedHashMap.containsValue(999.0));
    	
    		        // Removing a particular value
    	        System.out.println("\nRemove entry for Dell : " + linkedHashMap.remove("Dell"));
    	
    		        System.out.println("Content of LinkedHashMap removing Dell: " + linkedHashMap);
    	
    		        // Clearing the LinkedHashMap
    
    		        linkedHashMap.clear();
   
    		        System.out.println("\nContent of LinkedHashMap after clearing: " + linkedHashMap);
    	
    }
}
