# UI Design for Android App: Help Me Relax
The main goal of this social media android app is to help students share their feelings with other people and get help from others.

## Table of contents
* [General Information](#general-information)
* [File Description](#file-description)
* [App Demo](#app-demo)
* [Usage](#usage)
* [Contact](#contact)

## General Information
What we have done:

1. Implemented the Android UI which allows the user to navigate all post sessions and communicate through posts and replies

2. Developed a dynamic UI by using Navigation Drawer and a vertically-scrollable collection of views by using ListView

3. Designed the post sessions and reply sessions which could perform CRUD operations by using SQLite as local storage

## File Description
In app/src/java/com/example/HelpMeRelax_v_1_0:

1. Welcome, SignUp, LoginActivity, MainActivity, HelpActivity,ChatActivity, MakePost, PostSession Activity: Activity class for screens: Welcome, Signup, Login, Home page, Help center, Chatroom, Make new post page, Post session.

2. PostModel, ReplyModel: Data Model for post sesion and reply session. 

3. PostDBHelper, ReplyDBHelper: Providing helpful methods for performing CRUD operations on the *post.db* and *reply.db* databases.
 
In app/src/java/com/example/HelpMeRelax_v_1_0/ui:
 
There are 7 folders (funding, health, peer, job, home, logout, Help), each of them contains 2 files: XXFragment and XX ViewModel. They are fragments and ViewModel in the navigation drawer.

app/src/main/res/layout: 

1. activity_chat.xml, activity_help.xml, activity_login.xml, activity_main.xml, activity_make_post.xml, activity_post_session.xml, activity_welcome.xml: These files contain the entire user interface of corresponding screens.

2. app_bar_main.xml :  This file contains blue app bar on the top.

3. fragment_funding.xml, fragment_health.xml, fragment_help.xml, fragment_home.xml, fragment_job.xml, fragment_logout.xml, fragment_peer.xml: These files contain the entire user interface of corresponding fragements in the navigation drawer.

4. list_items.xml, reply_list_items.xml: These files contain the UI of each post and reply.

5. nav_header_main.xml :  This file contains the overall structure of the drawer.

## App Demo 

https://drive.google.com/file/d/12nfS40Rxv-xnLs0kgs1ryV4r8nItKYWy/view?usp=sharing

## Usage
1. Using the output file *HelpMeRelax.apk*: Open Android Studio -> Profile or debug APK (select HelpMeRelax.apk) -> Click HelpMeRelax Folder: HelpMeRelax.apk -> set android simulator to be Pixel 3 XL API 30 -> click run.
2. Import the whole porject: Open Android Studio -> Import Project (Gradle, Eclipse ADT, etc) -> Set android simulator to be Pixel 3 XL API 30 -> click run.


## Contact
Created by Buyun Liang [liang664@umn.edu] (https://www.linkedin.com/in/buyun-liang/) and Xihao Li [li002278@umn.edu] - feel free to contact us if you have any questions!
