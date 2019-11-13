// Inspect all nodes with assigned labels

Jenkins.get().getNodes().each {
  println "Node Name: ${it.name}, Assigned Label ${it.getLabelString()}"
  
}
return
