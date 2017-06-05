windows本地环境
#本地Redis
cd D:\JohnnyWorkSpace\softInstalled\redis
redis-server.exe redis.windows.conf
保持server窗口，新打开cmd
redis-cli.exe

##本地zookeeper
cd D:\JohnnyWorkSpace\softInstalled\zookeeper3.3.6\zookeeper-3.3.6\bin
zkServer.cmd

##本地kafka
cd D:\JohnnyWorkSpace\softInstalled\kafka2.10\kafka_2.10-0.10.2.1
.\bin\windows\kafka-server-start.bat .\config\server.properties