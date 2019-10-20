// lock-resources-clear
import org.jenkins.plugins.lockableresources.*

def resourceManager = Jenkins.get().getDescriptorOrDie(LockableResourcesManager.class)
def resources = resourceManager.getResources()
Iterator<LockableResource> iterator = resources.iterator()
while(iterator.hasNext()) {
    def r = iterator.next()
    if(r.toString().toLowerCase() ==~ '.*techm.*|controlplandelay.*') {
        iterator.remove()
    }
}
resourceManager.save()
println "# total resources: " + resources.size
resources.each {println it.toString().split('/')[-3..-1].join('/')}
