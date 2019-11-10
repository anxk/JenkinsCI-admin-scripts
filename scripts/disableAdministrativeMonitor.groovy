// disable specific AdministrativeMonitor example

import hudson.diagnosis.*

Jenkins j = Jenkins.get();
j.getExtensionList(AdministrativeMonitor)
    .lookup(TooManyJobsButNoView)[0]
    .disable(true)
