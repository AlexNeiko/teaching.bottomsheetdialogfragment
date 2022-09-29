Android BottomSheetDialogFragment with Callbacks to parent Fragment and transparent layer

that’s how it works
Git source code

https://github.com/AlexNeiko/teaching.bottomsheetdialogfragment

If you need to make a pop-up menu using BottomSheetDialogFragment and do it beautifully, this article is for you. So kids let’s get started. This code will be clean and easy to master.

Here’s what Google says about BottomSheetDialogFragment:

Modal bottom sheet. This is a version of DialogFragment that shows a bottom sheet using BottomSheetDialog instead of a floating dialog.

Step 1. Create a project
To understand the structure, we will create a new project “Bottom Navigation Activity” in Android Studio. This structure is quite often used in work projects. There will also be jetpack navigation, single Activity, Fragments. And corresponds to a clean architecture. If you don’t understand it yet, don’t worry, just know — this is what Google recommends.

1.1 New Project -> Bottom Navigation Activity



Most likely you will have a similar structure.



In an empty project we don’t need to add any dependencies to gradle. Everything is included in the standard Android jetpack package

The starting fragment looks like this


Step 2. Let’s coding
2.1 Fragment view

There will be a simple implementation on the screen. A string with data and a button to open a dialog.
In the fragment_home file.xml insert this code


Application Architecture


We will use the BottomSheetDialog, and in the constructor of which, when creating we will pass the data for display and the call listener. The parent fragment will implement the Listener Interface. (The interface itself is described inside the BottomSheetDialog)
To do this we need a data model, a dialog class and an interface with call methods.

2.2 In the root package of the application, create a package “model” -> create a data class Card in it. This is how the simplest structure looks like.


2.3 Change the ViewModel for the fragment to get data from it (in the example credit cards). We have the simplest plug. We will not complicate the project with extra code. But you shouldn’t do that. In a real project, data is provided from providers. Using multithreading (RX, flow) and requests to the network.


2.4 Download some drawable resources from the git repository. Dialog icons, background layouts. Also note that you need to copy the colors to values.

2.5 Create xml layouts for the dialog and its individual elements.




2.6 Now let’s move on to creating a dialog class.

I’ll tell you how everything will work. Fragment/Activity will implement the interface from the dialog. Also in the parent fragment you will need to create a dialog when you click on the button and pass the data to display + the callback object to the constructor. It will be the link between the fragment and our dialogue.
Then we will override all the methods in the parent Fragment. It’s very simple :)

An important moment! I didn’t understand why when creating a dialog I couldn’t set a transparent background in any way (needed for rounded edges). The fact is that your xml dialog will inflate into another layer under the hood of Google. Therefore you need to redefine onCreateDialog.

This is followed by a simple function of programmatically generating View elements. You will have your own.


Step 3. Final
Now initialize the creation of the dialog in the fragment and override the callbacks.

How do we connect two fragments? The parent fragment implements the listener interface.

That’s why: listener = this

We will pass it to the dialog constructor


I congratulate you, we finished it together :) Enjoy new knowledge and put it into practice.

