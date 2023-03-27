package Coordinator.service;

import Coordinator.Coordinator;
import gRPC.putRequest;
import gRPC.putResponse;
import gRPC.putServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PutService extends putServiceGrpc.putServiceImplBase{
    Coordinator coordinator;
    public PutService(Coordinator coor){
        coordinator = coor;
    }

    @Override
    public void put(putRequest request, StreamObserver<putResponse> responseObserver) {
        System.out.println("put Service received: "+ request);
        String key = request.getKey();
        String val = request.getVal();

        // start commit after receive the RPC call
        coordinator.startCommit(key, val, "PUT");

        putResponse.Builder response = putResponse.newBuilder();
        response.setResponseMsg("PUT success with " + key + " - " + val);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}