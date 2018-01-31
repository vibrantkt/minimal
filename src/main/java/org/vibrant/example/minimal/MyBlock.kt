package org.vibrant.example.minimal

import org.vibrant.core.models.block.ClassicBlockModel

/**
 * Feel free to expand by adding transactions or some more meta information.
 */
data class MyBlock(override val index: Long, override val hash: String, override val previousHash: String) : ClassicBlockModel(index, hash, previousHash)