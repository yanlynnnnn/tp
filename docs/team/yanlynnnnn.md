---
layout: page
title: Tan Yan Lyn's Project Portfolio
---

## Project: Homerce
Homerce is an all-in-one application that helps home-based beauty salon owners consolidate their business details - 
such as their schedule, appointments, clients, and services - into a single application. It also keeps track of the business's
revenue and expenses, and supports simple visualization of monthly finances.
The application uses a Command Line Interface (CLI).

## Overview
This portfolio aims to document the contributions that I have made to Homerce. In this project, our team - Homerce,
will enhance a basic CLI Address Book 3 (AB3) and repurpose it to create our application: Homerce.

## Summary of contributions

Click [here](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=yanlynnnnn&tabRepo=AY2021S1-CS2103T-W13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)
to view Yan Lyn's code contributions.

####Enhancements Implemented: <br>
##### 1. Implementation of Expense Tracker <br>
* To support commands such as `addexp` to add an expense entry to the tracker,
`editexp` to edit an expense entry,
etc (`findexp`, `deleteexp`, `listexp`, `clearexp`)
* Implemented the Logic, Storage, and Model components of the tracker

##### 2. Enhancement of Expense Tracker <br>
* Implemented the logic for the `sortexp` feature, to sort expenses based on their value in ascending
or descending order
* Implemented the logic for the recurring expense feature, 
to automatically duplicate recurring expenses on the same day every month. The feature is implemented in such a way that
expenses will still be duplicated even if the user does not open the app on that day of the month.

##### 3. Visualization of Finances
* Implemented the logic to generate revenue and expense lists filtered by month and year,
for use in the visualization of monthly finances

##### 4. Enhancement of GUI
* Customized the GUI for the Client Manager, Service Manager, Appointment Tracker,
Expense Tracker, and Revenue Tracker features
* Customized the GUI for the `breakdownfinance` pop-up window

##### 5. Testing
* Included JUnit Tests for the Expense Tracker, with over 90% line coverage on average
* Included Integration Tests across logic, model and storage components for the Expense Tracker

####Contributions to Documentation (User Guide): <br>
##### 1. Introduction
##### 2. Quick Start section
* Instructions on how to set-up and run the application
##### 3. About section
* Structure of the document
* Common terminology, symbols, and syntax used throughout the document
##### 4. Expense Tracker Feature
 * Details of commands in the Expense Tracker 
 * Includes command parameters, command format, command examples, and command outcomes with annotated screenshots
 * Command Summary table
##### 5. Design of GUI
* Designed the GUI Mock-Up for Homerce

####Contributions to Developer Guide: <br>
##### 1. Expense Tracker Feature
* Rationale
* Current Implementation (Activity Diagram and Sequence Diagram to illustrate workflow of  `sortexp` command)
* Design Considerations
##### 2. Appendix B: User Stories

## Contributions to Developer Guide

![Activity diagram for expense_tracker sortexp command](images/SortExpenseActivityDiagram.png)
![Sequence diagram for sortexp command](images/SortExpenseSD.png)

