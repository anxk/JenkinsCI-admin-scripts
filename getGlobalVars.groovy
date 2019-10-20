// Get global vars.
import hudson.slaves.EnvironmentVariablesNodeProperty


def jenkins = Jenkins.get()
def global = jenkins.getGlobalNodeProperties()[0]
def globalVars = global.getEnvVars()
globalVars.each {
    k, v -> println "$k : $v"
}
