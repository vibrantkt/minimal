package org.vibrant.example.minimal


import org.vibrant.core.node.JSONRPCNode
import org.vibrant.core.node.RemoteNode

class Node(port: Int) : JSONRPCNode<Peer>(){
    private val rpc = RPC(this)

    override val peer: Peer = Peer(port, this.rpc)

    internal var chain = Chain()


    fun sync(remoteNode: RemoteNode){
        this.rpc.synchronize(remoteNode)
    }
}