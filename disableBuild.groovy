// Disable any type of projects.

def target = 'test'
Jenkins.get().getItemByFullName(target).setDisabled(true)
//Jenkins.get().getItemByFullName(target).setDisabled(false)
