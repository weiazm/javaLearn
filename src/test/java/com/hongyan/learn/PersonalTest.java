package com.hongyan.learn;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PersonalTest {
    
    // 测试nanotime
    @Ignore
    @Test(timeout = 0L)
    public void getTime() throws InterruptedException {
        Long t1 = System.nanoTime();
        for (int i = 1; i < 1000000000; i++) {
        }
        Thread.sleep(2L * 1000);
        Long t2 = System.nanoTime();
        System.out.println((t2 - t1));
    }

    // 使用网络关闭tomcat
    // @Ignore
    @Test
    public void stopTomcat() throws UnknownHostException, IOException {
        String command = "SHUTDOWN";
        Integer port = 8005;

        Socket socket = new Socket("localhost", port);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        bos.write(command.getBytes());
        bos.flush();

        System.out.println("write done!:" + command);
        socket.close();
    }

}
