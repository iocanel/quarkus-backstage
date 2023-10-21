package io.quarkus.backstage.model;

import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;

import io.quarkus.backstage.model.builder.BaseFluent;
import io.quarkus.backstage.model.builder.Nested;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DomainFluent<A extends DomainFluent<A>> extends BaseFluent<A> {
    public DomainFluent() {
    }

    public DomainFluent(Domain instance) {
        this.copyInstance(instance);
    }

    private String kind;
    private String apiVersion;
    private EntityMetaBuilder metadata;
    private DomainSpecBuilder spec;
    private StatusBuilder status;

    protected void copyInstance(Domain instance) {
        if (instance != null) {
            this.withKind(instance.getKind());
            this.withApiVersion(instance.getApiVersion());
            this.withMetadata(instance.getMetadata());
            this.withSpec(instance.getSpec());
            this.withStatus(instance.getStatus());
        }
    }

    public String getKind() {
        return this.kind;
    }

    public A withKind(String kind) {
        this.kind = kind;
        return (A) this;
    }

    public boolean hasKind() {
        return this.kind != null;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public A withApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return (A) this;
    }

    public boolean hasApiVersion() {
        return this.apiVersion != null;
    }

    public EntityMeta buildMetadata() {
        return this.metadata != null ? this.metadata.build() : null;
    }

    public A withMetadata(EntityMeta metadata) {
        _visitables.get("metadata").remove(this.metadata);
        if (metadata != null) {
            this.metadata = new EntityMetaBuilder(metadata);
            _visitables.get("metadata").add(this.metadata);
        } else {
            this.metadata = null;
            _visitables.get("metadata").remove(this.metadata);
        }
        return (A) this;
    }

    public boolean hasMetadata() {
        return this.metadata != null;
    }

    public MetadataNested<A> withNewMetadata() {
        return new MetadataNested(null);
    }

    public MetadataNested<A> withNewMetadataLike(EntityMeta item) {
        return new MetadataNested(item);
    }

    public MetadataNested<A> editMetadata() {
        return withNewMetadataLike(java.util.Optional.ofNullable(buildMetadata()).orElse(null));
    }

    public MetadataNested<A> editOrNewMetadata() {
        return withNewMetadataLike(java.util.Optional.ofNullable(buildMetadata()).orElse(new EntityMetaBuilder().build()));
    }

    public MetadataNested<A> editOrNewMetadataLike(EntityMeta item) {
        return withNewMetadataLike(java.util.Optional.ofNullable(buildMetadata()).orElse(item));
    }

    public DomainSpec buildSpec() {
        return this.spec != null ? this.spec.build() : null;
    }

    public A withSpec(DomainSpec spec) {
        _visitables.get("spec").remove(this.spec);
        if (spec != null) {
            this.spec = new DomainSpecBuilder(spec);
            _visitables.get("spec").add(this.spec);
        } else {
            this.spec = null;
            _visitables.get("spec").remove(this.spec);
        }
        return (A) this;
    }

    public boolean hasSpec() {
        return this.spec != null;
    }

    public A withNewSpec(String owner) {
        return (A) withSpec(new DomainSpec(owner));
    }

    public SpecNested<A> withNewSpec() {
        return new SpecNested(null);
    }

    public SpecNested<A> withNewSpecLike(DomainSpec item) {
        return new SpecNested(item);
    }

    public SpecNested<A> editSpec() {
        return withNewSpecLike(java.util.Optional.ofNullable(buildSpec()).orElse(null));
    }

    public SpecNested<A> editOrNewSpec() {
        return withNewSpecLike(java.util.Optional.ofNullable(buildSpec()).orElse(new DomainSpecBuilder().build()));
    }

    public SpecNested<A> editOrNewSpecLike(DomainSpec item) {
        return withNewSpecLike(java.util.Optional.ofNullable(buildSpec()).orElse(item));
    }

    public Status buildStatus() {
        return this.status != null ? this.status.build() : null;
    }

    public A withStatus(Status status) {
        _visitables.get("status").remove(this.status);
        if (status != null) {
            this.status = new StatusBuilder(status);
            _visitables.get("status").add(this.status);
        } else {
            this.status = null;
            _visitables.get("status").remove(this.status);
        }
        return (A) this;
    }

    public boolean hasStatus() {
        return this.status != null;
    }

    public StatusNested<A> withNewStatus() {
        return new StatusNested(null);
    }

    public StatusNested<A> withNewStatusLike(Status item) {
        return new StatusNested(item);
    }

    public StatusNested<A> editStatus() {
        return withNewStatusLike(java.util.Optional.ofNullable(buildStatus()).orElse(null));
    }

    public StatusNested<A> editOrNewStatus() {
        return withNewStatusLike(java.util.Optional.ofNullable(buildStatus()).orElse(new StatusBuilder().build()));
    }

    public StatusNested<A> editOrNewStatusLike(Status item) {
        return withNewStatusLike(java.util.Optional.ofNullable(buildStatus()).orElse(item));
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        DomainFluent that = (DomainFluent) o;
        if (!java.util.Objects.equals(kind, that.kind))
            return false;

        if (!java.util.Objects.equals(apiVersion, that.apiVersion))
            return false;

        if (!java.util.Objects.equals(metadata, that.metadata))
            return false;

        if (!java.util.Objects.equals(spec, that.spec))
            return false;

        if (!java.util.Objects.equals(status, that.status))
            return false;

        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(kind, apiVersion, metadata, spec, status, super.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (kind != null) {
            sb.append("kind:");
            sb.append(kind + ",");
        }
        if (apiVersion != null) {
            sb.append("apiVersion:");
            sb.append(apiVersion + ",");
        }
        if (metadata != null) {
            sb.append("metadata:");
            sb.append(metadata + ",");
        }
        if (spec != null) {
            sb.append("spec:");
            sb.append(spec + ",");
        }
        if (status != null) {
            sb.append("status:");
            sb.append(status);
        }
        sb.append("}");
        return sb.toString();
    }

    public class MetadataNested<N> extends EntityMetaFluent<MetadataNested<N>> implements Nested<N> {
        MetadataNested(EntityMeta item) {
            this.builder = new EntityMetaBuilder(this, item);
        }

        EntityMetaBuilder builder;

        public N and() {
            return (N) DomainFluent.this.withMetadata(builder.build());
        }

        public N endMetadata() {
            return and();
        }

    }

    public class SpecNested<N> extends DomainSpecFluent<SpecNested<N>> implements Nested<N> {
        SpecNested(DomainSpec item) {
            this.builder = new DomainSpecBuilder(this, item);
        }

        DomainSpecBuilder builder;

        public N and() {
            return (N) DomainFluent.this.withSpec(builder.build());
        }

        public N endSpec() {
            return and();
        }

    }

    public class StatusNested<N> extends StatusFluent<StatusNested<N>> implements Nested<N> {
        StatusNested(Status item) {
            this.builder = new StatusBuilder(this, item);
        }

        StatusBuilder builder;

        public N and() {
            return (N) DomainFluent.this.withStatus(builder.build());
        }

        public N endStatus() {
            return and();
        }

    }

}
