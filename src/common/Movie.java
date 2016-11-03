package common;

import java.util.*;
import org.apache.commons.lang3.builder.CompareToBuilder;
import common.MovieByDirector;

/**
 * For practice, add the required equals, hashCode and toString methods. Then
 * add a Comparable interface for the "natural" default sort order. Remember,
 * consider what makes these objects unique? Also consider that only one
 * field can be used for sorting. What will you do?
 * 
 */


public class Movie  implements Comparable<Movie>{
    private String title;
    private String director;

    public Movie() {
    }
    
    public Movie(String title, String director){
        this.title = title;
        this.director = director;
    }
    
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.director);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + '}';
    }

    @Override
    public int compareTo(Movie o) {
       return new CompareToBuilder()
               .append(this.title, o.title)
               .append(this.director, o.director)
               .toComparison();
    }
    
    public static void main(String[] args) {
        
        // create Movie objects
        Movie m1 = new Movie("Attack from Pizza Planet", "Tommy Cook");
        Movie m2 = new Movie("Attack from Pizza Planet", "Tommy Cook");
        Movie m3 = new Movie("Dinner, it's what we eat!", "Beef Wellington");
        Movie m4 = new Movie("Why we eat: Eggs and Bacon", "Dr. Green");
    
    // addd movie objects to a HashMap
    Map<String, Movie> movies = new HashMap<>();
    movies.put("Pizza Movie", m1);
    movies.put("Pizza Movie", m2);
    movies.put("Dinner Movie", m3);
    movies.put("Why we eat movie", m4);
    
    // get and output a single movie object from the HashMap
    Movie m = movies.get("Dinner Movie");
        System.out.println("\tRetrieve a single Movie object from the HashMap..." + 
                "\nFound Movie with key 'Dinner Movie': " + m);
    
    System.out.println("\n\tUsing a keyset, get the movies by key, unsorted, unordered...");
        
    Set<String> keys = movies.keySet();
    for(String key : keys){
        Movie found = movies.get(key);
        System.out.println(found.toString());
    }
    
    System.out.println("\nUsing a keyset, get the the movies sorted by the key...");
    Map<String, Movie> movies2 = new TreeMap<>(movies);
    Set<String> keys2 = movies2.keySet();
    
    for(String key : keys2){
        Movie found = movies.get(key);
        System.out.println(found.toString());
    }
    
        System.out.println("\nSort movies by their values...");
        Collection<Movie> values = movies.values();
        
        List<Movie> sortedList = new ArrayList<>(values);
        
        Collections.sort(sortedList);
        
        for(Movie sm : sortedList){
            System.out.println(sm);
        }
        
        System.out.println("\nUsing a collection of values, get the Movies"
                + " sorted by a Comparator (director) as an alternative"
                + " to the natural order...");
        
        Collection<Movie> values2 = movies.values();
        
        List<Movie> sortedList2 = new ArrayList<>(values2);
        
        Collections.sort(sortedList2, new MovieByDirector());
        for(Movie sm2 : sortedList2){
            System.out.println(sm2);
        }
    }
}
