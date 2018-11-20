package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("f1", "Pupkin");
        map.put("f2", "Vasilov");
        map.put("f3", "Smith");
        map.put("f4", "Ericman");
        map.put("f5", "Stellov");
        map.put("f6", "Testerov");
        map.put("f7", "Pushkin");
        map.put("f8", "Alexov");
        map.put("f9", "Alexov");
        map.put("f10", "Alexov");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        //HashMap<String, String> map1 = new HashMap<>(map);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();

        //работает boolean только с обычными массивами а не коллекциями

//        for (HashMap.Entry<String, String> element: map.entrySet()){
//            String name = element.getValue();
//            if (!(set.add(name))) removeItemFromMapByValue(map, name);
//
//
//        }

        String[] names = map.values().toArray(new String[0]);
        for (String n : names){

            if (!(set.add(n))) removeItemFromMapByValue(map, n);


        }

//        String[] names = map.values().toArray(new String[0]);
//
//        HashSet<String> set = new HashSet<>();
//        for (String n: names) if (!set.add(n)) removeItemFromMapByValue(map, n);

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
//        HashMap<String, String> z1 = createMap();
//        System.out.println(z1);
//        removeTheFirstNameDuplicates(z1);
//        System.out.println(z1);
    }
}
/*Кровавое решение задачи "Нам повторы не нужны":

Основная идея:
Создаем копию основного мапа, от которой отрезаем по одному элементу при посмотре в foreach основного мапа.
После экзекуции смотрим есть ли элемент основного мапа в урезанной копии. Если есть кидаем в множество(множество же ж содержит только уникальные значения).
Все элементы из множества в цикле передаем в метод убийства дубликатов имен.
Happy end.

Памяти, конечно,  тратится - аж жуть. */
/*
public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {

    HashMap<String, String> copymap = new HashMap<String, String>(map);
    Set<String> set = new HashSet<>();
    for (Map.Entry<String, String> pair : map.entrySet()) {
        copymap.remove(pair.getKey());
        if (copymap.containsValue(pair.getValue())) set.add(pair.getValue());
    }
    for (String s: set) removeItemFromMapByValue(map,s);
}


String[] names = map.values().toArray(new String[0]);
HashSet<String> tmp = new HashSet<>();
for (String s : names) {
    if (tmp.contains(s)) removeItemFromMapByValue(map,s);
    else tmp.add(s);
}

String[] names = map.values().toArray(new String[0]);
HashSet<String> tmp = new HashSet<>();
for (String s : names)  if (!tmp.add(s)) removeItemFromMapByValue(map,s);


В Хэш-сет нельзя положить 2 одинаковых элемента. Если вы добавляете что-то в хэш-сет в 1 раз, то это "что-то"
добавляется, а метод .add возвращает True. Если вы это "что-то" пытаетесь добавиь второй раз , то оно не добавляется
(но старое в сете остается, так как добавлено ранее), а метод .add возвращает false (то есть типа "Добавить не смог,
оно уже там").  Ну остальное вроде прозрачно...  Если при добавлении  в tmp-сет выскочило false, это повтор и мы его
из основной мапы удаляем.
 */