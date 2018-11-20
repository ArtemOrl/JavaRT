package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception{




        Cook amigo = new Cook("Amigo");
        amigo.setQueue(orderQueue);
        Cook makarevich = new Cook("Makarevich");
        makarevich.setQueue(orderQueue);

        Waiter waitor = new Waiter();
        amigo.addObserver(waitor);
        makarevich.addObserver(waitor);

        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(amigo);
        statisticManager.register(makarevich);


        List<Tablet> tablets = new ArrayList<>(5);
        for (int i = 1; i <= 5; i++)
        {
            Tablet tablet = new Tablet(i);
//            tablet.addObserver(amigo);
//            tablet.addObserver(makarevich);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread orderThread = new Thread(task);
        orderThread.start();

        Thread amigoThread = new Thread(amigo);
        amigoThread.start();
        Thread makarevichThread = new Thread(makarevich);
        makarevichThread.start();

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }

        orderThread.interrupt();

        boolean isNotDone = true;
        while (isNotDone)
        {
            if (orderQueue.isEmpty())
            {
                amigoThread.interrupt();
                makarevichThread.interrupt();
                isNotDone = false;
            }
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

//        Cook cook1 = new Cook("Amigo");
//        Cook cook2 = new Cook("Amigo2");
//
//        Waiter waiter = new Waiter();
//        cook1.addObserver(waiter);
//        cook2.addObserver(waiter);
//
//        List<Tablet> tabletList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Tablet tablet = new Tablet(i);
//            tablet.addObserver(new OrderManager());
//            tabletList.add(tablet);
//        }
//
//        Thread randomOrderGeneratorTaskThread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
//
//        randomOrderGeneratorTaskThread.start();
//
//        try {
//            Thread.sleep(1000);
//        }
//        catch (InterruptedException e)
//        {
//
//        }
//        randomOrderGeneratorTaskThread.interrupt();
//
//        DirectorTablet directorTablet = new DirectorTablet();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();

    }
}
