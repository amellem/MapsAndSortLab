package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.builder.CompareToBuilder;

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
        System.out.println("\tRetrieve a single Movie object from the HashMap...");
        System.out.println("Found Movie with key 'Dinner Movie': " + m);
    
    System.out.println("\n\tUsing a keyset, get the movies by key, unsorted, unordered...");
        
    Set<String> keys = movies.keySet();
    for(String key : keys){
        Movie found = movies.get(key);
        System.out.println(found.toString());
    }
    }
}
