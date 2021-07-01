# gateway-server 压测

## JVM 启动参数
```
java -jar gateway-server-0.0.1-SNAPSHOT.r --server.port=80
```

## 压测

#### 压测命令
```
wrk -c40 -d30 http://localhost/api/hello
```

#### 压测结果
```
Running 30s test @ http://localhost/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.62ms   11.61ms 306.24ms   96.47%
    Req/Sec    23.62k     7.69k   40.39k    72.95%
  1409195 requests in 30.05s, 168.24MB read
Requests/sec:  46900.24
Transfer/sec:      5.60MB
```