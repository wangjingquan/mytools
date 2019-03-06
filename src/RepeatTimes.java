import java.util.HashMap;
import java.util.Map;

public class RepeatTimes {
    public static void main(String args[]){
        String[] ss={"大","小","前","大","小","大"};
        Map<String,Object> map=new HashMap<String,Object>();
        for (int i = 0; i < ss.length; i++) {
            String temp1=ss[i];
            int count=0;
            for (int j = 0; j < ss.length; j++) {
                String temp2=ss[j];
                if(temp1==temp2){
                    count++;
                }
                map.put(ss[i], count);
            }
        }
        System.out.println(map.toString());
    }
}
