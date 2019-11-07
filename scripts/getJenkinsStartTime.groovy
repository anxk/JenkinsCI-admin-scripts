// Get jenkins start time.

import java.util.Date;
import hudson.ExtensionList;

Long timestamps = ExtensionList.lookup(Uptime)[0].getStartTime();
Date date = new Date(timestamps)
println(date)

