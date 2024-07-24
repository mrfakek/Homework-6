package by.tms.HomeWork;

import java.io.*;
import java.util.Scanner;

public class FileCloner {
   private String pathToFile;
   private String pathToClone;
   private String patternToName ="clone-%s";
   private String cloneName;
   private String fileFormat;
   private String buff;
   private String fileSize;
    private String cloneSize;


    public Object startCloner() {

        System.out.println("Введите путь к файлу, который вы хотите клонировать:");
        Scanner sc = new Scanner(System.in);
        pathToFile = sc.nextLine();
        File original = new File(pathToFile);
        fileSize =Long.toString(original.length());
        buff = original.getName();
        String[] splitFileName = buff.split("\\.");
        fileFormat = splitFileName[splitFileName.length - 1];
        cloneName = patternToName.formatted(original.getName(), fileFormat);
        pathToClone = original.getPath();
        pathToClone=pathToClone.replaceAll(original.getName(), cloneName);

        File cloneOriginal = new File(pathToClone);

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(original));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(cloneOriginal)))
        {
            int currentByte;
            while ((currentByte = bufferedInputStream.read()) !=-1) {
                bufferedOutputStream.write(currentByte);
            }


            System.out.println("Клон файла создан по пути: "+getPathToClone());
            System.out.println("Имя Клона файла : "+getCloneName());
            System.out.println("Формат файла: "+getFileFormat());
            System.out.println("Размер оригинала: "+getFileSize()+" байт");

        }
        catch (IOException e) {
            System.out.println("Не удается найти указанный файл по пути :");
            getPathToFile();
        }
        return cloneOriginal;
    }

public String getPathToFile() {
        return pathToFile;
}
public String getPathToClone() {
        return pathToClone;
}
public String getCloneName() {
        return cloneName;
}
public String getFileFormat() {
        return fileFormat;
}
public String getFileSize() {
        return fileSize;
}
public String getCloneSize() {
    File cloneOriginal = new File(pathToClone);
    cloneSize=Long.toString(cloneOriginal.length());
    System.out.println("Размер клона: "+cloneSize+" байт");
        return cloneSize;
}
}
