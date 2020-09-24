---
layout: page
title: User Guide
---

GrAB3 is an **all in one planner application** that provides a simple way for university students to stay ahead of their
busy schedules. The student interacts with the application using a command-line interface (CLI).

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

~~1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).~~

1. Copy the file to the folder you want to use as the _home folder_ for your GrAB3.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1.Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

  * **`ListModuleList`** : Lists all module provided by the university.

  * **`setup`**`un/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1` : Adds a user named `John Doe` and academic year `AY20/21 Sem` that spans from `22-09-2020` to `29-11-2020`.
  
  * **`listtaskschedule`**`2` : List all the user tasks in task schedule for Week 2.

  * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `setup un/USERNAME`, `USERNAME` is a parameter which can be used as `setup un/John Doe`.

* Items in square brackets are optional.<br>
  e.g `tn/TASKNAME [t/TAG]` can be used as `tn/CCA lunch meeting t/CCA` or as `tn/CCA lunch meeting`.

* Items with `…​` after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/CCA`, `t/CCA t/Fintech Society` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `tn/TASKNAME du/DURATION`, `du/DURATION tn/TASKNAME` is also acceptable.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Delete a Task : `delete` 

Delete a Task together with all its data, specified by its index.

Format : `deletetask i/INDEX`

- The index must be a **positive integer** and must be **valid**

Example : 
*  `deletetask i/1`

### Create a Preset Task Template : `maketemplate`

Create a template for recurring weekly tasks (Preset Tasks). It is initialized
with no Preset Tasks.

Format : `maketemplate n/TEMPLATENAME`

### Add a Preset Task to a Template : `addpresettask` 

Add a Preset Task to a Task Template, specified by its index.

Format: `addpresettask i/INDEX n/TASKNAME sd/DATE d/DURATION`

- `DURATION` is measured in hours
- Addition of a Preset Task to a specific day will be **rejected** if the total tasks
  for that day exceed 24 hours
- The index of the template must be a **positive integer** and must be **valid**

Example: 
* `addpresettask i/1 n/Read Book sd/29-09-2020 d/2`

### List Preset Task Templates : `listtemplates`

List all Preset Task Templates.

Format : `listtemplates`

### List Preset Tasks : `listpresettasks`

List all items in a Task Template, specified by its index.

Format :  `listpresettasks i/INDEX`
- The index must be a **positive integer** and must be **valid**

Example
* `listpresettasks i/1`

### Load Template into Task Schedule : `loadtemplate` 

Load a Preset Task Template into the Task Schedule, specified by its index.

Format : `loadtemplate i/INDEX`

- The combined duration of all tasks in a day cannot be more than 24 hours
- The index must be a **positive integer** and must be **valid**

Example: 
* `loadtemplate i/1`

### Delete Template : `deletetemplate`

Delete a Task Template together with all its Preset Tasks, specified by its index.

Format : `deletetemplate i/INDEX`

Example:
* `deletetemplate i/1`

### Delete Preset Task : `deletepresettask`

Delete a Preset Task from its Template.

Format : `deletepresettask it/TEMPLATEINDEX ip/PRESETINDEX`

Example:
* `deletepresettask it/1 ip/3`

### List Preset Modules : `listpresetmodules`

List all available Preset Modules.

Format : `listpresetmodules`

### List all Modules Taken : "listallmodules"

List all Preset Modules taken by the user.

Format : `listallmodules`

### Load Preset Module : `loadmodule`

Load a Preset Module into the Module Schedule, specified by its index.

Format : `loadmodule i/INDEX`

- New Module Tasks must not clash with existing Module Tasks in the Module Schedule
- The index of the Preset Module is its index in the Preset Module List 

Example: 
* `loadmodule i/100`

### Remove a Module : `removemodule`

Remove a Module and its Module Tasks from the Module Schedule, specified by its index.

Format: `removemodule i/INDEX`

- The index of the Preset Module is its index in the Preset Module List

Example:
* `removemodule i/59`

### Initialize User and Semester Information : `setup`

Setup User and Semester data, including username, semester term and academic year.

Format: `setup un/USERNAME sd/STARTDURATION ed/ENDDURATION ay/ACADEMICYEAR`

- The `STARTDURATION` has to be **before** `ENDDURATION`

Examples:
* `setup un/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1`
* `setup ay/AY20/21 Sem 1 ed/29-11-2020 un/Betsy Crowe sd/22-09-2020`

### Edit Setup Details : `editsetup`

Edit Setup details for GrAB3, including username, semester term and academic year.

Format: `editsetup [un/USERNAME] [sd/STARTDURATION] [ed/ENDDURATION] [ay/ACADEMICYEAR]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

Examples:
*  `editsetup un/Jane Doe sd/23-02-2020 ed/29-06-2020 ay/AY19/20 Sem 2`
*  `editsetup un/Jenny Doe ay/AY19/20 Sem 2`

