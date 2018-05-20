import java.io.*;
/*
 * 思路：
 * 1.将文件内容读入字符串数组
 * 2.用正则表达式将字符串内容切割
 * 3.将字符串内容保存到目标文件中
 * 
 */

public class demo {
    public static void main(String[] args) throws IOException {

        try {
            // read file content from file
            String sb = new String("");

            FileReader reader = new FileReader("F:/JAVA/Operating_System/file_operation/readme.txt");
            //文件输入流
            BufferedReader br = new BufferedReader(reader);
            //从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
            String str = null;

            while ((str = br.readLine()) != null) { //每次读一行
                sb=sb+str;
                System.out.println(sb);
            }
            String[] strArr = sb.split("AB+");
            System.out.println("数组字符的长度："+strArr.length);
            for(int i = 0;i<strArr.length;i++)
                System.out.print(strArr[i]);

            br.close();
            reader.close();

            // write string to file
            File wfile = new File("F:/JAVA/Operating_System/file_operation/writeme.txt");
            if(!wfile.exists()){
                try{
                    wfile.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            FileWriter writer = new FileWriter(wfile);
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 0;i < strArr.length; i++){
                bw.write(strArr[i]);
            }

            bw.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}