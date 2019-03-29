package com.study.ip;

import java.net.*;
import java.util.Enumeration;

/**
 * 获取本机的有效IP地址
 * 参考：https://www.cnblogs.com/starcrm/p/7071227.html
 * @date 2019-03-29
 */
public class GetIpAddress {

    public static void main(String[] args) throws UnknownHostException, SocketException {
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(getLocalIp().getHostAddress());
    }

    public static InetAddress getLocalIp() throws SocketException, UnknownHostException {
        InetAddress candidateAdderss = null;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {

                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();


                    if (!inetAddress.isLoopbackAddress()&&inetAddress instanceof Inet4Address) {
                        if (inetAddress.isSiteLocalAddress()) {
                            //TODO  这里也可能有多个有效IP地址 立即返回就是选取了第一个IP
                            System.out.println("real ip: " + inetAddress.getHostAddress());
                            return inetAddress;
                        }else if(candidateAdderss == null){
                            candidateAdderss = inetAddress;
                        }
                    }
                }
        }

        if(candidateAdderss!=null){
            return candidateAdderss;
        }

        InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
        if (jdkSuppliedAddress == null) {
            throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
        }
        return jdkSuppliedAddress;
    }

}
