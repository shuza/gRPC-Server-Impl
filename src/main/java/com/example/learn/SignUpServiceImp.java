package com.example.learn;

import io.grpc.stub.StreamObserver;

public class SignUpServiceImp extends SignUpServiceGrpc.SignUpServiceImplBase {

    @Override
    public void signUp(SignUpRequest request, StreamObserver<SignUpResponse> responseObserver) {
        System.out.println(request);

        responseObserver
                .onNext(SignUpResponse.newBuilder()
                        .setResponseCode(200)
                        .setMessage("Success")
                        .build());
    }
}
