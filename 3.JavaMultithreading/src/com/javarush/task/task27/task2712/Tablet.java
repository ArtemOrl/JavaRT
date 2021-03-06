package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet /*extends Observable*/ {
    final int number;
    private static Logger logger=Logger.getLogger(Tablet.class.getName());

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }


    public void createTestOrder()
    {
        try
        {
            TestOrder order = new TestOrder(this);
            printOrderAndShowAds(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }
    public Tablet(int number) {
        this.number = number;
    }
    public Order createOrder(){
        Order order;
        try
        {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
//            setChanged();
//            notifyObservers(order);

            try {
                AdvertisementManager advertisementManager=new AdvertisementManager(order.getTotalCookingTime()*60);
                advertisementManager.processVideos();
            }
            catch (NoVideoAvailableException e)
            {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
        return order;
    }

    public void printOrderAndShowAds(Order order)
    {
        ConsoleHelper.writeMessage(order.toString());
        AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
        try
        {
            advertisementManager.processVideos();
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        queue.add(order);
    }
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
