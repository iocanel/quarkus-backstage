package io.quarkiverse.backstage.v1alpha1;

import io.quarkiverse.backstage.model.builder.VisitableBuilder;

public class ResourceBuilder extends ResourceFluent<ResourceBuilder> implements VisitableBuilder<Resource, ResourceBuilder> {
    public ResourceBuilder() {
        this.fluent = this;
    }

    public ResourceBuilder(ResourceFluent<?> fluent) {
        this.fluent = fluent;
    }

    public ResourceBuilder(ResourceFluent<?> fluent, Resource instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public ResourceBuilder(Resource instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }

    ResourceFluent<?> fluent;

    public Resource build() {
        Resource buildable = new Resource(fluent.getKind(), fluent.getApiVersion(), fluent.buildMetadata(), fluent.buildSpec(),
                fluent.buildStatus());
        return buildable;
    }

}