```
When the user enters the `sortexp` command to sort the expense list, the user input command undergoes the same command parsing as described in
[Section 3.3 Logic Component](#33-logic-component). During the execution of `SortExpenseCommand`, Homerce will access the expense tracker
and sort the expense list based on the value of the expenses. For example, if the user specifies the order as "asc", the expense list will
be sorted in ascending order based on value, from lowest to highest value.

The following steps will describe the execution of the `SortExpenseCommand` in detail, assuming that no errors are encountered.
1. When the `execute()` method of the `SortExpenseCommand` is called, the `ModelManager`'s `getExpenseTracker()` method is called.
2. The `ModelManager` will return the existing `ExpenseTracker` to the `SortExpenseCommand`.
3. The `ModelManager` will call the `sort(isAsceding)` method on the `ExpenseTracker`.
4. The `ExpenseTracker` then calls the `sort(isAscending)` method on `NonUniqueList`, which sorts the expense list based on the order specified.
5. The `ObservableList` of expenses is updated to reflect the newly sorted list.
6. The `Ui` component will detect this change and update the GUI.
7. Assuming that the above steps are all successful, the `SortExpenseCommand` will then create a `CommandResult` object and return the result.
```
```
**Aspect: Duplicating a fixed expense every month**

|              | **Pros**   | **Cons** |
| -------------|-------------| -----|
| **Option 1** <br> Immediately create 12 duplicate expenses upon the creation of a fixed expense for the next 12 months, creating another 12 duplicate expenses after every 12 months. | Users can edit the fixed expense records in a period of 12 months by editing any one of the 12 duplicate expenses. | Users are unable to create a fixed expense that only recurs over a period of less than 12 months. <br> For example, a user might want to add a fixed expense that he will incur only for the next 6 months. However, the application will create 12 duplicate expenses in advance. |
| **Option 2 (current choice)** <br> Create one duplicate expense for each fixed expense per month. | Duplicate expenses are only recorded when the month comes or the month has passed. | Users can only edit the next duplicate expense by editing the most recent duplicate expense. |

Reason for choosing option 2:
* It is more intuitive to the user to record an expense only when it has been incurred.
* Users can have more flexibility in creating fixed expenses that recur for a period that is not a multiple of 12 months.
## Contributions to User Guide
```

## Contributions to User Guide
```
Are you an independent home-based beauty salon owner, scrambling between your calendar, client contacts, 
and notebook to keep track of all your appointments, revenue and expenses? 
Do you spend hours tabulating all your revenue and expenses just to get an idea of how your business is doing?
Fret not, our application, Homerce, will reduce the hassle of managing your business and save your valuable time. 
Homerce is an all-in-one application that helps home-based beauty salon owners consolidate their business details - 
such as their appointments, revenue and expenses - into a single application. 

The application uses a Command Line Interface (CLI); this means that you operate the application by typing commands 
into a Command Box. If you are fast at typing, you can operate the application faster than other Graphical User Interface 
(GUI) applications; GUI applications allow users to interact with the application through graphical icons such as buttons.

If you are interested, jump to [Section 2 - Quick Start](#2-quick-start) to learn how to start managing your business using Homerce.
```
```
This section gives you step-by-step instructions on how to download and open the application.
1. Ensure you have Java `11` or above installed in your Computer. You may install it [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html). 
```
```
We have structured this User Guide in a way to help you find what you need easily and quickly. 
In the next subsection, [Section 3.2 - reading this document](#32-reading-this-document), you can find several useful tips on how to read this guide.
The following section, [Section 4 - Features](#4-features), documents the six main features in **Homerce**, namely:
```
```$xslt
The table below explains some important technical terms to help you understand and use commands in Homerce.
| Technical Term | What it means |
| ---------------| --------------|
| Command Word | The first word of a command. It determines the action that Homerce should perform. |
| Prefix | The characters at the start of a parameter. It distinguishes one parameter from another.|
| Parameter | The word following each prefix. They are values given to a command to perform the specified action.|
**Example:** <br>
`addexp d/DESCRIPTION f/ISFIXED v/VALUE dt/DATE [t/TAG]`
```
```
You can use this command to sort expenses in Homerce.
Format : `sortexp ORDER`
<div markdown="block" class="alert alert-info">
**:information_source: Note:**<br>
* Refer to [Expense Tracker Command Parameters](#441-expense-tracker-command-parameters) for more details about each parameter.
</div>
Example :
You wish to view your expenses from highest to lowest cost to determine which expenses are contributing most to your total expenditure.
You can follow the steps below to sort your list of expenses.
Steps :
1. Type `sortexp desc` into the _Command Box_.
2. Pre
Outcome :
1. It will display a success message, as shown below.
2. Homerce will list out all the expenses sorted from highest to lowest cost.
![sortexp](images/sortexp.png) <br>
Figure 1 - GUI for `sortexp`
```

