package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    int N;
    String SSSSS = "Ukraine";
    @Override
    int getCountOfEggsPerMonth()
    {
        return N;  //To change body of implemented methods use File | Settings | File Templates.
    }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + SSSSS + ". Я несу " + N + " яиц в месяц.";
    }
}
