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
public final class getServiceGrpc {

  private getServiceGrpc() {}

  public static final String SERVICE_NAME = "gRPC.getService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gRPC.getRequest,
      gRPC.getResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = gRPC.getRequest.class,
      responseType = gRPC.getResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.getRequest,
      gRPC.getResponse> getGetMethod() {
    io.grpc.MethodDescriptor<gRPC.getRequest, gRPC.getResponse> getGetMethod;
    if ((getGetMethod = getServiceGrpc.getGetMethod) == null) {
      synchronized (getServiceGrpc.class) {
        if ((getGetMethod = getServiceGrpc.getGetMethod) == null) {
          getServiceGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<gRPC.getRequest, gRPC.getResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gRPC.getService", "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.getRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.getResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new getServiceMethodDescriptorSupplier("get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static getServiceStub newStub(io.grpc.Channel channel) {
    return new getServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static getServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new getServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static getServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new getServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class getServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(gRPC.getRequest request,
        io.grpc.stub.StreamObserver<gRPC.getResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.getRequest,
                gRPC.getResponse>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   */
  public static final class getServiceStub extends io.grpc.stub.AbstractStub<getServiceStub> {
    private getServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private getServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected getServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new getServiceStub(channel, callOptions);
    }

    /**
     */
    public void get(gRPC.getRequest request,
        io.grpc.stub.StreamObserver<gRPC.getResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class getServiceBlockingStub extends io.grpc.stub.AbstractStub<getServiceBlockingStub> {
    private getServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private getServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected getServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new getServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public gRPC.getResponse get(gRPC.getRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class getServiceFutureStub extends io.grpc.stub.AbstractStub<getServiceFutureStub> {
    private getServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private getServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected getServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new getServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.getResponse> get(
        gRPC.getRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final getServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(getServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((gRPC.getRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.getResponse>) responseObserver);
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

  private static abstract class getServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    getServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gRPC.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("getService");
    }
  }

  private static final class getServiceFileDescriptorSupplier
      extends getServiceBaseDescriptorSupplier {
    getServiceFileDescriptorSupplier() {}
  }

  private static final class getServiceMethodDescriptorSupplier
      extends getServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    getServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (getServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new getServiceFileDescriptorSupplier())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
