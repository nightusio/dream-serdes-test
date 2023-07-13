package cc.dreamcode.template.test;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;

public class TestSerdes implements ObjectSerializer<Test> {

    @Override
    public boolean supports(@NonNull Class<? super Test> type) {
        return Test.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NonNull Test object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
        data.add("testString", object.getTestString());
        data.add("testNumber", object.getTestNumber());
    }

    @Override
    public Test deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
        return new Test(
                data.get("testNumber", int.class),
                data.get("testString", String.class)
        );
    }
}