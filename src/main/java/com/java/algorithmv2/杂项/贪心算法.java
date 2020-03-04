package com.java.algorithmv2.杂项;

import java.util.*;


/**
 * 选择最少的广播电台，可以覆盖最全的城市
 */
public class 贪心算法 {


    public static void main(String[] args) {
        Map<String, HashSet<String>> broadcasts=new HashMap<String,HashSet<String>>();
        broadcasts.put("k1",buildData(new String[]{"北京","上海","天津"}));
        broadcasts.put("k2",buildData(new String[]{"广州","北京","深圳"}));
        broadcasts.put("k3",buildData(new String[]{"成都","上海","杭州"}));
        broadcasts.put("k4",buildData(new String[]{"上海","天津"}));
        broadcasts.put("k5",buildData(new String[]{"杭州","大连"}));

        Set<String> allAreas=getAllAreas(broadcasts);
        List<String> radioSelects=new ArrayList<>();//存放选择的电台
        List<String> tempAreas=new ArrayList<>();
        String maxKey=null;
        Integer maxKeySize=0;
        while (allAreas.size()>0){
            maxKey=null;
            maxKeySize=0;
            for(String key:broadcasts.keySet()){
                tempAreas.clear();
                //当前电台能覆盖的城市
                HashSet<String> strings = broadcasts.get(key);
                tempAreas.addAll(strings);
                tempAreas.retainAll(allAreas);
                if(tempAreas.size()>0&&(maxKey==null||tempAreas.size()>maxKeySize)){
                    maxKey=key;
                    maxKeySize=tempAreas.size();
                }
            }
            if(maxKey!=null){
                radioSelects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(radioSelects);


    }

    private static Set<String> getAllAreas(Map<String, HashSet<String>> broadcasts){
        Set<String> allAreas=new HashSet<>();
        Iterator<Map.Entry<String, HashSet<String>>> iterator = broadcasts.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, HashSet<String>> next = iterator.next();
            allAreas.addAll(next.getValue());
        }
        return allAreas;
    }
    private static HashSet<String> buildData(String[] arr){
        HashSet<String> sets=new HashSet<>();
        for(String str:arr){
            sets.add(str);
        }
        return sets;
    }
}
