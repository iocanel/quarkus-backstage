package io.quarkiverse.backstage.v1alpha1;

import io.quarkiverse.backstage.model.builder.VisitableBuilder;

public class ApiSpecBuilder extends ApiSpecFluent<ApiSpecBuilder> implements VisitableBuilder<ApiSpec, ApiSpecBuilder> {
    public ApiSpecBuilder() {
        this.fluent = this;
    }

    public ApiSpecBuilder(ApiSpecFluent<?> fluent) {
        this.fluent = fluent;
    }

    public ApiSpecBuilder(ApiSpecFluent<?> fluent, ApiSpec instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public ApiSpecBuilder(ApiSpec instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }

    ApiSpecFluent<?> fluent;

    public ApiSpec build() {
        ApiSpec buildable = new ApiSpec(fluent.getType(), fluent.getLifecycle(), fluent.getOwner(), fluent.getSystem(),
                fluent.getDefinition());
        return buildable;
    }

}