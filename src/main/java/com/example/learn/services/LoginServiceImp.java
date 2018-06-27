package com.example.learn.services;

import com.example.learn.LoginRequest;
import com.example.learn.LoginResponse;
import com.example.learn.LoginServiceGrpc;
import com.example.learn.daos.UserRecord;
import io.grpc.stub.StreamObserver;

public class LoginServiceImp extends LoginServiceGrpc.LoginServiceImplBase {

    @Override
    public void logIn(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        System.out.println(request);

        responseObserver
                .onNext(checkLoginCredential(request.getUsername(), request.getPassword()));

        responseObserver.onCompleted();
    }

    private LoginResponse checkLoginCredential(String username, String password) {
        UserRecord userRecord = UserRecord.getInstance();

        LoginResponse.Builder responseBuilder = LoginResponse.newBuilder();
        if (userRecord.isUserMatch(username, password)) {
            responseBuilder.setResponseCode(200)
                    .setMessage("Login Success");
        } else {
            responseBuilder.setResponseCode(400)
                    .setMessage("Login Failed");
        }

        return responseBuilder.build();
    }
}
