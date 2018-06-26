package com.example.learn;

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
        LoginResponse.Builder responseBuilder = LoginResponse.newBuilder();
        if (username.contentEquals("shuza") && password.contentEquals("123456")) {
            responseBuilder.setResponseCode(200)
                    .setMessage("Login Success");
        } else {
            responseBuilder.setResponseCode(400)
                    .setMessage("Login Failed");
        }

        return responseBuilder.build();
    }
}
