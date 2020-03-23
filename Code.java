import java.util.*;

public class Result {

    public static int deleteProducts(List<Integer> ids, int m){

        int count=0;

        HashSet<Integer> keys = new HashSet<Integer>(ids);
        HashMap<Integer,Integer> valueFrequency = new HashMap<Integer,Integer>();
        Iterator<Integer> value = keys.iterator();
        while (value.hasNext()) {
            count=0;
            int key = value.next();
            for(int id:ids){
                if(id==key){
                    count++;
                }
            }
            valueFrequency.put(key,count);
        }

        while(m!=0){

            Collection<Integer> frequencies = valueFrequency.values();
            int minFrquency = Collections.min(frequencies);
            if (m==minFrquency){
                return keys.size()-1;
            }else if (m<minFrquency){
                return keys.size();
            }else{
                int keyToDelete=0;
                Iterator<Map.Entry<Integer,Integer>> it = valueFrequency.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>) it.next();
                    if(pair.getValue()==minFrquency){
                        keyToDelete=pair.getKey();
                        break;
                    }
                }
                valueFrequency.remove(keyToDelete);
                keys.remove(keyToDelete);
                m=m-minFrquency;
            }
        }

        return 0;

    }


    public static void main(String[] args) {

        List<Integer> ids = new ArrayList<>() ;
        ids.add(1);ids.add(2);ids.add(3);ids.add(1);ids.add(2);ids.add(2);
        System.out.println(deleteProducts(ids,3));
    }
}
