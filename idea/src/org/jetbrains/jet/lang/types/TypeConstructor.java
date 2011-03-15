package org.jetbrains.jet.lang.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author abreslav
 */
public class TypeConstructor extends AnnotatedImpl {
    private final List<TypeParameterDescriptor> parameters;
    private final Collection<? extends JetType> supertypes;
    private final String debugName;
    private final boolean sealed;

    @Nullable
    private final DeclarationDescriptor declarationDescriptor;

    public TypeConstructor(
            @Nullable DeclarationDescriptor declarationDescriptor,
            @NotNull List<Attribute> attributes,
            boolean sealed,
            @NotNull String debugName,
            @NotNull List<TypeParameterDescriptor> parameters,
            @NotNull Collection<? extends JetType> supertypes) {
        super(attributes);
        this.declarationDescriptor = declarationDescriptor;
        this.sealed = sealed;
        this.debugName = debugName;
        this.parameters = new ArrayList<TypeParameterDescriptor>(parameters);
        this.supertypes = supertypes;
    }

    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return parameters;
    }

    @NotNull
    public Collection<? extends JetType> getSupertypes() {
        return supertypes;
    }

    @Override
    public String toString() {
        return debugName;
    }

    public boolean isSealed() {
        return sealed;
    }

    @Nullable
    public DeclarationDescriptor getDeclarationDescriptor() {
        return declarationDescriptor;
    }
}
