package cn.lkz.work;

import cn.lkz.work.utils.Read;
import cn.lkz.work.utils.Write;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("hello");
        Read read=new Read();
        List<String> s = read.readTxtFile("D:\\yq_in.txt");
        Map<String, List<String>> resMap = myRun(s);
        Write.writeDataHubData(resMap,"res");
    }
    public static Map<String, List<String>> myRun(List<String> s){

        String pro="";
        List<String> next=new ArrayList<>();
        String current="";
        Map<String,List<String>> res=new HashMap<>();
        for (; s.size()!=0; ) {
            current=s.get(0);
            if (current.indexOf("\t")!=-1) {
               pro=current.substring(0,current.indexOf("\t"));

                for (int j = 0; j < s.size(); j++) {

                    current=s.get(j);
                    if(current.indexOf(pro)!=-1) {
                        next.add(current.substring(current.indexOf("\t") + 1));
                        s.remove(j);
                       j--;
                    }

                }
                List<String> resList=new ArrayList<>();
                resList.addAll(next);
                next.removeAll(next);
                res.put(pro,resList);
            }


        }
        for (Map.Entry<String, List<String>> entry : res.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println(entry.getValue().get(i));
            }
        }
        return res;
    }
}
