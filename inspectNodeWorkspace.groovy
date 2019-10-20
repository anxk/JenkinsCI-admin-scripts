// node 目录占用查看
def nodes = Jenkins.instance.getNodes()
nodes.each {if(!(it.name =~ 'mesos')) {print it.name; print ' --> '; println it.toComputer().getWorkspaceList().inUse.keySet()}}
return