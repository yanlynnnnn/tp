---
layout: page
title: User Guide
---

Are you an independent home-based beauty salon owner, scrambling between your calendar, client contacts, 
and notebook to keep track of all your appointments, revenue and expenses? 
Do you spend hours tabulating all your revenue and expenses just to get an idea of how your business is doing?
Fret not, our application, GrAB3, will reduce the hassle of managing your business and saves your valuable time. 
GrAB3 is an all-in-one application that helps home-based beauty salon owners consolidate their business details - 
such as their appointments, revenue and expenses - into a single application. 
The application uses a Command Line Interface (CLI)...

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `GrAB3.jar` from [here](https://github.com/AY2021S1-CS2103T-W13-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your GrAB3.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1.Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

  ~~* **`listmodules`** : Lists all module provided by the university.~~

  ~~* **`setup`**`n/John Doe sd/22-09-2020 ed/29-11-2020 ay/AY20/21 Sem 1` : Adds a user named `John Doe` and academic year `AY20/21 Sem 1` that spans from `22-09-2020` to `29-11-2020`.~~
  
  ~~* **`listtaskschedule`**`2` : List all the user tasks in task schedule for Week 2.~~

  ~~* **`exit`** : Exits the app.~~

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------
## About

### Structure of this document


### Reading this document

#### Terminology related to the GUI

#### General Symbols and Syntax 

#### Command Syntax and Usage

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

## Features

{Description} 

### Feature 1

{Description}

#### Feature 1 parameter

{Description}

{Command parameter explanation}

##### Feature command 1 `Feature command 1`

{Description}

Format : `Format`

{Format explanation / limitation}

Example:

{Example description/ case scenario}

{Example action}

{Example Outcome details}

{Example outcome screenshot}


### Revenue Tracker

GrAB3 knows that revenue tracking is very important for your business.
Thus, this feature allows you to track the revenue that you have generated effortlessly.
Revenue will be automatically recorded when an appointment is indicated as done.

#### Revenue Tracker Command Parameters

Before you dive into using the feature, you may want to have a look at the common parameter used in this feature.
The table below shows a list of command parameters that will be used in this feature.

| Parameter Name | Description | Example
|---------|---------|---------
|`DATE`  | The revenue earned date. <br> <br> It must be in the format of `dd-MM-yyyy`. | E.g. Typing `28-09-2020` would mean 28 September 2020.
|`SERVICE_CODE`| The service code is the code that identifies a particular type of service provided. <br> <br> It must be alphanumeric words of 5 characters long. | E.g. If you have added an eyelash extension service into GrAB3 and its service code is `SC001`. <br> <br> Typing `SC001` would refers to the eyelash extension service.
|`ORDER` | The order refers to ascending or descending. <br> <br> It must be in the format of `asc` or `desc` | E.g. Typing `asc` would mean ascending.  <br> <br> E.g. Typing `desc` would mean descending.

##### Find Revenue : `findrev`

You can use this command to find revenue by date or service code.

Format : `findrev [dt/DATE]* [s/SERVICE_CODE]*`

|<div markdown="block" class="alert alert-info"> :information_source:</div> | Refer to [Revenue Tracker Command Parameters](#revenue-tracker-command-parameters) for more details about each parameter.
|---------|---------
<br> 
Example :

You have just stop operation for the day, and you wish to view all the revenues generated for today (29-09-2020).

You can follow the steps below to get the list of revenues for the day.

Steps :
1. Type `findrev dt/29-09-2020` into the command box.
1. Press `Enter` to execute. 

Outcome : 
1. It will display a successful message ~~in the *Dashboard*.~~
1. GrAB3 will list out all the revenue for 29-09-2020 ~~in the *Revenue* tab.~~  
1. You will be able to see all the revenue for 29-09-2020.

{Example outcome screenshot}

## Others

{Description}

### Others Command Parameter

{Description}

{Command parameter explanation}

#### Viewing help : `help`

Show a message explaining how to access the help page.

Format : `help [COMMAND]`

{Format explanation / limitation}

Example:

If you are unsure of the commands that GrAB3 offered. You can follow the steps below to get a full list of all the commands.

Steps: 
1. Type `help` into the command box.
1. Press `Enter` to execute.

Outcome: 

1. GrAb3 will switch to the *Help* tab.

![help message](images/helpMessage.png)

#### Exit GrAB3 : `exit`

Exits the program.

Format : `exit`

Example:

If you wish to exit GrAb3. 

Steps: 
1. Type `exit` into the command box.
1. Press `Enter` to execute.

Outcome: 

1. GrAb3 will close its window.

{Example outcome screenshot}

### Saving the Data - Can consider moving to about.

GrAB3 data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

## Future Feature Enhancement v2.0

{Description} 

### Feature 1

{Description}

#### Feature command 1 `Feature command 1`

{Description}

Format : `Format`

{Format explanation / limitation}

Example:

{Example description/ case scenario}

{Example action}


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous GrAB3 home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

### Feature

{Feature command table} 

### Revenue Tracker
|Action | Format | Examples
|---------|---------|---------
|**Find** | `findrev [dt/DATE]* [sc/SERVICE_CODE]*` | `findrev dt\28-09-2020`

### Others

Action | Format | Examples
--------|--------|----------
**Help** | `help [COMMAND]` | `help`
**Exit** | `exit` | `exit`

