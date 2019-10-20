// Clear the allocated locks by plugin lock-resources.
import org.jenkins.plugins.lockableresources.*


def resourceStrPattern = '.*test.*'
def jenkins = Jenkins.get()
def resourceManager = jenkins.getDescriptorOrDie(LockableResourcesManager.class)
def resources = resourceManager.getResources()
Iterator<LockableResource> iterator = resources.iterator()

// remove the matched lock resources
while(iterator.hasNext()) {
    def r = iterator.next()
    if(r.toString().toLowerCase() ==~ resourceStrPattern) {
        iterator.remove()
    }
}

// save the changes
resourceManager.save()

// print how many lock resources does it clean
println "before clean: total resources: " + resources.size
println "after clean: total resources: " + resourceManager.getResources().size
