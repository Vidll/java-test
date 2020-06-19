package com.company;
import java.io.*;
import java.util.ArrayList;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        OpenFileAndGetArrayList();
    }

    public static void OpenFileAndGetArrayList(){
        ArrayList<String> allArray = new ArrayList<>();
        ArrayList<String> fromArray = new ArrayList<>();
        ArrayList<Float> confidenceArray = new ArrayList<>();

        try(FileReader reader = new FileReader("BaseSpam.txt")){
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            int i = 0;
            while(line != null){
                allArray = GetAll(line,allArray,i); // Получить все выбранные строки
                fromArray = GetFrom(line,fromArray,i); // Получить строки From
                confidenceArray = GetConfidence(line,confidenceArray,i); // Получить строки значений(Float) Confidence
                line = bufReader.readLine();
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        int rangeAllArray = allArray.size();
        int rangeFromArray = fromArray.size();
        int rangeConfidenceArray = confidenceArray.size();

        float averageNumber = AverageValue(confidenceArray,rangeConfidenceArray);


        //LookArray(allArray,rangeAllArray);
        //LookArray(fromArray,rangeFromArray);
        //LookNumberArray(confidenceArray,rangeConfidenceArray);
        Spam(averageNumber,fromArray,confidenceArray,rangeConfidenceArray);
    }

    public static ArrayList<String> GetAll(String line,ArrayList<String> Array,int i){
        if(line.contains("From:") || line.contains("X-DSPAM-Processed:") || line.contains("X-DSPAM-Confidence:")){
            i = Array.size();
            Array.add(i,line);
        }
        return Array;
    }
    public static ArrayList<String> GetFrom(String line,ArrayList<String> Array,int i){
        if(line.contains("From:")){
            i = Array.size();
            Array.add(i,line);
        }
        return Array;
    }
    public static ArrayList<Float> GetConfidence(String line,ArrayList<Float> Array,int i){
        if(line.contains("X-DSPAM-Confidence:")){
            i = Array.size();
            float number = GetNumbers(line);
            Array.add(i,number);
        }
        return Array;
    }

    public static float GetNumbers(String line){ //Получение числа из строки
        char[] chars = line.toCharArray();
        String numberTxt = new String("" + chars[20] + chars[21] + chars[22] + chars[23] + chars[24] + chars[25]);
        float number = Float.parseFloat(numberTxt);
        return number;
    }

    public static float AverageValue (ArrayList<Float> Array,int range){ // Получение среднего числа
        float result = 0;
        for(int i = 0; i < range;i++){
            result += Array.get(i);
        }
        result /= range;
        return result;
    }

    public static void LookArray(ArrayList<String> Array, int range){ //Просмотр массива String
        for(int i = 0; i < range; i++){
            System.out.println(Array.get(i));
        }
    }
    public static void LookNumberArray(ArrayList<Float> Array, int range){ //Просмотр массива Float
        for(int i = 0; i < range; i++){
            System.out.println(Array.get(i));
        }
    }
    public static void Spam(float averageNumber,ArrayList<String> from, ArrayList<Float> confidence, int range){
        ArrayList<String> spamArray = new ArrayList<>();
        for(int i = 0; i < range;i++){
            int a = 0;
            if(confidence.get(i) > averageNumber){
                spamArray.add(a,from.get(i));
                a++;
            }
        }

        Sorted(spamArray);
    }

    public static void Sorted(ArrayList<String> spamArray){
        int range = spamArray.size();
        int cost = 1;
        for(int a = 0; a < range;a++){
            for(int b = 0; b < range;b++){
                if(spamArray.get(a).equals(spamArray.get(b)) && a != b){
                    spamArray.remove(b);
                    cost++;
                    range = spamArray.size();
                    b--;
                }
            }
            spamArray.set(a,spamArray.get(a) + "(" + cost + ")");
            cost = 1;
        }
        range = spamArray.size();
        CreateTxt(spamArray,range);
    }

    public static void CreateTxt(ArrayList<String> spamArray, int range){
        try(FileWriter writer = new FileWriter("Spam.txt",false)){
            for(int i = 0;i < range;i++){
                writer.write(spamArray.get(i));
                writer.append('\n');
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
