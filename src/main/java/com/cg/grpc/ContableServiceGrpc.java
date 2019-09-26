package com.cg.grpc;

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
    value = "by gRPC proto compiler (version 1.17.1)",
    comments = "Source: Message.proto")
public final class ContableServiceGrpc {

  private ContableServiceGrpc() {}

  public static final String SERVICE_NAME = "com.cg.grpc.ContableService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cg.grpc.request,
      com.cg.grpc.response> getCreationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "creation",
      requestType = com.cg.grpc.request.class,
      responseType = com.cg.grpc.response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cg.grpc.request,
      com.cg.grpc.response> getCreationMethod() {
    io.grpc.MethodDescriptor<com.cg.grpc.request, com.cg.grpc.response> getCreationMethod;
    if ((getCreationMethod = ContableServiceGrpc.getCreationMethod) == null) {
      synchronized (ContableServiceGrpc.class) {
        if ((getCreationMethod = ContableServiceGrpc.getCreationMethod) == null) {
          ContableServiceGrpc.getCreationMethod = getCreationMethod = 
              io.grpc.MethodDescriptor.<com.cg.grpc.request, com.cg.grpc.response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.cg.grpc.ContableService", "creation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cg.grpc.request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cg.grpc.response.getDefaultInstance()))
                  .setSchemaDescriptor(new ContableServiceMethodDescriptorSupplier("creation"))
                  .build();
          }
        }
     }
     return getCreationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContableServiceStub newStub(io.grpc.Channel channel) {
    return new ContableServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContableServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ContableServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContableServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ContableServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ContableServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void creation(com.cg.grpc.request request,
        io.grpc.stub.StreamObserver<com.cg.grpc.response> responseObserver) {
      asyncUnimplementedUnaryCall(getCreationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cg.grpc.request,
                com.cg.grpc.response>(
                  this, METHODID_CREATION)))
          .build();
    }
  }

  /**
   */
  public static final class ContableServiceStub extends io.grpc.stub.AbstractStub<ContableServiceStub> {
    private ContableServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContableServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContableServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContableServiceStub(channel, callOptions);
    }

    /**
     */
    public void creation(com.cg.grpc.request request,
        io.grpc.stub.StreamObserver<com.cg.grpc.response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ContableServiceBlockingStub extends io.grpc.stub.AbstractStub<ContableServiceBlockingStub> {
    private ContableServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContableServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContableServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContableServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cg.grpc.response creation(com.cg.grpc.request request) {
      return blockingUnaryCall(
          getChannel(), getCreationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ContableServiceFutureStub extends io.grpc.stub.AbstractStub<ContableServiceFutureStub> {
    private ContableServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContableServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContableServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContableServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cg.grpc.response> creation(
        com.cg.grpc.request request) {
      return futureUnaryCall(
          getChannel().newCall(getCreationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContableServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContableServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATION:
          serviceImpl.creation((com.cg.grpc.request) request,
              (io.grpc.stub.StreamObserver<com.cg.grpc.response>) responseObserver);
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

  private static abstract class ContableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContableServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cg.grpc.Message.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContableService");
    }
  }

  private static final class ContableServiceFileDescriptorSupplier
      extends ContableServiceBaseDescriptorSupplier {
    ContableServiceFileDescriptorSupplier() {}
  }

  private static final class ContableServiceMethodDescriptorSupplier
      extends ContableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContableServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContableServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContableServiceFileDescriptorSupplier())
              .addMethod(getCreationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
