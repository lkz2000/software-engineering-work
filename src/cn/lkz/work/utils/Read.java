package cn.lkz.work.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Read {
    public List<String> readTxtFile(String filePath){
        List<String> list=new ArrayList<>();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null) {
                    //lineTxt=lineTxt.replace(" {2,}"," ");
                    list.add(lineTxt);


                }
                read.close();
                return list;
            }else{
                System.out.println("找不到指定的文件");
                return list;
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
            return list;
        }

    }
}
