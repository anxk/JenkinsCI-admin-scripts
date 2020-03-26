import jenkins.branch.NoTriggerBranchProperty
import jenkins.branch.DefaultBranchPropertyStrategy
import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject

ITEM = ""
count = 0

jenkins = Jenkins.get()
if (ITEM == "") {
	allItems = jenkins.getAllItems()
} else {
	allItems = jenkins.getItemByFullName(ITEM).getAllItems()
}
allItems.each {
	if (it instanceof WorkflowMultiBranchProject) {
		it.getSourcesList().each {
			if (! it.getStrategy().properties.props.any{it instanceof NoTriggerBranchProperty}) {
				noTriggerBranchProperty = new NoTriggerBranchProperty()
				it.setStrategy(new DefaultBranchPropertyStrategy(noTriggerBranchProperty))
				println "add ${count++} ${NoTriggerBranchProperty.class.name}"
			}
		}
		it.save()
	}
}
