// Release node's workspace.

def jenkins = Jenkins.get()
def nodeName = 'test'
jenkins.getNode(nodeName).toComputer().workspaceList.inUse.clear()
