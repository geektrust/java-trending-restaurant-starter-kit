import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RestaurantDataLoader {
    public static List<Restaurant> loadRestaurants(String filename) throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filename));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object jsonObj : jsonArray) {
                JSONObject restaurantJson = (JSONObject) jsonObj;
                String name = (String) restaurantJson.get("name");
                double averageRating = Double.parseDouble((String) restaurantJson.get("averageRating"));
                int totalReviews = Integer.parseInt((String) restaurantJson.get("totalReviews"));
                int numberOfReviewsInLast30Days = Integer.parseInt((String) restaurantJson.get("numberOfReviewsInLast30Days"));
                Restaurant restaurant = new Restaurant(name, averageRating, totalReviews, numberOfReviewsInLast30Days);
                restaurants.add(restaurant);
            }
            return restaurants;
        } 
        catch (NumberFormatException e) {
            throw e;
        }
        catch (IOException e) {
            throw e;
        }
        
    }
}
