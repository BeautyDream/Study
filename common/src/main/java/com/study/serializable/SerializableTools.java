package com.study.serializable;

import java.io.*;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/12
 * 测试Serializable接口作用
 *
 * 1.在对没有实现Serializable接口，进行写入文件操作时会出现异常：java.io.NotSerializableException
 * 2.正常情况下：无论有无serialVersionUID字段，都不影响对象的序列化和反序列化，因为用户没有定义该字段时，jvm会自动创建一个值
 * 3.在没有定义serialVersionUID时，当已经对现在的对象进行了序列号存储，如果用户改变了类的变量个数、变量类型等情况会导致数据反序列化失败抛出异常：
 *   java.io.InvalidClassException：local class incompatible: stream classdesc serialVersionUID = -1914612148418344721, local class serialVersionUID = -8347405390320853159
 * 4.如果用户有自定义serialVersionUID字段的值，便不会出现第3点的情况，所以建议用户自定义serialVersionUID字段的值。
 */
public class SerializableTools {

    public static void main(String[] args) throws IOException {

        File file = new File("./common/src/main/java/com/study/serializable/test.txt");
        People people = new People();
        people.setId(1);
        people.setName("新风");
        people.setAge(23);
        System.out.println("序列化对象："+people.toString());
        writeToFile(people,file);
        People p = readFromFile(file);
        System.out.println("反序列化结果："+p.toString());

    }

    private static void writeToFile(People people, File file) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(people);

    }

    private static People readFromFile(File file) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        People p = null;
        try {
            p = (People) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }

}
