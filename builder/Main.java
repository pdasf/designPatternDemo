package builder;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("vegetarian meal:");
		MealBuilder.vegMeal().showItems();

		System.out.println("meat meal:");
		MealBuilder.meatMeal().showItems();
	}
}

class MealBuilder{
	public static Meal vegMeal(){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	public static Meal meatMeal(){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}

interface Packing{
	String pack();
}

class Wrapper implements Packing{
	@Override
	public String pack() {
		return "wrapper";
	}
}

class Bottle implements Packing{
	@Override
	public String pack() {
		return "bottle";
	}
}

interface Item {
	String name();
	Packing packing();
	float price();
	default String printMsg(){
		return name()+" "+packing().pack()+" "+price();
	}
}

abstract class Burger implements Item{
	@Override
	public Packing packing(){
		return new Wrapper();
	}
}

class VegBurger extends Burger{

	@Override
	public String name() {
		return "veg burger";
	}

	@Override
	public float price() {
		return 6.2F;
	}
}

class ChickenBurger extends Burger{

	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 10.5F;
	}
}

abstract class ColdDrink implements Item{
	@Override
	public Packing packing() {
		return new Bottle();
	}
}

class Coke extends ColdDrink{

	@Override
	public String name() {
		return "coke";
	}

	@Override
	public float price() {
		return 2.5F;
	}
}

class Pepsi extends ColdDrink{

	@Override
	public String name() {
		return "pepsi";
	}

	@Override
	public float price() {
		return 2.5F;
	}
}

class Meal {
	private List<Item> items;
	private float cost;

	public Meal(){
		this.items = new ArrayList<>();
	}

	public void addItem(Item item){
		this.items.add(item);
		this.cost += item.price();
	}

	public float getCost(){
		return this.cost;
	}

	public void showItems(){
		items.forEach(item ->{
			System.out.println(item.printMsg());
		});
		System.out.println("Total cost:"+this.getCost());
	}
}