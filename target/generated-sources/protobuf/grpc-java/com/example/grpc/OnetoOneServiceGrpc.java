package com.example.grpc;

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
 * Defining a Service, a Service can have multiple RPC operations
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: OneToOne.proto")
public final class OnetoOneServiceGrpc {

  private OnetoOneServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.OnetoOneService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.OnetoOneproto.Request,
      com.example.grpc.OnetoOneproto.Response> getOneToOneCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "oneToOneCall",
      requestType = com.example.grpc.OnetoOneproto.Request.class,
      responseType = com.example.grpc.OnetoOneproto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.OnetoOneproto.Request,
      com.example.grpc.OnetoOneproto.Response> getOneToOneCallMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.OnetoOneproto.Request, com.example.grpc.OnetoOneproto.Response> getOneToOneCallMethod;
    if ((getOneToOneCallMethod = OnetoOneServiceGrpc.getOneToOneCallMethod) == null) {
      synchronized (OnetoOneServiceGrpc.class) {
        if ((getOneToOneCallMethod = OnetoOneServiceGrpc.getOneToOneCallMethod) == null) {
          OnetoOneServiceGrpc.getOneToOneCallMethod = getOneToOneCallMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.OnetoOneproto.Request, com.example.grpc.OnetoOneproto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "oneToOneCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.OnetoOneproto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.OnetoOneproto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new OnetoOneServiceMethodDescriptorSupplier("oneToOneCall"))
              .build();
        }
      }
    }
    return getOneToOneCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OnetoOneServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnetoOneServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OnetoOneServiceStub>() {
        @java.lang.Override
        public OnetoOneServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OnetoOneServiceStub(channel, callOptions);
        }
      };
    return OnetoOneServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OnetoOneServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnetoOneServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OnetoOneServiceBlockingStub>() {
        @java.lang.Override
        public OnetoOneServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OnetoOneServiceBlockingStub(channel, callOptions);
        }
      };
    return OnetoOneServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OnetoOneServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnetoOneServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OnetoOneServiceFutureStub>() {
        @java.lang.Override
        public OnetoOneServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OnetoOneServiceFutureStub(channel, callOptions);
        }
      };
    return OnetoOneServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Defining a Service, a Service can have multiple RPC operations
   * </pre>
   */
  public static abstract class OnetoOneServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public void oneToOneCall(com.example.grpc.OnetoOneproto.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.OnetoOneproto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getOneToOneCallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOneToOneCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.OnetoOneproto.Request,
                com.example.grpc.OnetoOneproto.Response>(
                  this, METHODID_ONE_TO_ONE_CALL)))
          .build();
    }
  }

  /**
   * <pre>
   * Defining a Service, a Service can have multiple RPC operations
   * </pre>
   */
  public static final class OnetoOneServiceStub extends io.grpc.stub.AbstractAsyncStub<OnetoOneServiceStub> {
    private OnetoOneServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnetoOneServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnetoOneServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public void oneToOneCall(com.example.grpc.OnetoOneproto.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.OnetoOneproto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOneToOneCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Defining a Service, a Service can have multiple RPC operations
   * </pre>
   */
  public static final class OnetoOneServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<OnetoOneServiceBlockingStub> {
    private OnetoOneServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnetoOneServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnetoOneServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public com.example.grpc.OnetoOneproto.Response oneToOneCall(com.example.grpc.OnetoOneproto.Request request) {
      return blockingUnaryCall(
          getChannel(), getOneToOneCallMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Defining a Service, a Service can have multiple RPC operations
   * </pre>
   */
  public static final class OnetoOneServiceFutureStub extends io.grpc.stub.AbstractFutureStub<OnetoOneServiceFutureStub> {
    private OnetoOneServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnetoOneServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnetoOneServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.OnetoOneproto.Response> oneToOneCall(
        com.example.grpc.OnetoOneproto.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getOneToOneCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ONE_TO_ONE_CALL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OnetoOneServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OnetoOneServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ONE_TO_ONE_CALL:
          serviceImpl.oneToOneCall((com.example.grpc.OnetoOneproto.Request) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.OnetoOneproto.Response>) responseObserver);
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

  private static abstract class OnetoOneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OnetoOneServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.OnetoOneproto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OnetoOneService");
    }
  }

  private static final class OnetoOneServiceFileDescriptorSupplier
      extends OnetoOneServiceBaseDescriptorSupplier {
    OnetoOneServiceFileDescriptorSupplier() {}
  }

  private static final class OnetoOneServiceMethodDescriptorSupplier
      extends OnetoOneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OnetoOneServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OnetoOneServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OnetoOneServiceFileDescriptorSupplier())
              .addMethod(getOneToOneCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
