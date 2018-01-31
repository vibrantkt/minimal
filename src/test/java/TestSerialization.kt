
import org.junit.Assert.assertEquals
import org.junit.Test
import org.vibrant.example.minimal.Chain
import org.vibrant.example.minimal.MyBlock
import org.vibrant.example.minimal.serializerFor

class TestSerialization {


    @Test
    fun `Test serializer instance creator`(){
        val block = Chain.genesis

        kotlin.run {
            val serializer = serializerFor<MyBlock>()
            val serialized = serializer.serialize(block)
            val deserialized = serializer.deserialize(serialized)
            assertEquals(
                    block,
                    deserialized
            )
        }
    }
}