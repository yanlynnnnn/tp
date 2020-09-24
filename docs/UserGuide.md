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

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `setup n/NAME`, `NAME` is a parameter which can be used as `setup n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `tn/TASKNAME [t/TAG]` can be used as `n/CCA lunch meeting t/CCA` or as `n/CCA lunch meeting`.

* Items with `…​` after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/CCA`, `t/CCA t/Fintech Society` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `tn/TASKNAME dur/DURATION`, `dur/DURATION tn/TASKNAME` is also acceptable.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Initialize User and Semester Information : `setup`

Setup User and Semester data, including username, semester term and academic year.

Format: `setup n/USERNAME sd/STARTDURATION ed/ENDDURATION fy/ACADEMICYEAR`

- The `STARTDURATION` has to be **before** `ENDDURATION`

Examples:
* `setup n/John Doe sd/22-09-2020 ed/29-11-2020 fy/AY20/21 Sem 1`
* `setup fy/AY20/21 Sem 1 ed/29-11-2020 n/Betsy Crowe sd/22-09-2020`

### Edit Setup Details : `editsetup`

Edit Setup details for GrAB3, including username, semester term and academic year.

Format: `editsetup [n/USERNAME] [sd/STARTDURATION] [ed/ENDDURATION] [fy/ACADEMICYEAR]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

Examples:
*  `editsetup n/Jane Doe sd/23-02-2020 ed/29-06-2020 fy/AY19/20 Sem 2`
*  `editsetup n/Jenny Doe fy/AY19/20 Sem 2`

### Delete Setup Details: `deletesetup`

Delete all setup details in GrAB3.

Format: `deletesetup` 

### Add a User Task to Task Schedule: `addusertask`

Add a user task to the task schedule in GrAB3.

Format: `addusertask tn/TASKNAME dur/DURATION day/DAY w/WEEK [t/TAG]`

- `DURATION` will be in hours and less than 24 hours
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `WEEEK` have to be a valid positive integer. Total number of week calculate from semester start and end date. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total week in the semester : 4 <br/>
            * Week 1 will be from 01/09/2020 to 06/09/2020 <br/>
    `addusertask tn/CCA lunch meeting dur/4 day/2 w/1` will add user task to Tuesday of Week 1 (01/09/2020)
- Addition of a user task to a specific day will be **rejected** if the total tasks for that day exceed 24 hours

Examples:
* `addusertask tn/CCA lunch meeting dur/4 day/2 w/1`
* `addusertask tn/CCA lunch meeting dur/4 day/2 w/2 t/CCA`

### Edit User Task Details: `editusertask` ******** NOT DONE ********

Edit user task details for GrAB3, including task name, duration, day, week and tag.

Format: `editusertask i/INDEX [n/TASKNAME] [dur/DURATION] [day/DAY] [w/WEEK] [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Items in square brackets are optional, but please input at least 1 value to change.
</div>

- `INDEX` must be a **positive** integer and **valid**
  - User task schedule can be found in the task schedule 
- `DURATION` will be in hours and less than 24 hours
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `WEEEK` have to be a valid positive integer. Total number of week calculate from semester start and end date. <br/>
    e.g. If the semester is from 01 to 25/09/2020 <br/>
            * Total week in the semester : 4 <br/>
            * Week 1 will be from 01 to 06/09/2020 <br/>
    `editusertask tn/CCA lunch meeting dur/4 day/2 w/1` will add user task to Tuesday of Week 1 (01/09/2020)
- Addition of a user task to a specific day will be **rejected** if the total tasks for that day exceed 24 hours

Example:
* `editusertask i/2 n/Complete 2103 Project sd/20-09-2020 d/3`
* `edituseretask i/2 sd/20-09-2020`
* `editusertask i/2 n/Complete 2103 Project d/4`

### Indicate that User Task is Completed : `doneusertask` ******** NOT DONE ********

Indicate that the user task have been completed.

Format: ``

### Delete User Task from Task Schedule : `deleteusertask` ******** NOT DONE ********

Remove and delete user task from task schedule.

Format: ``

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

Format: `createtemplate n/TEMPLATENAME`

Example: 
* `createtemplate n/CCA Meeting`

### Edit a Task Template Name: `edittemplate` ******** NOT DONE ********

Edit a selected Task Template name for GrAB3

Format: `edittemplate ti/TASKTEMPLATEINDEX n/NAME`

Example: 
* `edittemplate ti/1 n/Task for CCA` 

### Delete a Task Template: `deletetemplate` ******** NOT DONE ********

Delete a task template and its data.

Format `deletetemplate ti/TASKTEMPLATEINDEX`

Example:
* `deletetemplate ti/1`

### List Task Template :  `listtasktemplate` 

List all the Task Template that was created.

Format `listtasktemplate`

### Add Preset Task in Task Template : `addpresettask` ******** NOT DONE ********

Create and Add a Preset Task to be store in selected Task Template.

Format: `addpresettask ti/TASKTEMPLATEINDEX tn/TASKNAME dur/DURATION day/DAY [t/TAG]`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**
- `DAY` have to be an integer within 1-7, with 1 being monday and 7 being sunday
- `DURATION` will be in hours and less than 24 hours

Example:
* `addpresettask ti/1 tn/Revise for Lab dur/3 day/2 t/LSM1301`
* `addpresettask ti/1 tn/Revise for Lab dur/3 day/2`

### Edit Preset Task in Task Template : `editpresettask` ******** NOT DONE ********

Edit a selected Preset Task in a selected Task Template.

Format: `editpresettask ti/TASKTEMPLATEINDEX`

Example: 
*

### Delete a Preset Task from Task Template : `deletepresettask` ******** NOT DONE ********

Remove and Delete a Preset Task from the Task Template.

Format: `deletepresettask ti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* 

### Load Task Template into Task Schedule : `loadtemplate` ******** NOT DONE ********

Load all the Preset Task listed in Task Template into the Task Schedule.

Format:  `loadtemplate ti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example:
*  `loadtemplate ti/1`

### List Preset Task in Task Template : `listpresettask`

List all Preset Task in Task Template.

Format: `listpresettask ti/TASKTEMPLATEINDEX`

- The `TASKTEMPLATEINDEX` must be a **positive integer** and must be **valid**

Example: 
* `listpresettask ti/TASKTEMPLATEINDEX`

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
**Setup** | `setup n/USERNAME sd/STARTDURATION ed/ENDDURATION fy/ACADEMICYEAR` <br/>e.g. `setup n/John Doe sd/22-09-2020 ed/29-11-2020 fy/AY20/21 Sem 1`
**EditSetup** |  `editsetup [n/USERNAME] [sd/STARTDURATION] [ed/ENDDURATION] [fy/ACADEMICYEAR]` <br/>e.g. `editsetup n/Jane Doe sd/23-02-2020 ed/29-06-2020 fy/AY19/20 Sem 2`
**DeleteSetup** | `deletesetup`
**AddUserTask** | `addusertask tn/TASKNAME dur/DURATION day/DAY w/WEEK [t/TAG]` <br/> e.g. `addusertask tn/CCA lunch meeting dur/4 day/2 w/2 t/CCA`
**EditUserTask** | 
**DoneUserTask** |
**DeleteUserTask** |
**ListTaskSchedule** | `listtaskschedule w/WEEK`  <br/> e.g. `listtaskschedule w/1`
**CreateTaskTemplate** | `createtemplate n/TEMPLATENAME` <br/> e.g. `createtemplate n/CCA Meeting`
**EditTaskTemplateName** | 
**DeleteTaskTemplate** |
**ListTaskTemplate** | `listtasktemplate` 
**AddPresetTask** | 
**EditPresetTask** |
**DeletePresetTask**|
**LoadTaskTemplate** |
**ListPresetTask** |
**SelectModule** |
**DeleteModule** |
**ListModuleList** | `listmodulelist`
**ListModuleTaken** | `listmymodule`

