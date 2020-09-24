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

  * **`listmodules`** : Lists all module provided by the university.

  * **`setup`**`n/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1` : Adds a user named `John Doe` and academic year `AY20/21 Sem 1` that spans from `22-09-2020` to `29-11-2020`.
  
  * **`listtaskschedule`**`2` : List all the user tasks in task schedule for Week 2.

  * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `setup n/USERNAME`, `USERNAME` is a parameter which can be used as `setup n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `tn/TASKNAME [t/TAG]` can be used as `tn/CCA lunch meeting t/CCA` or as `tn/CCA lunch meeting`.

* Items with `…​` after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/CCA`, `t/CCA t/Fintech Society` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `tn/TASKNAME du/DURATION`, `du/DURATION tn/TASKNAME` is also acceptable.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Initialize User and Semester Information : `setup`

Setup User and Semester data, including username, semester term and academic year.

Format: `setup n/USERNAME sd/STARTDURATION ed/ENDDURATION ay/ACADEMICYEAR`

- The `STARTDURATION` has to be **before** `ENDDURATION`

Examples:
* `setup n/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1`
* `setup ay/AY20/21 Sem 1 ed/29-11-2020 n/Betsy Crowe sd/22-09-2020`

### Edit Setup Details : `editsetup`

Edit Setup details for GrAB3, including username, semester term and academic year.

