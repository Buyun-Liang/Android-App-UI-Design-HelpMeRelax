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
 

## App Demo 

https://drive.google.com/file/d/12nfS40Rxv-xnLs0kgs1ryV4r8nItKYWy/view?usp=sharing

## Usage
1. Using the output file *HelpMeRelax.apk*: Open Android Studio -> Profile or debug APK (select HelpMeRelax.apk) -> Click HelpMeRelax Folder: HelpMeRelax.apk -> set android simulator to be Pixel 3 XL API 30 -> click run.
2. Import the whole porject: Open Android Studio -> Import Project (Gradle, Eclipse ADT, etc) -> Set android simulator to be Pixel 3 XL API 30 -> click run.


## Contact
Created by Buyun Liang [liang664@umn.edu] (https://www.linkedin.com/in/buyun-liang/) and Xihao Li [li002278@umn.edu] - feel free to contact us if you have any questions!
