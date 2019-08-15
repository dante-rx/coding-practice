package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Getting unique meals from a List<Meal> meals
 * @author nagendra
 *
 */
public class UniqueMeals {

	public static void main(String[] args) {
		
		
		List<Meal> meals = new ArrayList<Meal>();
		meals.add(new Meal("Chips and Salsa", new ArrayList<String>( Arrays.asList(new String[]{"Chips","Salsa"})  )));
		meals.add(new Meal("Hot Chipt", new ArrayList<String>( Arrays.asList(new String[]{"Salsa","Chips"})  )));



		meals.add(new Meal("Southwestern Eggrolls", new ArrayList<String>( Arrays.asList(new String[]{"Chicken","Lettuce","Hot Sauce","Cabbage"})  )));
		meals.add(new Meal("Jack Sandwich", new ArrayList<String>( Arrays.asList(new String[]{"Cheddar Jack Cheese","Lettuce","Onion","Mayo"})  )));
		
		meals.add(new Meal("Bacon Simplicity", new ArrayList<String>( Arrays.asList(new String[]{"Patty","Bacon","Lettuce"})  )));
		
		
		
		meals.add(new Meal("Bacon Burger", new ArrayList<String>( Arrays.asList(new String[]{"Lettuce","Patty","Bacon"})  )));
		
		meals.add(new Meal("Deluxe Delight", new ArrayList<String>( Arrays.asList(new String[]{"Mayo" ,"Lettuce","Cheddar Jack Cheese","Onion"})  )));
		
		meals.add(new Meal("Mild Bird", new ArrayList<String>( Arrays.asList(new String[]{"Chicken Patty","Lettuce","Mild Sauce","Onion","Tomato"})  )));
		meals.add(new Meal("Eggroll Delight", new ArrayList<String>( Arrays.asList(new String[]{"Lettuce" ,"Hot Sauce" ,"Cabbage", "Chicken"})  )));
		
		meals.add(new Meal("Hot Roller", new ArrayList<String>( Arrays.asList(new String[]{"Tomato" ,"Onion" ,"Hot Sauce" ,"Chicken Patty" ,"Lettuce"})  )));
		meals.add(new Meal("Hella Chips", new ArrayList<String>( Arrays.asList(new String[]{"Chips","Salsa"})  )));
		
		
		System.out.println(getUniqueMealCount2(meals));
		System.out.println(getUniqueMealCount3(meals));

	}
	
	/**
	 * This approcha is not going to work.
	 * @param meals
	 * @return
	 */
    public static int getUniqueMealCount(List<Meal> meals) {
        Comparator<Meal> mycomp = new Comparator<Meal>(){

            public int compare(Meal a, Meal b ){
                List<String> list1 =a.getIngredients();
                List<String> list2 =b.getIngredients();

                Set<String> set1 = new HashSet<>(list1);
                Set<String> set2 = new HashSet<>(list2);
                if( set1.size()  == set2.size() ){
                	if (set1.equals(set2)) {
                		return 0;
                	}else {
                		return 1;
                	}
                }
                return 1;
            }
        };
        Set<Meal> set = new TreeSet<>(mycomp);
        
        for (Meal m: meals){
        	set.add(m);
        	
        }
        for( Meal m: set) {
        	System.out.println(m.getIngredients());
        }
    	

    	

        return set.size();
    }
    
    
    /**
     * Optimal Approach
     * @param meals
     * @return
     */
    public static int getUniqueMealCount3(List<Meal> meals) {
    	Map< Set<String> , Integer>  map = new HashMap<>();
    	
    	for(Meal m:  meals) {
    		Set<String> set = new HashSet<String>(m.ingredients);
    		map.put(set, 1);
    	}
    	
    	return map.size();
    }
    
    
    /**
     * OKAY Approach
     * @param meals
     * @return
     */
    public static int getUniqueMealCount2(List<Meal> meals) {
    	Set<MyMeal> set = new HashSet<MyMeal>();
    	
    	for (Meal m: meals){
    		set.add(new MyMeal(m.getName(), m.getIngredients()));
    	}
    	
    	for (Meal m : set) {
    		System.out.println(m.getIngredients());
    	}
    	
    	return set.size();
    }

}

class MyMeal extends Meal{
	
	public MyMeal(String name, List<String> ingredients) {
       super(name, ingredients);
    }
	
	@Override
	public boolean equals(Object obj) {
		Meal meal2 = (Meal)obj;
		
		Set<String> set1 = new HashSet<>(this.ingredients);
		Set<String> set2 = new HashSet<>(meal2.ingredients);
		return set1.equals(set2);
		
	}
	
	@Override 
	public int hashCode() {
		return 0;
	}
}

class Meal {
    String name;
    List<String> ingredients;

    public Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }
}