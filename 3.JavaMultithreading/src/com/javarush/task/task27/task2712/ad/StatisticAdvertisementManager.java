package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {

    private static  StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private  AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }


    public Map<String, Integer> getVideos(boolean active) {
        Map<String, Integer> res = new TreeMap<>();  //(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement != null) {
                if (res.containsKey(advertisement.getName())) {
                    res.put(advertisement.getName(), res.get(advertisement.getName()) + advertisement.getHits());
                }
                else {
                    res.put(advertisement.getName(), advertisement.getHits());
                }
            }
        }
        for (Iterator<Map.Entry<String, Integer>> it = res.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> item = it.next();
            if (active && item.getValue() == 0) {
                it.remove();
            }
            else if (!active && item.getValue() > 0) {
                it.remove();
            }
        }
        return res;
    }
    public List<Advertisement> getVideoSet(boolean isActive)
    {
        List<Advertisement> videoSet = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list())
        {
            if (!isActive && ad.getHits() == 0)
            {
                videoSet.add(ad);
            }
            if (isActive && ad.getHits() != 0)
            {
                videoSet.add(ad);
            }
        }
        Collections.sort(videoSet, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return videoSet;
    }
}
