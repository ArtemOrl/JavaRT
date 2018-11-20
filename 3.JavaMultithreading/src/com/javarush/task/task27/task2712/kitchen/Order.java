package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
//    private final Tablet tablet;
//    protected List<Dish> dishes;
//    private String totalCookingTime;
//
//    public Order(Tablet tablet) throws IOException {
//        this.tablet = tablet;
//        this.dishes = ConsoleHelper.getAllDishesForOrder();
//    }
//
//    public List<Dish> getDishes() {
//        return dishes;
//    }
//
//    public Tablet getTablet()
//    {
//        return tablet;
//    }
//    @Override
//    public String toString() {
//        if (dishes == null)
//            return "";
//        return "Your order: " + dishes.toString() +" of "+  tablet.toString();
//    }
//    public boolean isEmpty() {
//        return dishes == null || dishes.isEmpty();
//    }
//    public int getTotalCookingTime() {
//        int totalDuration = 0;
//        for (Dish dish : dishes) {
//            totalDuration += dish.getDuration();
//        }
//        return totalDuration;
//    }
//    protected void initDishes() throws IOException
//    {
//        this.dishes = ConsoleHelper.getAllDishesForOrder();
//    }
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }
}
