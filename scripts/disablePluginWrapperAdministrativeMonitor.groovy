// disable specific PluginWrapperAdministrativeMonitor example

import hudson.diagnosis.*

Jenkins j = Jenkins.get();
j.getExtensionList(PluginWrapperAdministrativeMonitor)[0]
    .disable(true)
