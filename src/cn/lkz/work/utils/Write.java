package cn.lkz.work.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Write {
    public static boolean writeDataHubData(Map<String, List<String>> map,String fileName) {
        long start = System.currentTimeMillis();
        String filePath = "D:\\temp\\txt";
        StringBuilder content = new StringBuilder();
        boolean flag = false;
        BufferedWriter out = null;
        try {
            if (map != null && !map.isEmpty() && fileName!=null) {
                fileName += "_" + System.currentTimeMillis() + ".txt";
                File pathFile = new File(filePath);
                if (!pathFile.exists()) {
                    pathFile.mkdirs();
                }
                String relFilePath = filePath + File.separator + fileName;
                File file = new File(relFilePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));


                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    out.write(entry.getKey());
                    out.newLine();
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        out.write(entry.getValue().get(i));
                        out.newLine();
                    }
                    out.newLine();
                }
                flag = true;
                System.out.println("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
    }
}
