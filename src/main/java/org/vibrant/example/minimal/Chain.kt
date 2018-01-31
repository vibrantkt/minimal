package org.vibrant.example.minimal

import org.vibrant.core.database.blockchain.InMemoryBlockChain
import org.vibrant.core.serialization.ModelSerializer

/**
 * Simple in memory blockchain.
 */
class Chain : InMemoryBlockChain<MyBlock, BlockChainModel>() {

    override fun checkIntegrity(): Boolean {
        var index = 1
        while (index < this.blocks.size) {
            if (this.blocks[index].previousHash != this.blocks[index - 1].hash || this.blocks[index].index - this.blocks[index - 1].index != 1L) {
                return false
            }
            index++
        }
        return true
    }


    override fun createGenesisBlock(): MyBlock {
        return Chain.genesis
    }

    override fun dump(copy: BlockChainModel) {
        this.blocks.clear()
        this.blocks.addAll(copy.blocks)
    }

    override fun produce(serializer: ModelSerializer): BlockChainModel {
        return BlockChainModel(this.blocks)
    }

    companion object {
        val genesis = MyBlock(0L, "Genesis", "")
    }
}
