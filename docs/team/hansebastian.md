---
layout: page
title: Hans Sebastian Tirtaputra's Project Portfolio
---

### Project: Homerce
Homerce is an all-in-one application that helps home-based beauty salon owners consolidate their business details - 
such as their schedule, appointments, clients, and services - into a single application. It also keeps track of the business's
revenue and expenses, and supports simple visualization of monthly finances.
The application uses a Command Line Interface (CLI).

#### Overview
This portfolio aims to document the contributions that I have made to Homerce. In this project, our team - Homerce,
will enhance a basic CLI Address Book 3 (AB3) and repurpose it to create our application: Homerce.

#### Summary of contributions

Click [here](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=hansebastian&tabRepo=AY2021S1-CS2103T-W13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)
to view Hans' code contributions.

##### Enhancements Implemented: <br>
Here is a summary of the enhancements that I have implemented.

###### 1. Implementation of Service Manager <br>
The service manager was implemented to help users keep manage all the services that their home-based beauty salon provides. These services are used to create appointments with clients.

1. Implementation of 5 basic commands (Pull Request [#88](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/88), [#94](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/94), [#95](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/95),
 [#103](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/103), [#104](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/104))
    * `addsvc` command to add a service to the service manager
    * `editsvc` command to edit a service in the service manager
    * `deletesvc` command to delete a service from the service manager
    * `listsvc` command to display a list of all services in the service manager
    * `clearsvc` command to clear all the services from the service manager

1. Additional commands for extra functionality
    * `findsvc` command to find a specific set services based on the service code or title attribute (Pull Request [#105](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/105))

1. Implementation of service code generation<br>
    * Implemented a feature to automatically generate service codes for the services added, so that users do not have to manually add a service code for
    each service added. (Pull Request [#150](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/150))
    * For example, when the user adds the first service to the service manager, the first service will have a service code of "SCOOO" automatically
    generated and assigned to that service.

###### 2. Implementation of undo Feature <br>
The undo feature was implemented to allow the user to easily recover from command mistakes that they make, giving them a better user experience when using Homerce. (Pull Request [#151](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/151))

All the above features include the implementation of components from __Logic__, __Storage__, and __Model__.

###### 3. Enhancement of GUI
1. Created the Service Card and Service Panel for Service Manager GUI (Pull Request [#88](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/88))
1. Created the GUI for `breakdownfinance` window (Pull Request [#189](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/189))

###### 4. Testing 
1. Included JUnit Tests for the Service Manager, Service attributes with over 90% line coverage on average (Pull Request [#195](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/195))
1. Included Integration Tests across logic, model and storage components for the Service Manager (Pull Request [#225](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/225))
1. Included JUnit Tests for History Manager, and undo command (Pull Request [#222](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/222))
1. Direct testing from GUI

###### 5. Others
1. Contributed to team-tasks such as setting up of GitHub team organization and repository and managing the releases of some versions of Homerce.

**Contributions to User Guide:** <br>
1. Service Manager (Pull Request [#62](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/62))
    * Command Parameter Summary Table
    * Commands Documentation, including command parameters, command format, command examples, and command outcomes with annotated screenshots (Pull Request [#324](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/324))
    * Command Summary 
1. Schedule Viewer and Financial Overview Feature (Pull Request [#211](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/211))
    * Command Parameter Summary Table
    * Commands Documentation, including command parameters, command format, command examples, and command outcomes with annotated screenshots
    * Command Summary 
1. Undo Feature (Pull Request [#173](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/173))

**Contributions to Developer Guide:** <br>
1. List Manager and List Tracker (Pull Request [#171](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/171))
    * Rationale
    * Current implementation
    * Design considerations
    * Class Diagram for List Manager and List Tracker
1. Service Manager (Pull Request [#219](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/219))
    * Rationale
    * Current implementation
    * Design considerations
    * Sequence and Activity diagrams for `addsvc` command
1. Finance Breakdown (Pull Request [#219](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/219))
    * Rationale
    * Current implementation
    * Design considerations
    * Sequence and Activity diagrams for `addsvc` command

##### Contributions to documentation (Extracts)
The contributions listed in this section will not be extensive, please refer to the respective documents for the full contributions.

**Developer Guide**

<u>Diagrams</u>
![Activity diagram for addsvc command](../images/service/AddServiceActivityDiagram.png)

_Figure 1. Activity Diagram for `sortexp` command_

![Sequence diagram for addsvc command](../images/service/AddServiceSequenceDiagram.png)

_Figure 2. Sequence Diagram for `sortexp` command_

```
When the user enters the `addsvc` command to add a new service, the user input command undergoes the same command parsing as described in 
Section 3.3 Logic Component. During the execution of `AddServiceCommand`, Homerce will check the existing service codes from the
services in both the list of services and appointments. From the existing list of service codes, Homerce will then generate the
next smallest service code ranging from "SC000" to "SC999". For example, if Homerce already has an existing list of services from the service or appointments list  with
service codes "SC000", "SC001", and "SC005", the next service code generated during the execution of `AddServiceCommand` would be
"SC002".

The following steps will describe the execution of the `AddServiceCommand` in detail, assuming that no errors are encountered.
1. When the `execute()` method of the `AddServiceCommand` is called, the `ModelManager`'s `getFilteredServiceList()` and `getFilteredAppointmentList()` method are called.
2. The `ModelManager` will return a list of services and appointments provided by Homerce to the `AddServiceCommand`.
3. The `ServiceCodeGenerator` will use the list of services and appointments provided and call the `generateServiceCode()` method.
4. The `ServiceCodeGenerator` will return a unique service code, which is assigned to the service being added.
5. The `Model` is updated to include the newly added service by calling the `addService()` method of the `ModelManager`, which proceeds to call the `addService()` method of the `ServiceManager`.
6. The `Ui` component will detect this change and update the GUI.
7. Assuming that the above steps are all successful, the `AddServiceCommand` will then create a `CommandResult` object and return the result.
```

_Extract 1. Description of Sequence Diagram for the `addsvc` command_

```
**Aspect: Identifying each service with a unique service code**

|              | **Pros**   | **Cons** |
| -------------|-------------| -----|
| **Option 1** <br> Omit the use of service codes to identify a service. | Arguably more user-friendly to identify services by its title instead of a service code. | Unable to uniquely identify services, resulting in complications when executing commands which require services. <br> For example adding an appointment for a service "Manicure" when there are two "Manicure" services provided by Homerce but with different prices and durations. |
| **Option 2 (current choice)** <br> Tag each service with a unique service code. | Allows users to easily identify services uniquely. | Limits the number of services that can be added to Homerce depending on the format of the service code |

Reason for choosing option 2:
* It is important for users to be able to uniquely identify services the user may want to have multiple services with the same title, but with different prices or durations.
* The current format of a service code allows for 1000 unique services to be created since service codes are recycled when a service is deleted. This would be more than sufficient all home-based businesses to add all the services that they provide.
```

_Extract 2. Design Consideration for Having a Service Code for each Service_

**User Guide**

```
You can use this command to add a new service Homerce.

Format: `addsvc t/TITLE du/DURATION p/PRICE`

<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>
 
* Refer to [Service Management Command Parameters](#411-service-management-command-parameters) for more details about each parameter.

</div>

Example:
Let's say you have a service with the following information you want to add into Homerce. You can follow these instructions.

| Service | |
|---------|--------- |
|`TITLE`| Lash Lift |
|`DURATION`| 0.5 |
|`PRICE`| 38 |

Adding the above service:
1. Type `addsvc t/Lash Lift du/0.5 p/38` into the *Command Box*.
2. Press `Enter` to execute.

Outcome:
1. The *Result Display* will show success message.
2. Homerce will switch to the *Services Tab*.
![addsvc](images/addsvc.png) <br>
*Figure x - GUI outcome for `addsvc`*

3. You can now see all your services including the newly added service.
```
_Extract 1. `addsvc` command description_

```
### 6.1 Service Management Commands

|Action | Format | Examples
|---------|---------|---------
|**Add** | `addsvc t/TITLE d/DURATION p/PRICE` | `addsvc t/Lash Lift d/0.5 p/38`
|**Edit** | `editsvc INDEX s/SERVICE_CODE [t/TITLE]* [d/DURATION]* [p/PRICE]*` | `editsvc 1 d/0.5`
|**Delete** | `deletesvc INDEX s/SERVICE_CODE` | `deletesvc 1`
|**Find** | `findsvc KEYWORD` | `findsvc t/lash`
|**List** | `listsvc` | 
|**Clear** | `clearsvc` | 
```
_Extract 2. Command Summary of Service Management_
