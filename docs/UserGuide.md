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

~~1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).~~

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

### Others

Action | Format | Examples
--------|--------|----------
**Help** | `help [COMMAND]` | `help`
**Exit** | `exit` | `exit`

