---
layout: page
title: Wei Kit Khoong's Project Portfolio
---

## Project: Homerce
Homerce is an all-in-one application that helps home-based beauty salon owners consolidate their business details - 
such as their schedule, appointments, clients, and services - into a single application. It also keeps track of the business's
revenue and expenses, and supports simple visualization of monthly finances.
The application uses a Command Line Interface (CLI).

## Overview
This portfolio aims to document Wei Kit's contributions to Homerce. In this project, our team - Homerce,
will enhance a basic CLI Address Book 3 (AB3) and repurpose it to create our application: Homerce.

## Summary of contributions
Click [here](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=khoongwk&tabRepo=AY2021S1-CS2103T-W13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)
to view Wei Kit's code contributions.

####Enhancements Implemented:
##### 1. Implementation of Appointment Manager
The appointment manager is a core feature of Homerce. It uses the features of the service manager, client manager,
and revenue tracker to create a cohesive experience for users to keep track of upcoming appointments with their clients
and to record revenues from services once these appointments are done. 

1. Implemented 6 basic commands which form the core features of the appointment manager: `addapt`, `editapt`, `deleteapt`,
`clearapt`, `listapt` and `findapt` to perform CRUD operations on appointments. (Pull request [#101](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/101))
        
1. Additional commands for extra functionality (Pull request [#163](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/163)):
    * `done` command to mark an appointment as done and record the revenue associated with the service into the revenue tracker.
    * `undone` command to mark an appointment as not done and delete the revenue associated with the service from the revenue tracker.   
    
##### 2. Enhancement of Appointment Manager
* Implemented the logic to order appointments chronologically when changes are made to the list of appointments stored in the appointment manager.
(Pull request [#161](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/161))

* Implemented the logic to check for clashing appointments when an appointment to be added or edited is clashing with the date and time
of another existing appointment. (Pull request [#174](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/174))

##### 3. Pagination of Appointments Schedule
Implemented 3 commands to handle pagination of the schedule view (Pull request [#200](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/200)):
* `schedule` command to navigate to the schedule tab and display the updated view of appointments for the specified week.
* `nextweek` and `previousweek` commands to navigate to the next week or previous week of appointments in the schedule view.

##### 4. Tab Switching in the UI
Implemented the logic which causes Homerce to navigate to the relevant view in the user interface when a command is called.
For example, a command to add an appointment will cause Homerce to navigate to the Appointment tab after execution. (Pull request [#160](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/160))

##### 5. Enhancement of Help Command
Added in more details to the help command to reflect the features of Homerce and to provide a link to our user guide. (Pull request [#168](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/168)) 

##### 6. Testing
Included JUnit Tests for the Appointment Manager, with over 90% line coverage on average and including integration tests across logic, model and storage components. (Pull request [#217](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/217), [#236](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/236))

#### Contributions to the User Guide:
1. Appointment Manager (Pull Request [#72](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/72/files))
    * Command Parameter Summary Table
    * Commands Documentation, including command parameters, command format, command examples, and command outcomes with annotated screenshots (Pull Request [#324](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/324))
    * Command Summary 
1. Help Command (Pull request [#177](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/177))
    * Command documentation and summary

#### Contributions to the Developer Guide:
1. Overall structure, product scope and non-functional requirements. (Pull request [#73](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/73))
1. Appointment Manager - Rationale, current implementation, design considerations as well as sequence and activity diagrams for the `done` command. (Pull request [#307](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/307))
1. Update UML diagrams for other managers to include the history manager as a parameter when `execute` is called. (Pull request [#307](https://github.com/AY2021S1-CS2103T-W13-3/tp/pull/307))

#### Contributions to team-based tasks :
1. Management of project milestones and maintenance of the issue tracker.
1. Changed the original AB3 icon to the current icon used by Homerce.
   
#### Review/mentoring contributions:
Commented and/or reviewed 40+ pull requests in the repository. See the full list [here](https://github.com/AY2021S1-CS2103T-W13-3/tp/pulls?q=is%3Apr+is%3Aclosed+commenter%3Akhoongwk+).

#### Contributions beyond the project team:
Made several forum posts on the module repository to provide help to other students. (Issue [#214](https://github.com/nus-cs2103-AY2021S1/forum/issues/214))

#### Contributions to documentation (extracts):
The contributions listed in this section will not be extensive, please refer to the respective documents for the full contributions.

**Developer Guide**
    
![Activity diagram for done command](../images/DoneAppointmentActivityDiagram.png)

_Figure 1. Activity Diagram for `done` command_

![Sequence diagram for done command](../images/DoneAppointmentSequenceDiagram.png)

_Figure 2. Sequence Diagram for `done` command_

```
When the user enters the `done` command to mark an appointment in the list as done, the user input command undergoes the same command parsing as described in
<br>[Section 3.3 Logic Component](#33-logic-component). During the execution of `DoneAppointmentCommand`, Homerce will access the appointment manager to
get the appointment which matches the index specified. The appointment's `Status` is marked as done, and a `Revenue` entry
is created and stored in the Revenue Tracker.
<br>
The following steps will describe the execution of the `DoneAppointmentCommand` in detail, assuming that no errors are encountered.
1. When the `execute()` method of the `DoneAppointmentCommand` is called, the `Model`'s `getFilteredAppointmentList` method
is called to retrieve the current list of `Appointment`s.
2. Using the index supplied by the user, the appointment to be marked done is selected.
3. The `Appointment` is marked as done using the `markDone` method.
4. A new `Revenue` entry is created with the `Appointment`'s `Service` and `Date` supplied as parameters to the constructor.
5. The `Revenue` is added into the Revenue Tracker using the `Model`'s `addRevenue` method.
6. The list of `Appointment`s in the `Model` is updated and the schedule is refreshed using the `Model`'s `updateFilteredAppointmentList`
and `refreshSchedule` methods.
7. The `Ui` component will reflect these changes in the GUI.
```
_Extract 1. Workflow of a `done` command_

**User Guide**

```$xslt
#### 4.2.2. Add an appointment: `addapt`

When a new or existing client calls to make a booking for your services, use this
command to add details of the appointment into the appointment tracker.

Format : `addapt dt/DATE t/TIME s/SERVICE_CODE p/PHONE_NUMBER`

<div markdown="block" class="alert alert-info"> 

**:information_source: Note:**<br>
 
* Refer to [Appointment Tracker Command Parameters](#421-appointment-tracker-command-parameters) for more details about each parameter.

</div> 

Example:

Let's say your client called to make an appointment.
You can follow these instructions to add his/her appointment details into Homerce.

| Appointment | |
|---------|--------- |
|`DATE`| 28-10-2020 |
|`TIME`| 1300 |
|`SERVICE_CODE`| SC001 |
|`PHONE_NUMBER`| 83232656 |

Steps:
1. Type `addapt dt/28-10-2020 t/1300 s/SC001 p/83232656` in the *Command Box*.
1. Press `Enter` on your keyboard.

Outcome:
1. The *Result Display* will show a success message.
1. Homerce will switch to the *Appointment Tab*.
1. You can now see all your appointments including the newly added appointment.
```
_Extract 2. Guide to adding an appointment into Homerce._
