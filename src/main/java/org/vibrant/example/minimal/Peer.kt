package org.vibrant.example.minimal

import org.vibrant.core.node.http.HTTPJsonRPCPeer
import org.vibrant.core.node.http.HTTPPeerConfig
import org.vibrant.core.rpc.json.JSONRPC

class Peer(port: Int, rpc: JSONRPC) : HTTPJsonRPCPeer(port, rpc, DefaultHTTPPeerConfig)
