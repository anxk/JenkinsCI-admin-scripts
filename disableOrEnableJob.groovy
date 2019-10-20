// Disable any type of projects.

def target = 'test'
def jenkins = Jenkins.get()

// now disable it
jenkins.getItemByFullName(target).setDisabled(true)

// enable it
//jenkins.getItemByFullName(target).setDisabled(false)
