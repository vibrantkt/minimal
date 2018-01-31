package org.vibrant.example.minimal

import mu.KLogger
import mu.KotlinLogging
import org.vibrant.core.database.blockchain.BlockChain
import org.vibrant.core.database.blockchain.InMemoryBlockChain
import org.vibrant.core.database.blockchain.InstantiateBlockChain
import org.vibrant.core.models.transaction.HashedTransactionModel
import org.vibrant.core.rpc.json.JSONRPC
import org.vibrant.core.rpc.json.JSONRPCBlockChainSynchronization
import org.vibrant.core.serialization.ConcreteModelSerializer
import java.util.*

/**
 * That's a mess, but it is only logic is present. You can agree it's not that much of code for full working network node.
 * <3
 */
class RPC(override val node: Node) : JSONRPC(),
        JSONRPCBlockChainSynchronization<Peer, MyBlock, HashedTransactionModel, org.vibrant.example.minimal.BlockChainModel> {

    override val blockSerializer: ConcreteModelSerializer<MyBlock> = serializerFor()

    override val chainSerializer: ConcreteModelSerializer<BlockChainModel> = serializerFor()

    override val transactionSerializer: ConcreteModelSerializer<HashedTransactionModel> = serializerFor()

    override fun handleDistinctTransaction(transaction: HashedTransactionModel) {
        TODO("Maybe some proof of work")
    }


    override var broadcastedBlocks = ArrayList<String>()
        internal set

    override var broadcastedTransactions = ArrayList<String>()
        internal set

    override val chain: InMemoryBlockChain<MyBlock, BlockChainModel>
        get() = node.chain

    override val logger: KLogger = KotlinLogging.logger {  }

    override val modelToProducer = object: InstantiateBlockChain<MyBlock, BlockChainModel>{
        override fun asBlockChainProducer(model: BlockChainModel): BlockChain<MyBlock, BlockChainModel> {
            return Chain().apply { this.dump(model) }
        }

    }


}
