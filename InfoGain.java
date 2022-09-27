import java.io.*;
import java.util.*;

class InfoGain
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/Shripad/OneDrive/Desktop/class.csv"));
        String []str=br.readLine().trim().split(",");
        int n=str.length;
        ArrayList<ArrayList<String>> l=new ArrayList<>();
         while(true)
        {
            String [] s=new String[n];
            try{
                s=br.readLine().trim().split(",");
            }
            catch(NullPointerException e)
            {
                break;
            }
            ArrayList<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                
                temp.add(s[i]);
            }
            l.add(temp);
        }
        System.out.println(l);

        String[][] array = new String[l.size()][];
        for (int i = 0; i < l.size(); i++) 
        {
              
               ArrayList<String> row = l.get(i);
               array[i] = row.toArray(new String[row.size()]);
        }
        // for(int i=0;i<array.length;i++)
        // {
        //     for(int j=0;j<array[0].length;j++)
        //     {
        //         System.out.print(array[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        Map<String,Integer> m=new HashMap<>();
        int p=array[0].length;
        for(int j=0;j<array.length;j++)
        {
            String key=array[j][p-1];
            if(!m.containsKey(key))
            {
                m.put(key,1);
            }
            else
            {
              m.put(key,m.get(key)+1);
            } 
        }

        //finding the parent entropy
        int tot=0;
        for(Map.Entry<String,Integer> e:m.entrySet())
        {
            tot+=e.getValue();
        }
        ArrayList<Double> l1=new ArrayList<>();
        for(Map.Entry<String,Integer> e:m.entrySet())
        {
            l1.add(1.0*e.getValue()/tot);
        }
        double parent_entropy=0.0;
        for(int i=0;i<l1.size();i++)
        {
           parent_entropy+=-(l1.get(i)*(Math.log(l1.get(i))/Math.log(2)));
        }

        //finding the entropy of children
        double ans=findChildEntropy(array,0);
        

    }
    public static double findChildEntropy(String [][] array,int col_no)
    {
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        Map<String,Map<String,Integer>> m=new HashMap<>();
        int p=array[0].length;
        for(int j=0;j<array.length;j++)
        {
            String key=array[j][col_no];
            Map<String,Integer>temp=new HashMap<>();
            String key2=array[j][p-1];
            if(!m.containsKey(key)&&!temp.containsKey(key2))
            {
                temp.put(key2,1);
                m.put(key,temp);
            }
            else if(!m.containsKey(key)&&temp.containsKey(key2))
            {
                temp.put(key2,temp.get(key2)+1);
                m.put(key,temp);
            }
            else if(m.containsKey(key)&&!temp.containsKey(key2))
            {
                temp.put(key2,1);
                m.put(key,temp);
            }
            else if(m.containsKey(key)&&temp.containsKey(key2))
            {
                temp.put(key2,temp.get(key2)+1);
                m.put(key,temp);
            } 
            // {
            //     String key2=array[j][p-1];
            //     if(!temp.containsKey(key2))
            //     {
            //         temp.put(key2,1);
            //     }
            //     else
            //     {
            //         temp.put(key2,temp.get(key2)+1);
            //     }
            //     m.put(key,temp);
            // }
            // else
            // {
            //     String key2=array[j][p-1];
            //     if(!temp.containsKey(key2))
            //     {
            //         temp.put(key2,1);
            //     }
            //     else
            //     {
            //         temp.put(key2,temp.get(key2)+1);
            //     }
            //     m.put(key,temp);
            //} 
        }
        for(Map.Entry<String,Map<String,Integer>> e1:m.entrySet())
        {
            System.out.print(e1.getKey()+"  "+e1.getValue());
           
            
              
        }
        return 0.0;
    }
}            