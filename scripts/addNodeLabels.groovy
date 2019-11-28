#!/bin/groovy
// add labels to specific node set

def targetNodeNames = ['test1', 'test2']
def additionalLabels = 'testLabel'

def h = Jenkins.get()
h.nodes.each {
	if (it.name in targetNodeNames) {
		it.setLabelString(it.getLabelString() + ' ' + additionalLabels)
                it.save()
	}
}
