package com.study.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/2/26
 */
public class TestFile {

    public static void main(String[] args) throws IOException, InterruptedException {

        out();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<10){
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        out();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }).start();

    }

    public static void out() throws IOException {
        for (int i = 3; i > 0; i--) {
            File file = new File("D://midea/temp/3544.txt");

            FileOutputStream fos = null;
            try{
                if(file.delete()){
                    System.out.println("删除文件成功");
                }

//                Thread.sleep(60000);
                if(file.isFile()){
                    System.out.println("是文件");
                }
                if(file.isDirectory()){
                    System.out.println("是目录");
                }
                File file2 = new File("D://midea/temp/3544.txt");
                if(!file2.exists()){
//            file.mkdirs();
                    System.out.println("不存在并创建...");
                    file2.createNewFile();
                }
                fos = new FileOutputStream(file2,true);
                String str = "添加数据\r\n";
                fos.write(str.getBytes());
//                int a = 2/0;

            }catch (Exception e){
                e.printStackTrace();
                return;
            }finally {
//                fos.close();
                System.out.println("进入 finally");
            }

        }
    }

}
