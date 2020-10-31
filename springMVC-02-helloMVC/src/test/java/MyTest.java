import org.springframework.util.StringUtils;

import java.util.*;

public class MyTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        // 多少行
        int strCount =  scanner.nextInt();
        // 存放字符串
        List<String> stringList = new ArrayList<>();
        if(strCount > 0){
//            for (int i = 0;i<strCount;i++){
//                String str = scanner.nextLine();
//                stringList.add(str);
//            }
            while (scanner.hasNext()){
                String str = scanner.nextLine();
                stringList.add(str);
            }
            if(stringList.size() > strCount){
                System.out.println("虽然你输入多了，但是我也一并处理~");
            }else if(stringList.size() < strCount){
                System.out.println("虽然你输入少了，我也照样处理~");
            }
        }else {
            System.out.println("你不对劲~");
            return;
        }
        if(stringList != null && stringList.size() > 0){
            for (String s : stringList){
                if(!StringUtils.isEmpty(s)){
                }
            }
        }
    }

    public static String returnStr(String str){
        //字典 重复字符串，数量{"ll":2}
        // 1. 重复字符串的数量大于等于2
        Map<String, Integer> map = new HashMap<>();
        char[] cArray = str.toCharArray();
        if(cArray != null && cArray.length > 0){
            for (int i = 0;i<cArray.length - 1;i++){
                if (cArray[i] == cArray[i+1]){

                }
            }
        }
        return "";
    }
}
