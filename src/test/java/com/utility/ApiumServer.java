package com.utility;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.net.ServerSocket;

public class ApiumServer {
    //AppiumDriverLocalService service = null;

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static AppiumDriverLocalService startServer(){
        AppiumDriverLocalService service = null;
        boolean flag=checkIfServerIsRunnning(4723);
        if(!flag){
            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
        }


        return service;
    }
    public static AppiumDriverLocalService stopServer(){
        AppiumDriverLocalService service = null;
        boolean flag=checkIfServerIsRunnning(4723);
        if(flag){
            service=AppiumDriverLocalService.buildDefaultService();
            service.stop();
        }


        return service;
    }


}
