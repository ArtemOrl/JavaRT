package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values())
            {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data)
        {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getAllRowsOfType(EventType eventType)
        {
            return storage.get(eventType);
        }
    }

    private Set<Cook> cooks = new HashSet<>();

    private StatisticStorage statisticStorage = new StatisticStorage();

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public Set<Cook> getCooks() {
        return cooks;
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    public void register(Cook cook)
    {
        cooks.add(cook);
    }

    //Вычисляет статистику по доходу с рекламы
    public Map<String, Double> getAdvertisementProfit()
    {
        //Получаем список данных из хранилища
        List<EventDataRow> videos = statisticStorage.getAllRowsOfType(EventType.SELECTED_VIDEOS);
        //Объект для форматирования даты
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //Создаем карту, в которую будем складывать результаты
        Map<String, Double> resultMap = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow video : videos)
        {
            //Приводим запись события в нужную форму
            VideoSelectedEventDataRow videoRow = (VideoSelectedEventDataRow)video;
            //Получаем дату из записи
            String dateKey = simpleDateFormat.format(videoRow.getDate());
            //Если запись с датой уже есть
            if (resultMap.containsKey(dateKey))
            {
                //Обновляем запись с новой суммной
                resultMap.put(dateKey, resultMap.get(dateKey) + (videoRow.getAmount() / 100.00));
            }
            else
            {
                //Иначе добавляем новую запись
                resultMap.put(dateKey, videoRow.getAmount() / 100.00);
            }
        }
        return resultMap;
    }

    //Вычисляет статистику по загрузке поваров
    public Map<String, Map<String, Integer>> getCookWorkloading()
    {
        //Получаем список данных из хранилища
        List<EventDataRow> cookedOrders = statisticStorage.getAllRowsOfType(EventType.COOKED_ORDER);
        //Объект для форматирования даты
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //Создаем карту, в которую будем складывать результаты
        //Группировка по дате, вторая группировка по повару.
        Map<String, Map<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow cookedOrder : cookedOrders)
        {
            //Приводим запись события в нужную форму
            CookedOrderEventDataRow orderRow = (CookedOrderEventDataRow) cookedOrder;
            //Получаем дату из записи
            String dateKey = simpleDateFormat.format(orderRow.getDate());
            //Получаем имя повара
            String cookName = orderRow.getCookName();
            //Получаем время работы повара
            Integer workTime = orderRow.getTime();
            //Если время > 0, то обрабатываем запись.
            //Если запись с датой уже есть
            if (workTime > 0) {
                if (resultMap.containsKey(dateKey))
                {
                    //Получаем все записи с этой датой
                    Map<String, Integer> cooks = resultMap.get(dateKey);
                    //Если запись с поваром уже есть
                    if (cooks.containsKey(cookName))
                    {
                        //Обновляем запись с новой суммой времени
                        cooks.put(cookName, cooks.get(cookName) + orderRow.getTime());
                    }
                    else
                    {
                        //Иначе добавляем нового повара
                        cooks.put(cookName, orderRow.getTime());
                    }
                }
                else {
                    //Если записи с датой нет, то добавляем новую запись
                    resultMap.put(dateKey, new TreeMap<>());
                    resultMap.get(dateKey).put(cookName, orderRow.getTime());
                }
            }
        }
        return resultMap;
    }
}
