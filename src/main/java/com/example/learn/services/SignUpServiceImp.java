package com.example.learn.services;

import com.example.learn.SignUpRequest;
import com.example.learn.SignUpResponse;
import com.example.learn.SignUpServiceGrpc;
import com.example.learn.daos.UserRecord;
import io.grpc.stub.StreamObserver;

public class SignUpServiceImp extends SignUpServiceGrpc.SignUpServiceImplBase {

    @Override
    public void signUp(SignUpRequest request, StreamObserver<SignUpResponse> responseObserver) {
        System.out.println(request);
        SignUpResponse.Builder responseBuilder = SignUpResponse.newBuilder();

        UserRecord userRecord = UserRecord.getInstance();
        if (userRecord.createUser(request.getUsername(), request.getPassword())) {
            responseBuilder.setResponseCode(200);
            responseBuilder.setMessage("Sign UP successfully");
        } else {
            responseBuilder.setResponseCode(400);
            responseBuilder.setMessage("Sign Up Failed");
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
