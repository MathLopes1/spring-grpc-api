package com.grpc.api.controller;

import com.grpc.api.domain.User;
import com.grpc.api.repositories.UserRepository;
import com.grpc.v1.user.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserController extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserReq request, StreamObserver<UserRes> responseObserver) {
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user = userRepository.save(user);

        UserRes userRes = UserRes.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail())
                .build();

        responseObserver.onNext(userRes);

        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptyReq request, StreamObserver<UserResList> responseObserver) {
        super.getAll(request, responseObserver);
    }

    @Override
    public void getAllServerStream(EmptyReq request, StreamObserver<UserRes> responseObserver) {
        super.getAllServerStream(request, responseObserver);
    }
}
