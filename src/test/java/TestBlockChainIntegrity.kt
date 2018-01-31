import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.vibrant.example.minimal.Chain
import org.vibrant.example.minimal.MyBlock

class TestBlockChainIntegrity {

    @Test
    fun `Test check integrity method of chain`(){
        kotlin.run {
            val chain = Chain()

            chain.addBlock(
                    MyBlock(1L, "hash1", Chain.genesis.hash)
            )
            assertTrue(
                    chain.checkIntegrity()
            )
        }

        kotlin.run {
            val chain = Chain()

            chain.addBlock(
                    MyBlock(1L, "hash1", "wrong hash")
            )
            // wrong hash
            assertFalse(
                    chain.checkIntegrity()
            )
        }

        kotlin.run {
            val chain = Chain()

            chain.addBlock(
                    MyBlock(2L, "hash1", Chain.genesis.hash)
            )
            // wrong index
            assertFalse(
                    chain.checkIntegrity()
            )
        }

    }

}