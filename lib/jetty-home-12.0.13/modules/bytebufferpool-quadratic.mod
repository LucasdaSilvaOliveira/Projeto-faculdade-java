# DO NOT EDIT THIS FILE - See: https://jetty.org/docs/

[description]
Configures the ByteBufferPool used by ServerConnectors.
The bucket sizes increase quadratically instead of linearly.

[tags]
bytebufferpool

[provides]
bytebufferpool

[xml]
etc/jetty-bytebufferpool-quadratic.xml

[ini-template]
### Server ByteBufferPool Configuration
## Minimum capacity to pool ByteBuffers
#jetty.byteBufferPool.minCapacity=0

## Maximum capacity to pool ByteBuffers
#jetty.byteBufferPool.maxCapacity=65536

## Maximum size for each bucket (-1 for unbounded)
#jetty.byteBufferPool.maxBucketSize=-1

## Maximum heap memory held idle by the pool (0 for heuristic, -1 for unlimited).
#jetty.byteBufferPool.maxHeapMemory=0

## Maximum direct memory held idle by the pool (0 for heuristic, -1 for unlimited).
#jetty.byteBufferPool.maxDirectMemory=0
