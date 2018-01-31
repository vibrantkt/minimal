package org.vibrant.example.minimal

import org.vibrant.core.models.block.ClassicBlockModel

data class MyBlock(override val index: Long, override val hash: String, override val previousHash: String) : ClassicBlockModel(index, hash, previousHash)