### Delete Setup Details: `deletesetup`

Delete all setup details in GrAB3.

Format: `deletesetup` 

### Add a User Task to Task Schedule: `addusertask`

Add a user task to the task schedule in GrAB3.

Format: `addusertask tn/TASKNAME du/DURATION da/DAY w/WEEK [t/TAG]`

- `DURATION` will be in hours and less than 24 hours
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `WEEEK` have to be a valid positive integer. Total number of week calculate from semester start and end date. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total week in the semester : 4 <br/>
            * Week 1 will be from 01/09/2020 to 06/09/2020 <br/>
    `addusertask tn/CCA lunch meeting dur/4 day/2 w/1` will add user task to Tuesday of Week 1 (01/09/2020)
- Addition of a user task to a specific day will be **rejected** if the total tasks for that day exceed 24 hours

Examples:
* `addusertask tn/CCA lunch meeting du/4 da/2 w/1`
* `addusertask tn/CCA lunch meeting du/4 da/2 w/2 t/CCA`

### Edit User Task Details: `editusertask`

Edit user task details for GrAB3, including task name, duration, day, week and tag.

Format: `editusertask id/TASKID [tn/TASKNAME] [du/DURATION] [da/DAY] [w/WEEK] [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

- `DURATION` will be in hours and less than 24 hours
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `WEEEK` have to be a valid positive integer. Total number of week calculate from semester start and end date. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total week in the semester : 4 <br/>
            * Week 1 will be from 01 to 06/09/2020 <br/>
    `editusertask id/usrta001 da/2 w/1` will edit user task to Tuesday of Week 1. 
- Addition of a user task to a specific day will be **rejected** if the total tasks for that day exceed 24 hours

Example:
* `editusertask id/2 tn/Complete 2103 Project sd/20-09-2020 dy/3`
* `edituseretask id/2 sd/20-09-2020`
* `editusertask id/2 tn/Complete 2103 Project da/4`

### Indicate that User Task is Completed : `doneusertask`

Indicate that the user task have been completed.

Format: `doneusertask id/TASKID`

Example:
* `doneusertask id/usrta001`

### Delete User Task from Task Schedule : `deleteusertask`

Remove and delete user task from task schedule.

Format: `deleteusertask id/TASKID`

Example:
* `deleteusertask id/usrta001`

### List the Task Schedule : `listtaskschedule`

Display items within the Task Schedule.

Format: `listtaskschedule w/WEEK`

- `WEEEK` have to be a valid positive integer. Total number of week calculate from semester start and end date. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total week in the semester : 4 <br/>
            * Week 1 will be from 01 to 06/09/2020 <br/>
            
Example: 
* `listtaskschedule w/1`

### Create a Task Template: `createtemplate`

Create a template so that user can reuse it weekly. <br/>
An empty template with no task will be initialized.

Format: `createtemplate ten/TEMPLATENAME`

Example: 
* `createtemplate ten/CCA Meeting`

### Edit a Task Template Name: `edittemplate`

Edit a selected Task Template name for GrAB3

Format: `edittemplate tti/TASKTEMPLATEINDEX ten/TEMPLATENAME`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `edittemplate tti/1 ten/Task for CCA` 

### Delete a Task Template: `deletetemplate`

Delete a task template and its data.

Format `deletetemplate tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example:
* `deletetemplate tti/1`

### List Task Template :  `listtasktemplate` 

List all the Task Template that was created.

Format `listtasktemplate`

### Add Preset Task in Task Template : `addpresettask`

Create and Add a Preset Task to be store in selected Task Template.

Format: `addpresettask tti/TASKTEMPLATEINDEX tn/TASKNAME du/DURATION da/DAY [t/TAG]`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `DURATION` will be in hours and less than 24 hours
- Addition of a preset task to a specific day in the same template will be **rejected** if the total tasks for that day exceed 24 hours

Example:
* `addpresettask tti/1 tn/Revise for Lab du/3 da/2 t/LSM1301`
* `addpresettask tti/1 tn/Revise for Lab du/3 da/2`

### Edit Preset Task in Task Template : `editpresettask`

Edit a selected Preset Task in a selected Task Template.

Format: `editpresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX [tn/TASKNAME] [du/DURATION] [da/DAY] [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**
- The `PRESETTASKINDEX` must be a **positive integer** and must be **valid**
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `DURATION` will be in hours and less than 24 hours
- Addition of a preset task to a specific day in the same template will be **rejected** if the total tasks for that day exceed 24 hours

Example: 
* `editpresettask tti/1 pti/2 tn/CCA lunch du/3 da/5`
* `editpresettask tti/1 pti/2 tn/CCA lunch du/3 da/5 t/CCA`

### Clear all Preset Task from Task Template : `cleartemplate`

Clear all Preset Task in the selected Task Template.

Format: `cleartemplate tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `cleartemplate tti/1 pti/1`

