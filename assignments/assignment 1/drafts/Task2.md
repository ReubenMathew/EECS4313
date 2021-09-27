## Task 2

### 3.2 Issue Reports in HBase

#### 1. There are various kinds of issue reports in HBase (e.g., bugs, enhancements, tasks, etc.). Each issue report can be in different stages (e.g., open, closed, fixed, etc.) Among all these issue reports, which belong to the “bug” type, how many of them are there in total?

| Total Issues | 17257 |
|-------------------------|---|

| Issue Type 'Bug' | 8614 |
|-------------------------|---|

#### 2. Among the total number of “bugs”, give a quantitative report on their current state. In other words, report the number of bug reports which are in different states (a.k.a., open, closed, or fixed, etc.).

Out of the total number of issues that are of type : Bug, their current status distribution is displayed below

| Status      | Closed | Open | Patch Available | Resolved | Reopened | In Progress |
|-------------|-------:|-----:|----------------:|---------:|---------:|-------------|
| Occurrences |  5138  |  691 |       136       |   2615   |    27    |      7      |

#### 3. Among the “bug type” issue reports, which are either “fixed” or “closed”, what are minimum, average, median, and maximum bug resolution time?

Among the bug type issue reports the different aggregations for the resolution times are 

| Minimum Resolution Time | 0.00016203703703703703 days |
|-------------------------|---|

| Maximum Resolution Time | 2960.6483680555557 days |
|-------------------------|---|

| Median Resolution Time | 3.9349421296296296 days |
|-------------------------|---|

| Average Resolution Time | 102.98669511443599 days |
|-------------------------|---|

#### How I Obtained the Following Results

This was done using the xml.dom API in order to parse the XML files. For the first part what I did was increrment through all the XML files and search for the 'type' tag in each file. I would then format it and see if the type was 'Bug' or not. After doing so I would have the amount of issues that were bugs. For the second part I would keep a dictionary to hold the count for each status in 'Bug' type issues. In the same incrementing of the files from the first part I would just add to the dictionary the value on tag 'status' if it was of type 'Bug' or not. Afterwards I could easily display all the value pairs showing the distribution of statuses in Bug type issues. Finally for the last part I made use of the datetime API in order to format the dates in the XML file. Again in the same incrementing of the files instead of considering all statuses that were of Bug type issue, I would only care about Resolved or Closed statuses. From there I would get the created time and the resolved time from the 'created' and 'resolved' tags. Then I would find the difference in seconds using the two datetime objects to find the exact resolution time in seconds. Finally, I would get the different aggregations of those values and divide by the amount of seconds in a day to represent all the resolution time values in days. I did it in days becuase thats how jira represents their estimate times

```python
import glob
import datetime
from statistics import median
from xml.dom import minidom
from pathlib import Path

month_lookup = {
    'Jan': 1,
    'Feb': 2,
    'Mar': 3,
    'Apr': 4,
    'May': 5,
    'Jun': 6,
    'Jul': 7,
    'Aug': 8,
    'Sep': 9,
    'Oct': 10,
    'Nov': 11,
    'Dec': 12,
}


# Helper Functions for Formatting Purposes
def getText(nodelist):
    rc = []
    for node in nodelist:
        if node.nodeType == node.TEXT_NODE:
            rc.append(node.data)
    return ''.join(rc)


downloads_path = str(Path.home() / "Downloads")
allFiles = downloads_path + '\hbaseBugReport\*.xml'

bugIssues = 0
totalIssues = 0
statusCount = {}
resolveTimes = []

for file in glob.glob(allFiles):
    parsedXML = minidom.parse(file)
    issueType = parsedXML.getElementsByTagName('type')[0]
    issueStatus = parsedXML.getElementsByTagName('status')[0]
    issueCreateTime = parsedXML.getElementsByTagName('created')[0]
    if getText(issueType.childNodes) == "Bug":
        bugIssues += 1
        currStatus = getText(issueStatus.childNodes)
        if currStatus in statusCount:
            statusCount[currStatus] += 1
        else:
            statusCount[currStatus] = 1

        if currStatus == "Resolved" or currStatus == "Closed":
            issueResolveTime = parsedXML.getElementsByTagName('resolved')[0]

            createdTime = getText(issueCreateTime.childNodes).split()
            createdHourlyTime = createdTime[4].split(':')

            resolvedTime = getText(issueResolveTime.childNodes).split()
            resolvedHourlyTime = resolvedTime[4].split(':')

            # datetime(year, month, day, hour, minute, second)
            # Formatted on XML as (Fri, 1 Feb 2008 21:23:06 +0000)
            createTime = datetime.datetime(int(createdTime[3]), int(month_lookup.get(createdTime[2])), int(createdTime[1]),
                                           int(createdHourlyTime[0]), int(createdHourlyTime[1]), int(createdHourlyTime[2]))
            resolveTime = datetime.datetime(int(resolvedTime[3]), int(month_lookup.get(resolvedTime[2])), int(resolvedTime[1]),
                                            int(resolvedHourlyTime[0]), int(resolvedHourlyTime[1]), int(resolvedHourlyTime[2]))

            resolutionTime = resolveTime - createTime
            resolveTimes.append(resolutionTime.total_seconds())

    totalIssues += 1

print("1. Out of " + str(totalIssues) + " total issues, " + str(bugIssues) + " of them are of type : Bug")
print('\n')
print("2. Out of the total number of issues that are of type : Bug, their current status distribution is displayed "
      "below")
for item in statusCount.items():
    print("Bug issues with status " + item[0] + " occurs " + str(item[1]) + " times")
print('\n')
print("3. Among the bug type issue reports the different aggregations for the resolution times are ")
print("Minimum Resolution Time " + str(min(resolveTimes) / 86400) + " days")
print("Maximum Resolution Time " + str(max(resolveTimes) / 86400) + " days")
print("Median Resolution Time " + str(median(resolveTimes) / 86400) + " days")
print("Average Resolution Time " + str((sum(resolveTimes) / len(resolveTimes)) / 86400) + " days")
```