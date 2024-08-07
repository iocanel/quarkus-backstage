package io.quarkiverse.backstage.model.builder;

public interface VisitableBuilder<T, V extends VisitableBuilder<T, V>> extends Builder<T>, Visitable<V> {

}