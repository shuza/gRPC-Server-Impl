package com.example.learn.services;


import com.example.learn.HelloRequest;
import com.example.learn.HelloResponse;
import com.example.learn.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImp extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void greet(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        responseObserver
                .onNext(HelloResponse
                        .newBuilder()
                        .setGreeting("Hello  " + request.getName())
                        .build());

        responseObserver.onCompleted();
    }
}