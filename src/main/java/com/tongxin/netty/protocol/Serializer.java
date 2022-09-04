package com.tongxin.netty.protocol;

import com.google.gson.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @Title: Serializer
 * @ProjectName: NettyReview
 * @date: 2022/3/22 17:28
 * @author: Luo
 */
@Component
public interface Serializer {
    /**
     * 反序列化算法
     */
    <T> T deserializer(Class<T> clazz, byte[] bytes);
    /**
     * 序列化算法
     */
    <T> byte[] serializer(T object);

    enum Algorithm implements Serializer {
        Json {
            @Override
            public <T> T deserializer(Class<T> clazz, byte[] bytes) {
                Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassCodec()).create();
                String json = new String(bytes, StandardCharsets.UTF_8);
                return gson.fromJson(json, clazz);
            }

            @Override
            public <T> byte[] serializer(T object) {
                Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassCodec()).create();
                String json = gson.toJson(object);
                return json.getBytes(StandardCharsets.UTF_8);
            }
        }
    }

    /**
     * Gson转换器，针对于类的转换
     */
    class ClassCodec implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>> {
        @Override
        public Class<?> deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                String string = json.getAsString();
                return Class.forName(string);
            } catch (ClassNotFoundException e) {
                throw new JsonParseException(e);
            }
        }

        @Override
        public JsonElement serialize(Class<?> aClass, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(aClass.getName());
        }
    }
}
