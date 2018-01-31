package org.vibrant.example.minimal

import org.vibrant.core.node.http.HTTPJsonRPCPeer
import org.vibrant.core.rpc.json.JSONRPC

/**
 * Everything done here. You can add some less abstract methods or smf
 */
class Peer(port: Int, rpc: JSONRPC) : HTTPJsonRPCPeer(port, rpc, DefaultHTTPPeerConfig)
