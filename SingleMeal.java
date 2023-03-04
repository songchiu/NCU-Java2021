
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
public class SingleMeal extends Order
{
    /*
      SingleList[i][0] = 商品代碼
      SingleList[i][1] = 名稱
      SingleList[i][2] = 價格
      SingleList[i][3] = 類別
      SingleList[i][4] = 早餐
    */
    
    public void addOrder(String id, String item, int price, String type, String Breakfast)
    {
        
    }
    
    public void addSingle(String item, String price, String type, String Breakfast)
    {
        SingleList[SingleCounter][0] = String.valueOf(SingleCounter+1);
        SingleList[SingleCounter][1] = item;
        SingleList[SingleCounter][2] = String.valueOf(price);
        SingleList[SingleCounter][3] = type;
        SingleList[SingleCounter][4] = Breakfast;
        
        SingleCounter++;
    }
    
    public void updateOrder(String id, String item, int price, String type, String Breakfast)
    {
        
    }
    
    public void updateSingle(String id, String item, String price, String type, String Breakfast)
    {
        SingleList[Integer.parseInt(id)][1] = item;
        SingleList[Integer.parseInt(id)][2] = price;
        SingleList[Integer.parseInt(id)][3] = type;
        SingleList[Integer.parseInt(id)][4] = Breakfast;
    }
    
    public void deleteOrder(String id)
    {
        SingleList[Integer.parseInt(id)][0] = null;
        SingleList[Integer.parseInt(id)][1] = null;
        SingleList[Integer.parseInt(id)][2] = null;
        SingleList[Integer.parseInt(id)][3] = null;
        SingleList[Integer.parseInt(id)][4] = null;
    }

    public String [] getMealType(String type)
    {
        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("-");//沒有那個餐點時，輸出-
               
        for(int i=0;i<SingleCounter;i++)
        {
            if(SingleList[i][3].equals(type) || type.equals("ALL"))
            {
                str1.add(SingleList[i][1]);
            }
        }
        
        String[] str = str1.toArray(new String[str1.size()]);
        
        return str;
    }
    
    public String [] getMealType(String type1, String type2)
    {
        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("-");//沒有那個餐點時，輸出-
               
        for(int i=0;i<SingleCounter;i++)
        {
            if(SingleList[i][3].equals(type1) || SingleList[i][3].equals(type2))
            {
                str1.add(SingleList[i][1]);
            }
        }
        
        String[] str = str1.toArray(new String[str1.size()]);
        
        return str;
    }
    
    public int getPrice(String type)
    {
        for(int i=0;i<SingleCounter;i++)
        {
            if(SingleList[i][0].equals(type))
            {
                return Integer.parseInt(SingleList[i][2]);
            }
        }
        return 0;
    }
    
    public int getItemID(String item)
    {
        for(int i=0;i<SingleCounter;i++)
        {
            if(SingleList[i][0].equals(item))
            {
                return i;
            }
        }
        return -1;
    }
    
    
    public String getItemName(String item)
    {
        for(int i=0;i<SingleCounter;i++)
        {
            if(SingleList[i][0].equals(item))
            {
                return SingleList[i][1];
            }
        }
        return "-1";
    }
    
    public String getItemCode(String item)
    {
        for(int i=0;i<SingleCounter;i++)
        {
            if(SingleList[i][1].equals(item))
            {
                return SingleList[i][0];
            }
        }
        return "-1";
    }
    
    public String [][] getFullMeal()
    {
        return SingleList;
    }

    @Override
    public void addOrder(String item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getMeal(String item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
