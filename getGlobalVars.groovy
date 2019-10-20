// get global vars
import hudson.slaves.EnvironmentVariablesNodeProperty
def global = Jenkins.get().getGlobalNodeProperties()[0]
def globalVars = global.getEnvVars()
globalVars.each {k, v -> println "$k : $v"}