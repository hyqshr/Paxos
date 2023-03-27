package gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service.proto")
public final class deleteServiceGrpc {

  private deleteServiceGrpc() {}

  public static final String SERVICE_NAME = "gRPC.deleteService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gRPC.deleteRequest,
      gRPC.deleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = gRPC.deleteRequest.class,
      responseType = gRPC.deleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.deleteRequest,
      gRPC.deleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<gRPC.deleteRequest, gRPC.deleteResponse> getDeleteMethod;
    if ((getDeleteMethod = deleteServiceGrpc.getDeleteMethod) == null) {
      synchronized (deleteServiceGrpc.class) {
        if ((getDeleteMethod = deleteServiceGrpc.getDeleteMethod) == null) {
          deleteServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<gRPC.deleteRequest, gRPC.deleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gRPC.deleteService", "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.deleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.deleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new deleteServiceMethodDescriptorSupplier("delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static deleteServiceStub newStub(io.grpc.Channel channel) {
    return new deleteServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static deleteServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new deleteServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static deleteServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new deleteServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class deleteServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void delete(gRPC.deleteRequest request,
        io.grpc.stub.StreamObserver<gRPC.deleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.deleteRequest,
                gRPC.deleteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class deleteServiceStub extends io.grpc.stub.AbstractStub<deleteServiceStub> {
    private deleteServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private deleteServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected deleteServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new deleteServiceStub(channel, callOptions);
    }

    /**
     */
    public void delete(gRPC.deleteRequest request,
        io.grpc.stub.StreamObserver<gRPC.deleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class deleteServiceBlockingStub extends io.grpc.stub.AbstractStub<deleteServiceBlockingStub> {
    private deleteServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private deleteServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected deleteServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new deleteServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public gRPC.deleteResponse delete(gRPC.deleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class deleteServiceFutureStub extends io.grpc.stub.AbstractStub<deleteServiceFutureStub> {
    private deleteServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private deleteServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected deleteServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new deleteServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.deleteResponse> delete(
        gRPC.deleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final deleteServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(deleteServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE:
          serviceImpl.delete((gRPC.deleteRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.deleteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class deleteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    deleteServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gRPC.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("deleteService");
    }
  }

  private static final class deleteServiceFileDescriptorSupplier
      extends deleteServiceBaseDescriptorSupplier {
    deleteServiceFileDescriptorSupplier() {}
  }

  private static final class deleteServiceMethodDescriptorSupplier
      extends deleteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    deleteServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (deleteServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new deleteServiceFileDescriptorSupplier())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
