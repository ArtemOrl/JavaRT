package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit()
    {
        Map<String, Double> statMap = StatisticManager.getInstance().getAdvertisementProfit();
        Double total = 0D;
        for (Map.Entry<String, Double> entry : statMap.entrySet())
        {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", entry.getKey(), entry.getValue()));
            total+=entry.getValue();
        }
        if (total > 0)
        {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
        }
    }

    public void printCookWorkloading()
    {
        Map<String, Map<String, Integer>> statMap = StatisticManager.getInstance().getCookWorkloading();
        for (Map.Entry<String, Map<String, Integer>> entryMap : statMap.entrySet())
        {
            //Выводим дату
            ConsoleHelper.writeMessage(entryMap.getKey());
            for (Map.Entry<String, Integer> entry : entryMap.getValue().entrySet())
            {

                //Выводим повара
                String cookName = entry.getKey();
                int workTime = (int) Math.ceil(entry.getValue()/60.0);
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, workTime));
            }
        }
    }

//    public void printActiveVideoSet() {
//        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getVideos(true);  //getVideos();  //getVideosActive();
//
//        Map.Entry[] videoArray = videos.entrySet().toArray(new Map.Entry[0]);
//        Arrays.sort(videoArray, new Comparator<Map.Entry>() {
//            @Override
//            public int compare(Map.Entry o1, Map.Entry o2) {
//                return ((String)o1.getKey()).compareToIgnoreCase((String)o2.getKey());
//            }
//        });
//
//        //for (Map.Entry<String, Integer> item : videos.entrySet()) {
//        for (Map.Entry<String, Integer> item : videoArray) {
//            ConsoleHelper.writeMessage(item.getKey() + " - " + item.getValue());
//        }
//    }
//
//    public void printArchivedVideoSet() {
//        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getVideos(false);  //getVideos();  //getVideosArchive();
//
//        Map.Entry[] videoArray = videos.entrySet().toArray(new Map.Entry[0]);
//        Arrays.sort(videoArray, new Comparator<Map.Entry>() {
//            @Override
//            public int compare(Map.Entry o1, Map.Entry o2) {
//                return ((String)o1.getKey()).compareToIgnoreCase((String)o2.getKey());
//            }
//        });
//
//        //for (Map.Entry<String, Integer> item : videos.entrySet()) {
//        for (Map.Entry<String, Integer> item : videoArray) {
//            ConsoleHelper.writeMessage(item.getKey());
//        }
//    }

    public void printActiveVideoSet()
    {
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getVideoSet(true);
        for (Advertisement ad : activeVideoSet)
        {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    public void printArchivedVideoSet()
    {
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getVideoSet(false);
        for (Advertisement ad : activeVideoSet)
        {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
