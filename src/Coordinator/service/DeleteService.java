package Coordinator.service;

import Coordinator.Coordinator;
import gRPC.deleteRequest;
import gRPC.deleteResponse;
import gRPC.deleteServiceGrpc;
import io.grpc.stub.StreamObserver;

public class DeleteService extends deleteServiceGrpc.deleteServiceImplBase {
    Coordinator coordinator;

    public DeleteService(Coordinator coor){
        coordinator = coor;
    }

	@Override
	public void delete(deleteRequest request, StreamObserver<deleteResponse> responseObserver) {
		System.out.println("delete Service received: "+ request);
		String key = request.getKey();

		// start commit after receive the RPC call
		coordinator.startCommit(key, "", "DELETE");
		deleteResponse.Builder response = deleteResponse.newBuilder();
		response.setResponseMsg("DELETE success with " + key);
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
