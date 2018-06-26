package com.example.learn;

import io.grpc.Server;
import io.grpc.ServerBuilder;

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
