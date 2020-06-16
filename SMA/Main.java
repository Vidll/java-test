import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество значений:");

        int range = in.nextInt();
	    float[] NumberArray = new float[range];
	    float[] newNumberArray = new float[range];

	    NumberArray = RandomNumbersArray(range);// Массив чисел
        newNumberArray = SMA(NumberArray,range); // Массив чисел скользящей средней

        System.out.println("Random numbers:");
        LookArray(NumberArray,range);
        System.out.println("__________________________________________________");
        System.out.println("SMA numbers:");
	    LookArray(newNumberArray,range);

	    CreateAndWriteOnFile(newNumberArray,NumberArray);
    }

    public static void LookArray(float Array[],int range){
        for(int i = 0; i < range; i++){
            System.out.println(Array[i]);
        }
    }

    public static float[] RandomNumbersArray(int range){
        float[] randomSmaArray = new float[range];
        for(int a = 0; a < range; a++){
            randomSmaArray[a] = (float)Math.random() * 10;
        }
        return randomSmaArray;
    }

    public static float[] SMA(float[] Array, int range){
        float[] smaArray = new float[range];
        float result = 0;

        for(int i = 0; i < range; i++){
            if(i >= 2){
                for(int a = 0; a < i;a++){
                    result += Array[a];
                }
                result = result / (i+1);
                smaArray[i] = result;
                result = 0;
            }else{
                smaArray[i] = Array[i];
            }
        }
        return smaArray;
    }

    public static void CreateAndWriteOnFile(float[] smaArray, float[] smaNumbers){
        try(FileWriter writer = new FileWriter("SMA.txt",false)){
            String numbers = Arrays.toString(smaNumbers);
            String sma = Arrays.toString(smaArray);
            writer.write(numbers);
            writer.append("\n");
            writer.write(sma);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
