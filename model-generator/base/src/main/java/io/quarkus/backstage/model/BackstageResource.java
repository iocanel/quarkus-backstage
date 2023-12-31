package io.quarkus.backstage.model;

public interface BackstageResource {

    String BACKSTAGE_IO_V1BETA1 = "backstage.io/v1beta1";

    default String getKind() {
        throw new UnsupportedOperationException();
    }

    default String getApiVersion() {
        return BACKSTAGE_IO_V1BETA1;
    }

}
