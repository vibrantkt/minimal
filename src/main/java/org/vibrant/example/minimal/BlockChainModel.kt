package org.vibrant.example.minimal

data class BlockChainModel(internal val blocks: List<MyBlock>) : org.vibrant.core.models.blockchain.BlockChainModel()
