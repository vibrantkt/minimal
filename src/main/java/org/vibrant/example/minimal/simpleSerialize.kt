package org.vibrant.example.minimal

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.vibrant.core.models.Model
import org.vibrant.core.serialization.ConcreteModelSerializer

/**
 * Simple function to create instance of serializer/deserializer.
 */
inline fun <reified T: Model> serializerFor(): ConcreteModelSerializer<T> {
    return object: ConcreteModelSerializer<T>(){

        override fun deserialize(serialized: ByteArray): T {
            return jacksonObjectMapper().readValue(serialized, T::class.java)
        }

        override fun serialize(model: Model): ByteArray {
            return jacksonObjectMapper().writeValueAsBytes(model)
        }

    }
}