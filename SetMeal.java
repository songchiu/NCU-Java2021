
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 109403521
 */
public class SetMeal extends Order
{
    SingleMeal s = new SingleMeal();
    /*
      SetList[i][0] = 商品代碼
      SetList[i][1] = 名稱
      SetList[i][2] = 副餐1
      SetList[i][3] = 副餐2
      SetList[i][4] = 飲料
      SetList[i][5] = 價格
    */
    public int addForm()
    {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        
        Form.add(String.valueOf(OrderRealCounter+1));
        Form.add(String.valueOf(ft));//時間
        Form.add(String.valueOf("0"));//總額
        
        OrderRealCounter++;
        
        return OrderRealCounter;
    }
    public void addOrder(String item, String type)
    {
        OrderList.add(new ArrayList<String>());
       
        if(type.equals("套餐"))
        {
            OrderList.get(OrderCounter).add("套餐");
            OrderList.get(OrderCounter).add(getItemCode(item));
            OrderList.get(OrderCounter).add("1");
            
            if(v.getVoucherId(getItemCode(item)) != -1)
            {
                //有優惠的時候
                OrderList.get(OrderCounter).add(String.valueOf(v.Calc(v.getVoucherId(getItemCode(item)),getPrice(getItemCode(item)))));
            }
            else
            {
                //沒優惠的時候
                OrderList.get(OrderCounter).add(String.valueOf(getPrice(String.valueOf(getItemCode(item)))));
            }
            
            OrderList.get(OrderCounter).add("");//note
            OrderList.get(OrderCounter).add(String.valueOf(OrderRealCounter));
        }
        else if(type.equals("單點"))
        {
            OrderList.get(OrderCounter).add("單點");
            OrderList.get(OrderCounter).add(s.getItemCode(item));
            OrderList.get(OrderCounter).add("1");
           
            if(v.getVoucherId(s.getItemCode(item)) != -1)
            {
                //有優惠的時候
                OrderList.get(OrderCounter).add(String.valueOf(v.Calc(v.getVoucherId(s.getItemCode(item)),s.getPrice(s.getItemCode(item)))));
                //System.out.printf("有優惠：%s\n",OrderList.get(OrderCounter).get(3));
            }
            else
            {
                //沒優惠的時候
                OrderList.get(OrderCounter).add(String.valueOf(s.getPrice(s.getItemCode(item))));
            }
            
            OrderList.get(OrderCounter).add("");//note
            OrderList.get(OrderCounter).add(String.valueOf(OrderRealCounter));
        }
        else if(type.equals("套主"))
        {
            OrderList.get(OrderCounter).add("套主");
            OrderList.get(OrderCounter).add(String.valueOf(s.getItemCode(item)));
            OrderList.get(OrderCounter).add("1");
            OrderList.get(OrderCounter).add("0");
            OrderList.get(OrderCounter).add("");//note
            OrderList.get(OrderCounter).add(String.valueOf(OrderRealCounter));
        }
        else if(type.equals("套副"))
        {
            OrderList.get(OrderCounter).add("套副");
            OrderList.get(OrderCounter).add(String.valueOf(s.getItemCode(item)));
            OrderList.get(OrderCounter).add("1");
            OrderList.get(OrderCounter).add("0");
            OrderList.get(OrderCounter).add("");//note
            OrderList.get(OrderCounter).add(String.valueOf(OrderRealCounter));
        }
        else if(type.equals("套飲"))
        {
            OrderList.get(OrderCounter).add("套飲");
            OrderList.get(OrderCounter).add(String.valueOf(s.getItemCode(item)));
            OrderList.get(OrderCounter).add("1");
            OrderList.get(OrderCounter).add("0");
            OrderList.get(OrderCounter).add("");//note
            OrderList.get(OrderCounter).add(String.valueOf(OrderRealCounter));
        }
        
        //System.out.printf("%5s %10s %5s %5s %5s \n",OrderList.get(OrderCounter).get(0),OrderList.get(OrderCounter).get(1),OrderList.get(OrderCounter).get(2),OrderList.get(OrderCounter).get(3),OrderList.get(OrderCounter).get(4));
       
       OrderCounter++;

    }
    
