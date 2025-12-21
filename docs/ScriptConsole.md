一些脚本命令

```
// 输出groovy版本
println GroovySystem.version

// 输出所有插件
println(Jenkins.instance.pluginManager.plugins)

// 输出所有job
println(Jenkins.instance.getAllItems())

// 输出所有job的配置信息
Jenkins.instance.getAllItems().each {
  println it.configFile.file
}

// 取消所有队列任务
Jenkins.instance.queue.clear()
```

## 相关文档

[Jenkins Script Console](https://www.jenkins.io/doc/book/managing/script-console/)
