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
 * <pre>
 * define service function
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service.proto")
public final class PaxosServerGrpc {

  private PaxosServerGrpc() {}

  public static final String SERVICE_NAME = "gRPC.PaxosServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gRPC.prepareMessage,
      gRPC.promise> getSendPrepareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendPrepare",
      requestType = gRPC.prepareMessage.class,
      responseType = gRPC.promise.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.prepareMessage,
      gRPC.promise> getSendPrepareMethod() {
    io.grpc.MethodDescriptor<gRPC.prepareMessage, gRPC.promise> getSendPrepareMethod;
    if ((getSendPrepareMethod = PaxosServerGrpc.getSendPrepareMethod) == null) {
      synchronized (PaxosServerGrpc.class) {
        if ((getSendPrepareMethod = PaxosServerGrpc.getSendPrepareMethod) == null) {
          PaxosServerGrpc.getSendPrepareMethod = getSendPrepareMethod = 
              io.grpc.MethodDescriptor.<gRPC.prepareMessage, gRPC.promise>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gRPC.PaxosServer", "sendPrepare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.prepareMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.promise.getDefaultInstance()))
                  .setSchemaDescriptor(new PaxosServerMethodDescriptorSupplier("sendPrepare"))
                  .build();
          }
        }
     }
     return getSendPrepareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gRPC.proposeMessage,
      gRPC.commitResponse> getSendProposeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendPropose",
      requestType = gRPC.proposeMessage.class,
      responseType = gRPC.commitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.proposeMessage,
      gRPC.commitResponse> getSendProposeMethod() {
    io.grpc.MethodDescriptor<gRPC.proposeMessage, gRPC.commitResponse> getSendProposeMethod;
    if ((getSendProposeMethod = PaxosServerGrpc.getSendProposeMethod) == null) {
      synchronized (PaxosServerGrpc.class) {
        if ((getSendProposeMethod = PaxosServerGrpc.getSendProposeMethod) == null) {
          PaxosServerGrpc.getSendProposeMethod = getSendProposeMethod = 
              io.grpc.MethodDescriptor.<gRPC.proposeMessage, gRPC.commitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gRPC.PaxosServer", "sendPropose"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.proposeMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.commitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PaxosServerMethodDescriptorSupplier("sendPropose"))
                  .build();
          }
        }
     }
     return getSendProposeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gRPC.getKey,
      gRPC.getResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = gRPC.getKey.class,
      responseType = gRPC.getResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.getKey,
      gRPC.getResponse> getGetMethod() {
    io.grpc.MethodDescriptor<gRPC.getKey, gRPC.getResponse> getGetMethod;
    if ((getGetMethod = PaxosServerGrpc.getGetMethod) == null) {
      synchronized (PaxosServerGrpc.class) {
        if ((getGetMethod = PaxosServerGrpc.getGetMethod) == null) {
          PaxosServerGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<gRPC.getKey, gRPC.getResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gRPC.PaxosServer", "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.getKey.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.getResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PaxosServerMethodDescriptorSupplier("get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PaxosServerStub newStub(io.grpc.Channel channel) {
    return new PaxosServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PaxosServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PaxosServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PaxosServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PaxosServerFutureStub(channel);
  }

  /**
   * <pre>
   * define service function
   * </pre>
   */
  public static abstract class PaxosServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendPrepare(gRPC.prepareMessage request,
        io.grpc.stub.StreamObserver<gRPC.promise> responseObserver) {
      asyncUnimplementedUnaryCall(getSendPrepareMethod(), responseObserver);
    }

    /**
     */
    public void sendPropose(gRPC.proposeMessage request,
        io.grpc.stub.StreamObserver<gRPC.commitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendProposeMethod(), responseObserver);
    }

    /**
     */
    public void get(gRPC.getKey request,
        io.grpc.stub.StreamObserver<gRPC.getResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendPrepareMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.prepareMessage,
                gRPC.promise>(
                  this, METHODID_SEND_PREPARE)))
          .addMethod(
            getSendProposeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.proposeMessage,
                gRPC.commitResponse>(
                  this, METHODID_SEND_PROPOSE)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.getKey,
                gRPC.getResponse>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   * <pre>
   * define service function
   * </pre>
   */
  public static final class PaxosServerStub extends io.grpc.stub.AbstractStub<PaxosServerStub> {
    private PaxosServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaxosServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaxosServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaxosServerStub(channel, callOptions);
    }

    /**
     */
    public void sendPrepare(gRPC.prepareMessage request,
        io.grpc.stub.StreamObserver<gRPC.promise> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendPrepareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendPropose(gRPC.proposeMessage request,
        io.grpc.stub.StreamObserver<gRPC.commitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendProposeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(gRPC.getKey request,
        io.grpc.stub.StreamObserver<gRPC.getResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * define service function
   * </pre>
   */
  public static final class PaxosServerBlockingStub extends io.grpc.stub.AbstractStub<PaxosServerBlockingStub> {
    private PaxosServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaxosServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaxosServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaxosServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public gRPC.promise sendPrepare(gRPC.prepareMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendPrepareMethod(), getCallOptions(), request);
    }

    /**
     */
    public gRPC.commitResponse sendPropose(gRPC.proposeMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendProposeMethod(), getCallOptions(), request);
    }

    /**
     */
    public gRPC.getResponse get(gRPC.getKey request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * define service function
   * </pre>
   */
  public static final class PaxosServerFutureStub extends io.grpc.stub.AbstractStub<PaxosServerFutureStub> {
    private PaxosServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaxosServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaxosServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaxosServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.promise> sendPrepare(
        gRPC.prepareMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendPrepareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.commitResponse> sendPropose(
        gRPC.proposeMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendProposeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.getResponse> get(
        gRPC.getKey request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_PREPARE = 0;
  private static final int METHODID_SEND_PROPOSE = 1;
  private static final int METHODID_GET = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PaxosServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PaxosServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_PREPARE:
          serviceImpl.sendPrepare((gRPC.prepareMessage) request,
              (io.grpc.stub.StreamObserver<gRPC.promise>) responseObserver);
          break;
        case METHODID_SEND_PROPOSE:
          serviceImpl.sendPropose((gRPC.proposeMessage) request,
              (io.grpc.stub.StreamObserver<gRPC.commitResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((gRPC.getKey) request,
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

  private static abstract class PaxosServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PaxosServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gRPC.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PaxosServer");
    }
  }

  private static final class PaxosServerFileDescriptorSupplier
      extends PaxosServerBaseDescriptorSupplier {
    PaxosServerFileDescriptorSupplier() {}
  }

  private static final class PaxosServerMethodDescriptorSupplier
      extends PaxosServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PaxosServerMethodDescriptorSupplier(String methodName) {
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
      synchronized (PaxosServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PaxosServerFileDescriptorSupplier())
              .addMethod(getSendPrepareMethod())
              .addMethod(getSendProposeMethod())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
