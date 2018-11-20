package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/Users/a1/Desktop/Training"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString); // создаем объект типа URL
        InputStream inputStream = url.openStream(); // открываем поток для объекта URL
        Path tempFile = Files.createTempFile("tmp-", ".tmp"); // создаем временный файл
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING); // копируем данные из потока во временный файл
        // через опцию задаем замещение файла если такой уже существует
        String fileName = Paths.get(url.getFile()).getFileName().toString(); // получаем конечное имя файла
        Files.createDirectories(downloadDirectory); // если нужно создаем директории в пути куда файл нужно сохранить
        Path target = downloadDirectory.resolve(fileName);
        Files.move(tempFile, target, StandardCopyOption.REPLACE_EXISTING); //перемещаем временный файл в конечную директорию
        return target;
    }
}