    public String[] getOrder(int o_id)
    {
        String[] str = new String[5];
        str[0] = OrderList.get(o_id).get(0);
        str[1] = OrderList.get(o_id).get(1);
        str[2] = OrderList.get(o_id).get(2);
        str[3] = OrderList.get(o_id).get(3);
        str[4] = OrderList.get(o_id).get(4);
        
        return str;
    }
    
    public int getOrderCounter()
    {
        return OrderCounter;
    }
    
    public void addSet(String item, String meal1, String meal2, String drink, String price)
    {
        SetList[SetCounter][0] = String.valueOf((char)(SetCounter + 65));
        SetList[SetCounter][1] = item;
        SetList[SetCounter][2] = meal1;
        SetList[SetCounter][3] = meal2;
        SetList[SetCounter][4] = drink;
        SetList[SetCounter][5] = price;
        
        SetCounter++;
    }
    
    public void updateOrder(int id, String item, String meal1, String meal2, String drink, int price, int num, String note)
    {
        /*SetList[id][0] = item;
        SetList[id][1] = meal1;
        SetList[id][2] = meal2;
        SetList[id][3] = drink;
        SetList[id][4] = String.valueOf(price);
        SetList[id][5] = String.valueOf(num);
        SetList[id][6] = note;*/
    }
    
    public void updateSet(String id, String item, String meal1, String meal2, String drink,String price)
    {
        int index_id = getItemID(id);
        
        SetList[index_id][1] = item;
        SetList[index_id][2] = meal1;
        SetList[index_id][3] = meal2;
        SetList[index_id][4] = drink;
        SetList[index_id][5] = price;
    }
    
    public void deleteOrder(int id)
    {
        /*SetList[id][0] = null;
        SetList[id][1] = null;
        SetList[id][2] = null;
        SetList[id][3] = null;
        SetList[id][4] = null;
        SetList[id][5] = null;
        SetList[id][6] = null;*/
    }
    
    public String [] getMeal(String item)
    {
        String [] arr = new String[7];
        
        for(int i=0;i<SetCounter;i++)
        {
            if(SetList[i][0].equals(item))
            {
                arr[0] = SetList[i][0];
                arr[1] = SetList[i][1];
                arr[2] = SetList[i][2];
                arr[3] = SetList[i][3];
                arr[4] = SetList[i][4];
                arr[5] = SetList[i][5];
                
                return arr;
            }
        }
        
        return arr;
    }
    
    public String [][] getFullMeal()
    {
        return SetList;
    }
    
    public String [] getSetType()
    {
        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("-");//沒有那個餐點時，輸出-
               
        for(int i=0;i<SetCounter;i++)
        {
            str1.add(SetList[i][1]);
        }
        
        String[] str = str1.toArray(new String[str1.size()]);
        
        return str;
    }
    
    public int getPrice(String type)
    {
        for(int i=0;i<SetCounter;i++)
        {
            //System.out.println(type);
            if(SetList[i][0].equals(type))
            {
                return Integer.parseInt(SetList[i][5]);
            }
        }
        return 0;
    }
    
    public int getItemID(String item)
    {        
        for(int i=0;i<SetCounter;i++)
        {
            //System.out.printf("%d = %s\n",i,SetList[i][1]);
            if(SetList[i][1].equals(item))
            {
                return i;
            }
        }
        return -1;
    }
    
    /*public String getItemName(String item)
    {        
        for(int i=0;i<SetCounter;i++)
        {
            //System.out.printf("%d = %s\n",i,SetList[i][1]);
            if(SetList[i][0].equals(item))
            {
                return SetList[i][1];
            }
        }
        return "-1";
    }*/
    
    public String getItemCode(String item)
    {        
        for(int i=0;i<SetCounter;i++)
        {
            //System.out.printf("%d = %s\n",i,SetList[i][1]);
            if(SetList[i][1].equals(item))
            {
                return SetList[i][0];
            }
        }
        return "-1";
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
    public int updateSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public String[] getMealType(String item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
