// Cancel builds in the queue if it is stuck.

def jenkins = Jenkins.get()
def items = jenkins.queue.getItems()
items.each {
    if (it.isStuck()) {
        println "${it}: is stuck, cancel..."
        jenkins.queue.cancel(it)
    }
}
println 'all done!'
