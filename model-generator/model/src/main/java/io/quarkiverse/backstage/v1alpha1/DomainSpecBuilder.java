package io.quarkiverse.backstage.v1alpha1;

import io.quarkiverse.backstage.model.builder.VisitableBuilder;

public class DomainSpecBuilder extends DomainSpecFluent<DomainSpecBuilder>
        implements VisitableBuilder<DomainSpec, DomainSpecBuilder> {
    public DomainSpecBuilder() {
        this(new DomainSpec());
    }

    public DomainSpecBuilder(DomainSpecFluent<?> fluent) {
        this(fluent, new DomainSpec());
    }

    public DomainSpecBuilder(DomainSpecFluent<?> fluent, DomainSpec instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public DomainSpecBuilder(DomainSpec instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }

    DomainSpecFluent<?> fluent;

    public DomainSpec build() {
        DomainSpec buildable = new DomainSpec(fluent.getOwner(), fluent.getAdditionalProperties());
        return buildable;
    }

}