
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 109403521
 */
public abstract class Order 
{
    ReadCSV r = new ReadCSV();
    Voucher v = new Voucher();   
    
    protected String [][] SetList = r.getSetMeal();
    protected String [][] SingleList = r.getSingleMeal();
    
    protected static ArrayList<ArrayList<String>> OrderList = new ArrayList<ArrayList<String>>();
    protected static ArrayList<String> Form = new ArrayList<String>(); //0:訂單編號 1:時間 2:價格
            
    protected static int SetCounter = 0;
    protected static int SingleCounter = 0;
    protected static int OrderCounter = 0;//計算arraylist的長度
    protected static int OrderRealCounter = 0;//計算有幾筆訂單
    
    private static int init=0;

    public Order()
    {
        if(init == 0)
        {
            String a1 = String.valueOf(r.getSetMealCount());
            String a2 = String.valueOf(r.getSingleMealCount());

            SetCounter += Integer.parseInt(a1);
            SingleCounter += Integer.parseInt(a2);
            
            init = 1;
        }
    }
    
    /*
      SetList[i][0] = 商品代碼
      SetList[i][1] = 名稱
      SetList[i][2] = 副餐1
      SetList[i][3] = 副餐2
      SetList[i][4] = 飲料
      SetList[i][5] = 價格
    
      SingleList[i][0] = 商品代碼
      SingleList[i][1] = 名稱
      SingleList[i][2] = 價格
      SingleList[i][3] = 類別
      SingleList[i][4] = 早餐
    */
            
    public abstract void addOrder(String item);
    public abstract void updateOrder(int id);
    public abstract void deleteOrder(int id);
    public abstract String[] getMeal(String item);
    public abstract String[] getMealType(String item);
    public abstract String[][] getFullMeal();
    public abstract int getPrice(String type);
    public abstract int getItemID(String item);
    public abstract int updateSet();
    
    public int getOrderSum()
    {       
        int sum = 0, v_id = 0;
        
        for(int i=0;i<100;i++)
        {
            if(SetList[i][0] != null)
            {
                v_id = v.getVoucherId(SetList[i][0]);
                
                if(v_id != -1)
                {
                    sum += Integer.parseInt(SetList[i][1]) * v.Calc(v_id, Integer.parseInt(SetList[i][2]));
                }
            }
            
            if(SingleList[i][0] != null)
            {
                v_id = v.getVoucherId(SingleList[i][0]);
                
                if(v_id != -1)
                {
                    sum += Integer.parseInt(SetList[i][2]) * v.Calc(v_id, Integer.parseInt(SingleList[i][4]));
                }
            }
        }
        
        return sum;
    }
    
    public String getItemName(String type, String item)
    {
        if(type.equals("Single"))
        {
            for(int i=0;i<SingleCounter;i++)
            {
                if(SingleList[i][0].equals(item))
                {
                    //System.out.println(SingleList[i][1]);
                    return SingleList[i][1];
                }
            }
        }
        else
        {
            for(int i=0;i<SetCounter;i++)
            {
                //System.out.printf("set counter:%d\n", SetCounter);
                if(SetList[i][0].equals(item))
                {
                    return SetList[i][1];
                }
            }
        }
        
        return " ";
    }
    
    public String getItemName(String type, String item, String s_type)
    {
        if(type.equals("Single"))
        {
            for(int i=0;i<SingleCounter;i++)
            {
                //System.out.printf("all: %s %s %s %s\n",SetList[Integer.parseInt(item)-1][2],SetList[Integer.parseInt(item)-1][3],SetList[Integer.parseInt(item)-1][4],SingleList[i][0]);
                if(s_type.equals("副餐1") && SetList[Integer.parseInt(item)-1][2].equals(SingleList[i][0]))
                {
                    //System.out.printf("1: %s %s %s %s %s\n",SetList[Integer.parseInt(item)-1][2],SetList[Integer.parseInt(item)-1][3],SetList[Integer.parseInt(item)-1][4],SingleList[i][0],SingleList[Integer.parseInt(item)-1][1]);
                    return SingleList[i][1];
                }
                else if(s_type.equals("副餐2") && SetList[Integer.parseInt(item)-1][3].equals(SingleList[i][0]))
                {
                    //System.out.printf("2: %s %s %s %s %s\n",SetList[Integer.parseInt(item)-1][2],SetList[Integer.parseInt(item)-1][3],SetList[Integer.parseInt(item)-1][4],SingleList[i][0],SingleList[Integer.parseInt(item)-1][1]);
                    return SingleList[i][1];
                }
                else if(s_type.equals("飲料") && SetList[Integer.parseInt(item)-1][4].equals(SingleList[i][0]))
                {
                    //System.out.printf("d: %s %s %s %s %s\n",SetList[Integer.parseInt(item)-1][2],SetList[Integer.parseInt(item)-1][3],SetList[Integer.parseInt(item)-1][4],SingleList[i][0],SingleList[Integer.parseInt(item)-1][1]);
                    return SingleList[i][1];
                }
                else if(s_type.equals("類別"))
                {
                    return SingleList[Integer.parseInt(item)-1][3];
                }
                else if(s_type.equals("早餐"))
                {
                    return SingleList[Integer.parseInt(item)-1][4];
                }
            }
            
        }
        
        return "-";
    }
    
    public String getItemCode(String type, String item)
    {
        if(type.equals("Single"))
        {
            for(int i=0;i<SingleCounter;i++)
            {
                if(SingleList[i][1].equals(item))
                {
                    //System.out.println(SingleList[i][1]);
                    return String.valueOf(i+1);
                }
            }
        }
        else
        {
            for(int i=0;i<SetCounter;i++)
            {
                if(SetList[i][1].equals(item))
                {
                    return String.valueOf(i+1);
                }
            }
        }
        
        return " ";
    }
    
    /*public String [][] getOrderItem()
    {
        String [][] output = new String[200][4];
        int counter=0;
        
        for(int i=0;i<100;i++)
        {
            if(SetList[i][0] != null)
            {
                output[counter][0] = SetList[i][0];
                output[counter][1] = SetList[i][1];
                output[counter][2] = SetList[i][2];
                output[counter][3] = SetList[i][3];
                
                counter++;
            }
            
            if(SingleList[i][0] != null)
            {
                output[counter][0] = SingleList[i][0];
                output[counter][1] = SingleList[i][1];
                output[counter][2] = SingleList[i][2];
                output[counter][3] = SingleList[i][3];
                
                counter++;
            }
        }
        
        return output;
    }*/
}
