# Netty-Learn

## 前言
众所周知，Netty是一款非常流行的网络编程框架，其高并发、低延迟、成熟稳定，
易上手的特点，使开发人员无需关注太多的IO网络操作以及性能问题，专注于业务开发。

本项目旨在提供Netty的Demo供大家学习，涵盖多种协议支持，自定义解码编码器等等。

## 测试工具
大家可以自己写客户端，不过建议直接用现成的。我这里提供常用的Socket测试工具，
见项目utils目录。

## Protobuf
见Netty-Protobuf模块，protoc.exe程序把.proto文件生成java代码，执行指令
**protoc --java_out=./ ./NettyProtobuf.proto**（以我提供的文件为例）。
对PB协议不了解的可以自行学习。

## Netty对Protobuf多种协议支持
...
