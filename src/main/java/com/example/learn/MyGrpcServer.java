package com.example.learn;

import com.example.learn.services.HelloServiceImp;
import com.example.learn.services.LoginServiceImp;
import com.example.learn.services.SignUpServiceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  28-Jun-18
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

public class MyGrpcServer {

    public static void main(String[] arg) {
        try {
            Server server = ServerBuilder.forPort(8080)
                    .addService(new HelloServiceImp())
                    .addService(new SignUpServiceImp())
                    .addService(new LoginServiceImp())
                    .build();
            System.out.println("Starting Server......");
            server.start();
            System.out.println("Server has started ========");

            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
