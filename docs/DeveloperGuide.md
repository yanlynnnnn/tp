---
layout: page
title: Developer Guide
---
# GrAB3 Developer Guide

## Table of Contents:
 * [1. Introduction](#1-introduction)
 * [2. Setting up, getting started](#2-setting-up-getting-started)
 * [3. Design](#3-design)
 * [4. Implementation](#4-implementation)
 * [5. Documentation](#5-documentation)
 * [6. Logging](#6-logging)
 * [7. Testing](#7-testing)
 * [8. Configuration](#8-configuration)
 * [9. DevOps](#9-dev-ops)
 * [Appendix A: Product Scope](#appendix-a-product-scope)
 * [Appendix B: User Stories](#appendix-b-user-stories)
 * [Appendix C: Use Cases](#appendix-c-use-cases)
 * [Appendix D: Non Functional Requirements](#appendix-d-non-functional-requirements)
 * [Appendix E: Glossary](#appendix-e-glossary)
 * [Appendix F: Instructions for Manual Testing](#appendix-f-instructions-for-manual-testing)
 * [Appendix G: Effort](#appendix-g-effort)

## 1. **Introduction**

**GrAB3** is a desktop business management application meant for home-based beauty salon owners who want to consolidate all
the information related to their business, such as upcoming appointments, their list of clients, as well as profits recorded. 
It focuses on the Command Line Interface (CLI) while providing users with a simple and clean Graphical User Interface (GUI).
Thus, the main interaction with **GrAB3**. will be done through commands.

The features of GrAB3 include:
* Keeping track of existing/new clients.
* Scheduling of upcoming appointments with clients.
* Recording of revenue from services provided.
* Recording of business-related expenses.
* Calculation of business profit.

The purpose of this Developer Guide is to help you understand the design and implementation of **GrAB3**, 
so that you can get started on your contributions to **GrAB3**.

## 2. **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

## 3. **Design**

### 3.1 Architecture

<img src="images/ArchitectureDiagram.png" width="450" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

The sections below give more details of each component.

### 3.2 UI component

![Structure of the UI Component](images/UiClassDiagram.png)

**API** :
[`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `ClientListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class.

The `UI` component uses JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### 3.3 Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

1. `Logic` uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a client).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

### 3.4 Model component

![Structure of the Model Component](images/ModelClassDiagram.png)

**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

The `Model`,

* stores a `UserPref` object that represents the user’s preferences.
* stores the address book data.
* exposes an unmodifiable `ObservableList<Client>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* does not depend on any of the other three components.


<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Client` references. This allows `AddressBook` to only require one `Tag` object per unique `Tag`, instead of each `Client` needing their own `Tag` object.<br>
![BetterModelClassDiagram](images/BetterModelClassDiagram.png)

</div>


### 3.5 Storage component

![Structure of the Storage Component](images/StorageClassDiagram.png)

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

The `Storage` component,
* can save `UserPref` objects in json format and read it back.
* can save the address book data in json format and read it back.

### 3.6 Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## 4. **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedAddressBook`. It extends `AddressBook` with an undo/redo history, stored internally as an `addressBookStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedAddressBook#commit()` — Saves the current address book state in its history.
* `VersionedAddressBook#undo()` — Restores the previous address book state from its history.
* `VersionedAddressBook#redo()` — Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitAddressBook()`, `Model#undoAddressBook()` and `Model#redoAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th client in the address book. The `delete` command calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new client. The `add` command also calls `Model#commitAddressBook()`, causing another modified address book state to be saved into the `addressBookStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will not be saved into the `addressBookStateList`.

</div>

Step 4. The user now decides that adding the client was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

![CommitActivityDiagram](images/CommitActivityDiagram.png)

#### Design consideration:

##### Aspect: How undo & redo executes

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the client being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_

## 5. **Documentation**

Refer to the guide [here](Documentation.md).

## 6. **Logging**
Refer to the guide [here](Logging.md).

## 7. **Testing**
Refer to the guide [here](Testing.md).

## 8. **Configuration**
Refer to the guide [here](Configuration.md).

## 9. **Dev-ops**
Refer to the guide [here](DevOps.md).

## **Appendix A: Product Scope**

**Target user profile**:
* Independent home-based business owner.
* Has little knowledge of business management software.
* Prefers to have relevant business components in a single application.
* Is a fast typist.
* Prefers typing over using mouse input.

**Value proposition**:
* Consolidates everything a home-based business needs such as appointments, clients, expenses, revenue and services into one place
* Saves significant time for the business owner, who previously had to manage details across his/her contacts, excel sheets, and inventory notebooks.
* Does not require extensive technical knowledge compared to other business management software.
* Displays expenses and revenue in a simple format for users to view.

## **Appendix B: User Stories**

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                                          | I want to …​                                                                                                             | So that I can…​                                                                                                      |
| -------- | ----------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `* * *`  | Meticulous home-based beauty salon owner        | Keep track of my total monthly revenue                                                                                  | Have a good idea of how my business is doing                                                                        |
| `* * *`  | Budget-minded home-based beauty salon owner     | Keep track of my total monthly business-related expenses                                                                | Adjust the pricing of my services accordingly                                                                       |
| `* * *`  | Business-minded home-based beauty salon owner   | Keep track of my total monthly profit                                                                                   | Understand if my business is profitable and if it falls within a healthy profit margin                              |
| `* * *`  | Forgetful home-based beauty salon owner         | Find a service based on its name/keyword                                                                                | Easily refer to the price/duration of the service to answer client queries                                          |
| `* * *`  | Home-based beauty salon owner                   | Edit a service                                                                                                          | Change details about a specific service accordingly, such as adjusting the price/duration                           |
| `* * *`  | Home-based beauty salon owner                   | Delete a service                                                                                                        | Remove a service that I am no longer offering                                                                       |
| `* * *`  | Home-based beauty salon owner                   | Add a service                                                                                                           | Enter a new service that I recently decided to offer                                                                |
| `* * *`  | Home-based beauty salon owner                   | List my services                                                                                                        | View all the services that I am currently offering                                                                  |
| `* * *`  | Organized home-based beauty salon owner         | Keep track of all my clients                                                                                            | To find my clients easily when I want to contact them                                                               |
| `* * *`  | Home-based beauty salon owner                   | Add a client                                                                                                            | Record a new client that has not visited my salon before                                                            |
| `* * *`  | Home-based beauty salon owner                   | Edit a client                                                                                                           | Change details about a specific client, such as their new contact information                                       |
| `* * *`  | Home-based beauty salon owner                   | Find a client by their name or phone number                                                                             | Determine if the client has visited my salon before, and find their contact details from their name or vice versa   |
| `* * *`  | Organized home-based beauty salon owner         | Keep track of all my appointments, including the date and time of the appointment, service provided, and client served, | Organize my work schedule and avoid double-booking of appointments                                                  |
| `* * *`  | Home-based beauty salon owner                   | Add an appointment                                                                                                      | Enter a new appointment made into my appointment schedule                                                           |
| `* * *`  | Home-based beauty salon owner                   | Edit an appointment                                                                                                     | Change appointment details, such as date/time if the appointment is postponed                                       |
| `* * *`  | Home-based beauty salon owner                   | Delete an appointment                                                                                                   | Remove an appointment from my schedule if the client cancels or does not turn up                                    |
| `* * *`  | Forgetful home-based beauty salon owner         | Find an appointment                                                                                                     | Easily refer to the appointment details to answer client queries                                                    |
| `* * *`  | Home-based beauty salon owner                   | Mark an appointment as done                                                                                             | Add a record for revenue earned from that appointment                                                               |
| `* * *`  | Home-based beauty salon owner                   | List my revenues                                                                                                        | View all the revenue entries that I have                                                                            |
| `* * *`  | Forgetful home-based beauty salon owner         | Find a revenue                                                                                                          | See exactly how much revenue a certain type of service is bringing in                                               |
| `* *`    | Home-based beauty salon owner                   | Add an expense                                                                                                          | Record a new expense that I have made                                                                               |
| `* *`    | Home-based beauty salon owner                   | Tag my expense                                                                                                          | Organise my expenses according to the categories they fall under, such as an expense related to a particular service|
| `* *`    | Home-based beauty salon owner                   | Edit an expense                                                                                                         | Change the details of an expense, in the case that I input the wrong price/description of the expense               |
| `* *`    | Home-based beauty salon owner                   | Delete an expense                                                                                                       | Remove an expense that I may have added mistakenly                                                                  |
| `* *`    | Home-based beauty salon owner                   | Sort my expenses based on their price                                                                                   | Have an idea of which expenses incur the most/least cost to my business                                             |
| `* *`    | Home-based beauty salon owner                   | List my expenses                                                                                                        | View all the expense entries that I have                                                                            |
| `*    `  | Busy home-based beauty salon owner              | Have a built-in help guide                                                                                              | Familiarize myself with the application quickly                                                                     |
| `*    `  | Home-based beauty salon owner                   | Clear all the information in the application                                                                            | Restart all my beauty salon related records from scratch                                                            |
| `*    `  | Prudent home-based beauty salon owner           | Have a breakdown of my total monthly expenses based on the type of expense                                              | Minimize my expenditure on certain types of expenses                                                                |
| `*    `  | Resourceful home-based beauty salon owner       | Have a breakdown of my total monthly revenue based on the type of service provided                                      | Have an idea of which services generate more revenue and adjust the services I provide accordingly                  |


## **Appendix C: Use Cases**

(For all use cases below, the **System** is `GrAB3` and the **Actor** is the `user`, unless specified otherwise)

### Services Management

#### UC001: Add a Service 
Add a service provided by the business into GrAB3.

**Preconditions: Appointment list must exist.**

**Guarantees: A new service will be added to the service list upon successful command.**

**MSS**
1. User adds a service by providing details.
1. GrAB3 adds the service to the service list.  
1. GrAB3 displays successful additional message.
Use case ends.

Extensions:  
* 1a. Incomplete details provided.  
  * 1a1. GrAB3 displays an error message.  
  Use case resumes at step 1.
        
#### UC002: Edit a Service
Edit the details of an existing service.

**Preconditions: Service exists in service list.**

**Guarantees: Updated service list with new service details.**

**MSS**
1. User requests to list all services.
1. GrAB3 shows a list of services.
1. User edits an existing service by providing the details.
1. GrAB3 update the details of the selected service.
1. GrAB3 update the service list.
Use case ends.

Extensions:
* 3a. Invalid index provided.
  * 3a1. GrAB3 displays an error message.  
  Use case resumes at step 1.

* 3b. Incomplete details provided.  
  * 3b1. GrAB3 displays an error message.  
  Use case resumes at step 1.
        
#### UC003: Delete a Service
Delete the selected service from the service list.

**Preconditions: Service exists in service list.**

**Guarantees: Updated service list with service specified by user deleted.**

**MSS**
1. User requests to list all services.
1. GrAB3 shows a list of services.
1. User request to delete a specific service.
1. GrAB3 delete a service. 
1. GrAB3 shows the updated list view.
Use case ends.

**Extensions**
* 3a. Invalid index provided.
  * 3a1. GrAB3 displays an error message.  
  Use case resumes at step 1.

#### UC004: Find a Service
Find a service in the service list.

**Preconditions: Service exists in service list.**

**Guarantees: Display all services in the service list that matches the search value.**

**MSS**
1. User requests to list all services that matches the search value.
1. GrAB3 searches for services that matches search value.
1. GrAB3 show list of all services that matches the search value.
Use case ends.

**Extensions**
* 2a. No service matches the search value.
  * 2a1. GrAB3 displays empty list.
  Use case resumes at step 1.
  
#### UC005: List Services 
List all the services in the service list.

**Preconditions: Service exists in service list.**
 
**Guarantees: All services in the service list will be displayed.**
 
**MSS**
1. User requests to list all services.
1. GrAB3 display all services in the service list.
Use case ends.

**Extensions**
* 1a. No service in service list.
  * 1a1. GrAB3 displays empty list.
  Use case resumes at step 1.
  
#### UC005: Clear Services
Clear all services in the service list.

**Preconditions: Service exists in service list**

**Guarantees: An empty revenue list.**

**MSS**
1. User requests to clear the list.
1. GrAB3 shows the updated list.
Use case ends.

### Client List

#### UC001: Add a client to client list

**Preconditions: A client must exist**

**Guarantees: A new client will added to the client list** 

**MSS**
1.  User requests to add a new client into the client list.
1.  GrAB3 shows the updated client list
Use case ends.

**Extensions**

* 1a. Client description is empty.
    * 1a1. GrAB3 shows an error message.
    Use case resumes at step 2.

#### UC003: Delete a client**

**Preconditions: client schedule must exist**

**Guarantees: The client specified by the user will be deleted**

**MSS**
1.  User requests to list all clients.
1.  GrAB3 displays a list of clients.
1.  User requests to delete a specific client from the list generated.
1.  GrAB3 shows the updated list after deletion of the client.
Use case ends.

**Extensions**
* 3a. The specified client does not exist.
    * 3a1. GrAB3 shows an error message.
    Use case resumes at step 2.

#### UC004: Edit a client

**Preconditions: Client exists in TaskSchedule**

**Guarantees: Client specified by user gets edited**

**MSS**
1.  User requests to list all clients.
1.  GrAB3 shows a list of clients.
1.  User requests to edit the description of a specific client from that list.
1.  GrAB3 shows the updated client.
Use case ends.

**Extensions**
* 3a. The given index is invalid.
    * 3a1. GrAB3 shows an error message.
    Use case resumes at step 2.

### Appointment List

####UC01: Add an appointment into the appointment list

**Preconditions: Appointment list must exist**

**Guarantees: A new appointment will be added to the appointment list**

**MSS**
1.  User adds appointment into appointment list.
1.  GrAB3 shows the updated list of appointments.
Use case ends.

**Extensions**
* 2a. The specified module code is invalid.
    * 2a1. GrAB3 shows an error message.
    Use case resumes at step 1.

### Revenue List

#### UC05: Clear the revenue list**

**Preconditions: Revenues exist in revenue list**

**Guarantees: An empty revenue list **

**MSS**

1.  User requests to list all revenues.
2.  GrAB3 shows a list of revenues.
3.  User requests to clear the list.
4.  GrAB3 shows the updated list.

    Use case ends.

**Extensions**

### Expense List

#### UC04: Sort expenses by ascending/descending order

**Preconditions: Expenses exist in expense list**

**Guarantees: View of expenses sorted in order specified by user.**

**MSS**
1.  User requests to list all expenses.
1.  GrAB3 shows a list of expenses.
1.  User requests to sort the expenses by ascending order.
1.  GrAB3 shows the sorted list view.
Use case ends.

**Extensions**

### Others

*{More to be added}*

## **Appendix D: Non-Functional Requirements**

* System Requirements:
    * GrAB3 should work on any _mainstream OS_ as long as it has Java `11` or above installed.
    * GrAB3 should be optimized for keyboard input and can function without the use of a mouse.
      However, a mouse would improve the user experience.
    * The computer running the Java Virtual Machine (JVM) should have sufficient disk space to
      accommodate the user's data stored in the system. It should also have sufficient RAM
      and CPU power to run the JVM smoothly.
* Performance Requirements:
    * GrAB3 should be able to start up and load existing the user's stored data sufficiently fast (< 10s). 
    * Context switching / menu navigation through the use of either text commands or button clicks should be sufficiently fast (< 10s). 
* Usability:
    * GrAB3 should be user-friendly for any client who can use a computer and does not require prior technical knowledge.
    * The user interface of GrAB3 should look intuitive and simple to navigate. It should not look cluttered with too many panels.
* Reliability:
    * GrAB3 should not crash in the event of incorrect user input - this should be handled safely with exceptions.  
* Scalability:
    * GrAB3 should be able to handle thousands of appointments, clients, expenses and all other recorded entries by a user.
     No expansion of hardware capabilities or software modifications should be required.

## **Appendix E: Glossary**

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Private contact detail**: A contact detail that is not meant to be shared with others
* **JVM**: Java Virtual Machine - Java code that is compiled is run in the virtual machine.

## **Appendix F: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a client

1. Deleting a client while all clients are being shown

   1. Prerequisites: List all clients using the `list` command. Multiple clients in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No client is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_

## Appendix G: Effort

{to be added...}
