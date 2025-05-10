package com.htm.subscriptionservice.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import subscription.SubscriptionResponse;
import subscription.SubscriptionServiceGrpc.SubscriptionServiceImplBase;

@GrpcService
public class SubscriptionGrpcService extends SubscriptionServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionGrpcService.class);

    @Override
    public void createSubscriptionAccount(subscription.SubscriptionRequest subscriptionRequest,
                                   StreamObserver<SubscriptionResponse> responseObserver) {

        log.info("createSubscriptionAccount request received {}", subscriptionRequest.toString());

        // Business logic - e.g save to database, perform calculates etc

        SubscriptionResponse response = SubscriptionResponse.newBuilder()
                .setSubscriptionId("12345")
                .setPlanName("FREE")
                .setStatus("ACTIVE")
                .setStartDate("01-02-2025")
                .setEndDate("01-03-2025")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
