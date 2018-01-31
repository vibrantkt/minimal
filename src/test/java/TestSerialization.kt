
import org.junit.Assert.assertEquals
import org.junit.Test
import org.vibrant.core.models.transaction.HashedTransactionModel
import org.vibrant.core.serialization.ConcreteModelSerializer
import org.vibrant.example.minimal.BlockChainModel
import org.vibrant.example.minimal.Chain
import org.vibrant.example.minimal.MyBlock
import org.vibrant.example.minimal.serializerFor

class TestSerialization {


    @Test
    fun `Test cb (de)serialization`(){
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

        kotlin.run {

            val blockSerializer: ConcreteModelSerializer<MyBlock> = serializerFor()

            val chainSerializer: ConcreteModelSerializer<BlockChainModel> = serializerFor()

            val transactionSerializer: ConcreteModelSerializer<HashedTransactionModel> = serializerFor()
        }
    }
}