def targetComputerPattern = 'mesos'
def nodes = Jenkins.get().nodes
nodes.each {
	if(it.name =~ targetComputerPattern) {
		it.toComputer().getExecutors().each {
			def executable = it.getCurrentExecutable()
			if (executable != null) {
				println "${it.getOwner().getDisplayName(), ${executable.url.replace('job/', '')}}"
			}
		}
	}
}