Format: `editsetup [n/USERNAME] [sd/STARTDURATION] [ed/END] [ay/ACADEMICYEAR]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

Examples:
*  `editsetup n/Jane Doe sd/23-02-2020 ed/29-06-2020 ay/AY19/20 Sem 2`
*  `editsetup n/Jenny Doe ay/AY19/20 Sem 2`

### Delete Setup Details: `deletesetup`

Delete all setup details in GrAB3.

Format: `deletesetup` 

### Add a User Task to Task Schedule: `addusertask`

Add a user task to the task schedule in GrAB3.

Format: `addusertask tn/TASKNAME du/DURATION da/DAY w/WEEK [t/TAG]`

- `DURATION` is measured in hours and must not exceed 24 hours
- `DAY` has to be an integer within 1-7, with 1 being Monday and 7 being Sunday
- `WEEEK` has to be a valid positive integer. Total number of weeks are calculated using start and end date of the semester. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total weeks in the semester : 4 <br/>
            * Week 1 will be from 01/09/2020 to 06/09/2020 <br/>
    `addusertask tn/CCA lunch meeting dur/4 day/2 w/1` will add user task to Tuesday of Week 1 (01/09/2020)
- Addition of a user task to a specific day will be **rejected** if the total tasks for that day exceeds 24 hours

Examples:
* `addusertask tn/CCA lunch meeting du/4 da/2 w/1`
* `addusertask tn/CCA lunch meeting du/4 da/2 w/2 t/CCA`

### Edit User Task Details: `editusertask`

Edit user task details for GrAB3, including task name, duration, day, week and tag.

Format: `editusertask id/TASKID [tn/TASKNAME] [du/DURATION] [da/DAY] [w/WEEK] [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

- `DURATION` is measured in hours and must not exceed 24 hours
- `DAY` has to be an integer within 1-7, with 1 being Monday and 7 being Sunday
- `WEEEK` has to be a valid positive integer. Total number of weeks are calculated using start and end date of the semester. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total weeks in the semester : 4 <br/>
            * Week 1 will be from 01 to 06/09/2020 <br/>
    `editusertask id/usrta001 da/2 w/1` will edit user task to Tuesday of Week 1. 
- Addition of a user task to a specific day will be **rejected** if the total tasks for that day exceeds 24 hours

Example:
* `editusertask id/usrta001 tn/Complete 2103 Project sd/20-09-2020 da/3`
* `editusertask id/usrta001 sd/20-09-2020`
* `editusertask id/usrta001 tn/Complete 2103 Project da/4`

### Indicate that User Task is Completed : `doneusertask`

Indicate that the user task has been completed.

Format: `doneusertask id/TASKID`

Example:
* `doneusertask id/usrta001`

### Delete User Task from Task Schedule : `deleteusertask`

Remove and delete user task from task schedule.

Format: `deleteusertask id/TASKID`

Example:
* `deleteusertask id/usrta001`

### List the Task Schedule : `listtaskschedule`

Displays all tasks in the week that is specified by the user.

Format: `listtaskschedule w/WEEK`

- `WEEEK` has to be a valid positive integer. The total number of weeks are calculated using the start and end date of the semester. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total weeks in the semester : 4 <br/>
            * Week 1 will be from 01 to 06/09/2020 <br/>
            
Example: 
* `listtaskschedule w/1`

### Create a Task Template: `createtemplate`

Creates a template of tasks for the user to reuse weekly to quickly add into his/her schedule <br/>
An empty template with no task will be initialized.

Format: `createtemplate ten/TEMPLATENAME`

Example: 
* `createtemplate ten/CCA Meeting`

### Edit a Task Template Name: `edittemplatename`

Edit a selected task template name for GrAB3.

Format: `edittemplatename tti/TASKTEMPLATEINDEX ten/TEMPLATENAME`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `edittemplatename tti/1 ten/Task for CCA` 

### Delete a Task Template: `deletetemplate`

Delete a task template and its data.

Format `deletetemplate tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example:
* `deletetemplate tti/1`

### List Task Template :  `listtemplate` 

List all task templates that were created.

Format `listtemplate`

### Add Preset Task in Task Template : `addpresettask`

Creates and adds a preset task in the selected task template.

Format: `addpresettask tti/TASKTEMPLATEINDEX tn/TASKNAME du/DURATION da/DAY [t/TAG]`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**
- `DAY` has to be an integer within 1-7, with 1 being Monday and 7 being Sunday
- `DURATION` is measured in hours and must not exceed 24 hours
- Addition of a preset task to a specific day in the same template will be **rejected** if the total tasks for that day exceeds 24 hours

Example:
* `addpresettask tti/1 tn/Revise for Lab du/3 da/2 t/LSM1301`
* `addpresettask tti/1 tn/Revise for Lab du/3 da/2`

### Edit Preset Task in Task Template : `editpresettask`

Edit a selected preset task in a selected task template.

Format: `editpresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX [tn/TASKNAME] [du/DURATION] [da/DAY] [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**
- The `PRESETTASKINDEX` must be a **positive integer** and must be **valid**
- `DAY` has to be an integer within 1-7, with 1 being Monday and 7 being Sunday
- `DURATION` is measured in hours and must not exceed 24 hours
- Addition of a preset task to a specific day in the same template will be **rejected** if the total tasks for that day exceeds 24 hours

Example: 
* `editpresettask tti/1 pti/2 tn/CCA lunch du/3 da/5`
* `editpresettask tti/1 pti/2 tn/CCA lunch du/3 da/5 t/CCA`

### Clear all Preset Tasks from Task Template : `cleartemplate`

Clear all preset tasks in the selected task template.

Format: `cleartemplate tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `cleartemplate tti/1`

### Delete a Preset Task from Task Template : `deletepresettask`

Remove and Delete a preset task from the task template.

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

### List Preset Task in Task Template : `listtemplatetask`

List all preset tasks in task template.

Format: `listtemplatetask tti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `listtemplatetask tti/1`

### Select Module : `selectmodule` 

Select a module and load all the module tasks into the module schedule.

Format: `selectmodule mc/MODULECODE`

- The `MODULECODE` must be a **positive integer** and must be **valid**

Example: 
* `selectmodule mc/1`

### Delete Module: `deletemodule`

Delete a module and all its module tasks from the module schedule.

Format: `deletemodule mc/MODULECODE`

- The `MODULECODE` must be a **positive integer** and must be **valid**

Example: 
* `deletemodule mc/1`

### List Module List : `listmodule`

List all the module that is offered by the university.

Format: `listmodules`
 
### List All my Modules : `listmymodules`
 
List all the module that the user have selected.
 
Format: `listmymodules`
 
 
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
**Setup** | `setup n/USERNAME sd/STARTDURATION ed/ENDDURATION ay/ACADEMICYEAR` <br/>e.g. `setup n/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1`
**EditSetup** |  `editsetup [n/USERNAME] [sd/STARTDURATION] [ed/ENDDURATION] [ay/ACADEMICYEAR]` <br/>e.g. `editsetup n/Jane Doe sd/23-02-2020 ed/29-06-2020 ay/AY19/20 Sem 2`
**DeleteSetup** | `deletesetup`
**AddUserTask** | `addusertask tn/TASKNAME du/DURATION da/DAY w/WEEK [t/TAG]` <br/> e.g. `addusertask tn/CCA lunch meeting du/4 da/2 w/2 t/CCA`
**EditUserTask** | `editusertask id/TASKID [tn/TASKNAME] [du/DURATION] [da/DAY] [w/WEEK] [t/TAG]` <br/> e.g. `editusertask id/usrta001 tn/Complete 2103 Project sd/20-09-2020 da/3`
**DoneUserTask** | `doneusertask id/TASKID` <br/> e.g. `doneusertask id/usrta001`
**DeleteUserTask** | `deleteusertask id/TASKID` <br/> e.g. `deleteusertask id/usrta001`
**ListTaskSchedule** | `listtaskschedule w/WEEK`  <br/> e.g. `listtaskschedule w/1`
**CreateTaskTemplate** | `createtemplate ten/TEMPLATENAME` <br/> e.g. `createtemplate ten/CCA Meeting`
**EditTaskTemplateName** | `edittemplatename tti/TASKTEMPLATEINDEX ten/TEMPLATENAME` <br/> e.g. `edittemplatename tti/1 ten/Task for CCA`
**DeleteTaskTemplate** | `deletetemplate tti/TASKTEMPLATEINDEX` <br/> e.g. `deletetemplate tti/1` 
**ListTaskTemplate** | `listtemplate` 
**AddPresetTask** | `addpresettask tti/TASKTEMPLATEINDEX tn/TASKNAME du/DURATION da/DAY [t/TAG]` <br/> e.g. `addpresettask tti/1 tn/Revise for Lab du/3 da/2 t/LSM1301`
**EditPresetTask** | `editpresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX [tn/TASKNAME] [du/DURATION] [da/DAY] [t/TAG]` <br/> e.g. `editpresettask tti/1 pti/2 tn/CCA lunch du/3 da/5 t/CCA`
**ClearPresetTask** | `cleartemplate tti/TASKTEMPLATEINDEX` <br/> e.g. `cleartemplate tti/1`
**DeletePresetTask**| `deletepresettask tti/TASKTEMPLATEINDEX pti/PRESETTASKINDEX` <br/> e.g. `deletepresettask tti/1 pti/1`
**LoadTaskTemplate** | `loadtemplate tti/TASKTEMPLATEINDEX` <br/> e.g. `loadtemplate tti/1`
**ListTemplateTask** | `listtemplatetask tti/TASKTEMPLATEINDEX` <br/> e.g. `listtemplatetask tti/1`
**SelectModule** | `selectmodule mc/MODULECODE` <br/> e.g. `selectmodule mc/1`
**DeleteModule** | `deletemodule mc/MODULECODE` <br/> e.g. `deletemodule mc/1`
**ListModules** | `listmodules`
**ListMyModules** | `listmymodules`
**Exit** | `exit`
