import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        HashMap <String,Integer> map= new HashMap<>();
        map.put(" Nhat",5);
        map.put("Hao",8);
        map.put("Hoang",7);
        int max=0;
        for(int value:map.values()){
            if(max<value)
            max=value;
        }
        System.out.println();
    }
    
}
