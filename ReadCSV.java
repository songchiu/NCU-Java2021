import java.io.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.text.*;

/**
 *
 * @author 109403521
 */

public class ReadCSV 
{
    private String Filename;//定義變數來存取屆時要讀取哪個CSV
    private static String[][] SingleMeal = new String[100][5];
    private static String[][] SetMeal = new String[100][6];
    private static int SingleCounter = 0;//計算附餐有幾列資料輸入
    private static int SetCounter = 0;//計算套餐有幾列資料輸入
    private static int set_init = 0;
    private static int single_init = 0;
    
    public ReadCSV()
    {
        /*if(set_init == 0 && Filename.equals("Set_meal.csv"))
        {
            setCSV(Filename);
            set_init = 1;
        }
        if(single_init == 0 && Filename.equals("Single_meal.csv"))
        {
            setCSV(Filename);
            single_init = 1;
        }*/
        
        if(single_init == 0)
        {
            setCSV("C://java//Set_meal.csv");
            setCSV("C://java//Single_meal.csv");
            single_init = 1;
        }
    }
    
    public void setCSV(String Filename)
    {
        this.Filename = Filename;
        int first_line = 0;
        
        try 
        {
            /*FileReader fr = new FileReader(Filename);
            BufferedReader reader = new BufferedReader(fr,"gbk");*/
            
            DataInputStream in = new DataInputStream(new FileInputStream(new File(Filename)));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"utf-8"));

            String line = null;//定義line變數來逐行讀取csv裡的資料
            
            while((line=reader.readLine()) != null)
            {
                if(first_line == 0)
                {
                    first_line++;
                    continue;
                }
                
                String item[] = line.split(",");//把各個資料分割出來

                if(Filename.equals("C://java//Set_meal.csv"))
                {
                    //套餐
                    SetMeal[SetCounter][0] = item[0].trim();
                    SetMeal[SetCounter][1] = item[1].trim();
                    SetMeal[SetCounter][2] = item[2].trim();
                    SetMeal[SetCounter][3] = item[3].trim();
                    SetMeal[SetCounter][4] = item[4].trim();
                    SetMeal[SetCounter][5] = item[5].trim();
                    
                    SetCounter++;
                }
                else
                {
                    //附餐
                    SingleMeal[SingleCounter][0] = item[0].trim();
                    SingleMeal[SingleCounter][1] = item[1].trim();
                    SingleMeal[SingleCounter][2] = item[2].trim();
                    SingleMeal[SingleCounter][3] = item[3].trim();
                    SingleMeal[SingleCounter][4] = item[4].trim();
                        
                    SingleCounter++;
                }
            }

        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    public String[][] getSingleMeal()
    {
        return SingleMeal;
    }
    
    public int getSingleMealCount()
    {
        return SingleCounter;
    }
    
    public String[][] getSetMeal()
    {
        return SetMeal;
    }
    
    public int getSetMealCount()
    {
        return SetCounter;
    }
}
