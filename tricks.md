## Jenkins tricks

* Jenkins Job的配置除了在Jenkins实例化的时候从文件系统加载到内存外，只会在配置更改并手动保存时才会重新持久化到文件系统，
个别时候Job的状态可能不正常，例如：无法触发等，可以重新从文件系统重新加载配置：
```groovy
Jenkins.get().getItemByFullName('test').doReload()
```

* Jenkins 在线更新配置（有风险，Jenkins实例很大时可能会引起重启）：
```groovy
Jenkins.get().doReload()
```