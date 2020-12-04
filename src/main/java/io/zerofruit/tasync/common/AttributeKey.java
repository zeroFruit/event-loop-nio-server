package io.zerofruit.tasync.common;

/**
 * Key which can be used to access {@link Attribute} out of the {@link AttributeMap}. Be aware that it is not be
 * possible to have multiple keys with the same name.
 */
public class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private AttributeKey(int id, String name) {
        super(id, name);
    }
}
