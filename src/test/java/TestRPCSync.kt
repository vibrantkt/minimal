import org.junit.Assert.assertEquals
import org.junit.Test
import org.vibrant.core.node.RemoteNode
import org.vibrant.example.minimal.*

class TestRPCSync {


    @Test
    fun test(){
        val node1 = Node(7000)
        val node2 = Node(7001)

        node1.start()
        node2.start()


        node1.chain.addBlock(
                MyBlock(1, "My hash lol", Chain.genesis.hash)
        )

        node1.connect(RemoteNode("localhost", node2.peer.port))
        node1.sync(RemoteNode("localhost", node2.peer.port))


        assertEquals(
                node1.chain.produce(serializerFor<BlockChainModel>()),
                node2.chain.produce(serializerFor<BlockChainModel>())
        )
    }
}