### Delete a Preset Task from Task Template : `deletepresettask`

Remove and Delete a Preset Task from the Task Template.

Format: `deletepresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**
- The `PRESETTASKINDEX` must be a **positive integer** and must be **valid**

Example: 
* `deletepresettask tti/1 pti/1`

### Load Task Template into Task Schedule : `loadtemplate`

Load all the Preset Task listed in Task Template into the Task Schedule.

Format:  `loadtemplate tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example:
*  `loadtemplate tti/1`

### List Preset Task in Task Template : `listpresettask`

List all Preset Task in Task Template.

Format: `listpresettask tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `listpresettask tti/1`

### Select Module : `selectmodule` 

Select a Module and load all the ModuleTask into the Module Schedule.

Format: `selectmodule mi/MODULEINDEX`

- The `MODULEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `selectmodule mi/1`

### Delete Module: `deletemodule`

Remove and Delete a Module and all its Module Task from the Module Schedule.

Format: `deletemodule mi/MODULEINDEX`

- The `MODULEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `deletemodule mi/1`

### List Module List : `listmodulelist`

List all the module that is offered by the university.

Format: `listmodulelist`
 
### List All my Modules : `listmymodule`
 
List all the module that the user have selected.
 
Format: `listmymodule`
 
 
### Exit GrAB3 : `exit`

Exits the program.

Format: `exit`

### Saving the Data

GrAB3 data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous GrAB3 home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help`
**Setup** | `setup un/USERNAME sd/STARTDURATION ed/ENDDURATION ay/ACADEMICYEAR` <br/>e.g. `setup un/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1`
**EditSetup** |  `editsetup [un/USERNAME] [sd/STARTDURATION] [ed/ENDDURATION] [ay/ACADEMICYEAR]` <br/>e.g. `editsetup un/Jane Doe sd/23-02-2020 ed/29-06-2020 ay/AY19/20 Sem 2`
**DeleteSetup** | `deletesetup`
**AddUserTask** | `addusertask tn/TASKNAME du/DURATION da/DAY w/WEEK [t/TAG]` <br/> e.g. `addusertask tn/CCA lunch meeting du/4 da/2 w/2 t/CCA`
**EditUserTask** | `editusertask id/TASKID [tn/TASKNAME] [du/DURATION] [da/DAY] [w/WEEK] [t/TAG]` <br/> e.g. `editusertask id/2 tn/Complete 2103 Project sd/20-09-2020 dy/3`
**DoneUserTask** | `doneusertask id/TASKID` <br/> e.g. `doneusertask id/usrta001`
**DeleteUserTask** | `deleteusertask id/TASKID` <br/> e.g. `deleteusertask id/usrta001`
**ListTaskSchedule** | `listtaskschedule w/WEEK`  <br/> e.g. `listtaskschedule w/1`
**CreateTaskTemplate** | `createtemplate ten/TEMPLATENAME` <br/> e.g. `createtemplate ten/CCA Meeting`
**EditTaskTemplateName** | `edittemplate tti/TASKTEMPLATEINDEX ten/TEMPLATENAME` <br/> e.g. `edittemplate tti/1 ten/Task for CCA`
**DeleteTaskTemplate** | `deletetemplate` <br/> e.g. `deletetemplate tti/1` 
**ListTaskTemplate** | `listtasktemplate` 
**AddPresetTask** | `addpresettask tti/TASKTEMPLATEINDEX tn/TASKNAME du/DURATION da/DAY [t/TAG]` <br/> e.g. `addpresettask tti/1 tn/Revise for Lab du/3 da/2 t/LSM1301`
**EditPresetTask** | `editpresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX [tn/TASKNAME] [du/DURATION] [da/DAY] [t/TAG]` <br/> e.g. `editpresettask tti/1 pti/2 tn/CCA lunch du/3 da/5 t/CCA`
**ClearPresetTask** | `cleartemplate tti/TASKTEMPLATEINDEX` <br/> e.g. `cleartemplate tti/1 pti/1`
**DeletePresetTask**| `deletepresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX` <br/> e.g. `deletepresettask tti/1 pti/1`
**LoadTaskTemplate** | `loadtemplate tti/TASKTEMPLATEINDEX` <br/> e.g. `loadtemplate tti/1`
**ListPresetTask** | `listpresettask tti/TASKTEMPLATEINDEX` <br/> e.g. `listpresettask tti/1`
**SelectModule** | `selectmodule mi/MODULEINDEX` <br/> e.g. `selectmodule mi/1`
**DeleteModule** | `deletemodule mi/MODULEINDEX` <br/> e.g. `deletemodule mi/1`
**ListModuleList** | `listmodulelist`
**ListMyModule** | `listmymodule`
**Exit** | `exit`

