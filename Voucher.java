/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 109403521
 */

import java.util.ArrayList;
import java.util.List;

public class Voucher 
{
    //ArrayList<Integer> arrlist = new ArrayList<Integer>(5);
    private static ArrayList<ArrayList<String>> voucher = new ArrayList<ArrayList<String>>();
    //private static String [][] voucher = new String[100][5];
    private static int counter=3;
    private static int initV=0;
    
    public Voucher()
    {
        if(initV == 0)
        {
            initVoucher();
        }
    }
   
    /* voucher[id][0] 優惠方案名稱
       voucher[id][1] 打折(例如：85折)
       voucher[id][2] 均一價(例如：49元)
       voucher[id][3] 扣x元(例如：折5元)
       voucher[id][4] 哪一項商品要做促銷(套餐、附餐皆可)
    */
    
    public void initVoucher()
    {
        voucher.add(new ArrayList<String>());
        voucher.get(0).add("夏季限定玉米湯");
        voucher.get(0).add("85");
        voucher.get(0).add("-1");
        voucher.get(0).add("-1");
        voucher.get(0).add("10");
        
        voucher.add(new ArrayList<String>());
        voucher.get(1).add("好想吃薯餅");
        voucher.get(1).add("-1");
        voucher.get(1).add("65");
        voucher.get(1).add("-1");
        voucher.get(1).add("B");
        
        voucher.add(new ArrayList<String>());
        voucher.get(2).add("大麥克特賣會");
        voucher.get(2).add("-1");
        voucher.get(2).add("-1");
        voucher.get(2).add("2");
        voucher.get(2).add("9");
           
        initV = 1;
        
    }
    
    public void addVoucher(String name, int type, int discount,String stock)
    {
        voucher.add(new ArrayList<String>());
        voucher.get(counter).add(name);
        
        if(type == 1)
        {
            voucher.get(counter).add(String.valueOf(discount));
            voucher.get(counter).add("-1");
            voucher.get(counter).add("-1");
        }
        else if(type == 3)
        {
            voucher.get(counter).add("-1");
            voucher.get(counter).add(String.valueOf(discount));
            voucher.get(counter).add("-1");
        }
        else if(type == 3)
        {
            voucher.get(counter).add("-1");
            voucher.get(counter).add("-1");
            voucher.get(counter).add(String.valueOf(discount));
        }
        
        voucher.get(counter).add(stock);
        
        counter++;
    }
    
    public void updateVoucher(int v_id, String name, int type, int discount)
    {
        voucher.get(v_id).set(type, String.valueOf(discount));
    }
    
    public void deleteVoucher(int v_id)
    {
        //System.out.println(v_id);
        voucher.remove(v_id);
    }
    
    public String[][] getFullVoucher()
    {
        String[][] array = new String[voucher.size()][5];
        for (int i = 0; i < voucher.size(); i++)
        {
            List<String> row = voucher.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }
        
        return array;
    }
    
    public String[] getVoucher(int v_id)
    {
        String [] str = new String[4];
        
        str[0] = voucher.get(v_id).get(0);
        str[1] = voucher.get(v_id).get(1);
        str[2] = voucher.get(v_id).get(2);
        str[3] = voucher.get(v_id).get(3);
        
        return str;
    }
    
    public int getVoucherType(int v_id)
    {
        if(Integer.parseInt(voucher.get(v_id).get(1)) != -1 )
        {
            return 1;
        }
        else if(Integer.parseInt(voucher.get(v_id).get(2)) != -1 )
        {
            return 2;
        }
        else if(Integer.parseInt(voucher.get(v_id).get(3)) != -1 )
        {
            return 3;
        }
        
        return 0;
    }
    
    public int getVoucherId(String stock)
    {
        for(int i=0;i<voucher.size();i++)
        {
            if(voucher.get(i).get(4).equals(stock))
            {
               return i;
            }
        }
        
        return -1;
    }
    
    public int Calc(int v_id, int price)
    {
        int calc=0;
        
        if(Integer.parseInt(voucher.get(v_id).get(1)) != -1 )
        {
            calc = price * Integer.parseInt(voucher.get(v_id).get(1)) / 100;//打折
        }
        else if(Integer.parseInt(voucher.get(v_id).get(2)) != -1)
        {
            calc = Integer.parseInt(voucher.get(v_id).get(2));//均一價
        }
        else if(Integer.parseInt(voucher.get(v_id).get(3)) != -1)
        {
            calc = price - Integer.parseInt(voucher.get(v_id).get(3));//扣x元
        }
        
        return calc;
    }
    
}