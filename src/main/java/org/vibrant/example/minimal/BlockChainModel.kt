package org.vibrant.example.minimal


/**
 * You can add static difficulty or meta information.
 */
data class BlockChainModel(internal val blocks: List<MyBlock>) : org.vibrant.core.models.blockchain.BlockChainModel()
