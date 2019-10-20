// Inspect nodes's workspaces in use.

def nodePattern = '.*mesos.*'
def jenkins.get()
def nodes = jenkins.getNodes()
nodes.each {
    if(it.name ==~ nodePattern) {
        print "${it.name}: "
        print it.toComputer().getWorkspaceList().inUse.keySet()
        println ', is in use.'
    }
}
