package job.zhaoyin.test1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sum(String path) throws IOException {
        if (!new File(path).exists()){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int score = Integer.valueOf(line.split(":")[1]);
            list.add(score);
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        //System.out.println(new Solution().sum("D:\\Workspace\\IDEA\\practise\\src\\Data.txt"));
//        double a = 1.0;
//        int b = 1;
//        System.out.println(a==b);
    }
}
