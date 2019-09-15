// This script can be used to cancel the build in the queue.

def target = 'testPipeline/95' // replace target with yours
def queue = Jenkins.get().getQueue()
def items = queue.getItems()
for (def item in items) {
    if(item.getUrl() =~ target) {
        queue.cancel(item)
    }
}
