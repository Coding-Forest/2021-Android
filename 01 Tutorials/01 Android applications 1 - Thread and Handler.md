# Android applications 1 - Thread and Handler

---

### 1) Thread in Android 

When an application is launched, a thread is created in the runtime system. All application components are executed within that thread, which is the **main thread**.

What it does -

-  handles UI

Warning -

- If there is an app component in the main thread that takes a long time to be processed, the UI will look like frozen until the task is over. Therefore, it is best to avoid such tasks within the main thread.
- It is not possible to directly change the UI in other thread code outside the main thread.



- Why use xml for UI?
  - It helps us to separate the design from dynamic processes. 
- In application development, content that may be later edited, including configuration, is not written in the source code.
- **The Process**
  - Source code is executed after compile and build.
  - If the source code is modified, you should compile and build again. 
  - If the data, which is not part of the source code, is modified, it can be just read again after edits.
    - It is best to save such variable data in the database rather than in the source code.
    - Data are saved as properties (taking this form >>  key: value)
    - Popular file formats: xml, json, yaml



1. **Create a new project**

   

   [File] > [New] > [New Project]

![image-20210914100215344](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914100215344.png)





Choose a template of your choice. 

![image-20210914100234246](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914100234246.png)





Remember, it is not possible change the name after your app is deployed on the market. 

Choose your language, 

choose the right version. 

![image-20210914100653099](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914100653099.png)



** Threads and Handler** in Android Applications

1) Modify activity_main.xml to design your app view. 

   ![image-20210914100954874](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914100954874.png)

Double click **activity_main.xml** to open the following pane.

![image-20210914101125249](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914101125249.png)



In **androix.constraintlayout.widget.ConstraintLayout**:

```
<androidx.constraintlayout.widget.ConstraintLayout 
    android:orientation="vertical"
   >
```

add **```android:orientation="vertical"```**.





```match_parent```: full screen size.

![image-20210914101343132](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914101343132.png)



Create a button.

![image-20210914101546934](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914101546934.png)





![match_parent wrap_content](C:\Users\admin\Desktop\match_parent wrap_content.png)



Create some objects including button to furnish your app interface.

![image-20210914102830868](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914102830868.png)





In GUI programming, if a function is written to perform multiple GUI updates, the updates will be handled altogether as a batch. Here, the function is supposed to update the value every 1 second on a button click. However, the updates will be executed in batch as it is within a single function. This kind of updates should be handled using **thread**.

![02 threadify](C:\Users\admin\Desktop\02 threadify.png)

![image-20210914105529286](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914105529286.png)

The number increments every 1 second when the start button is clicked.

This may work well, but if you update the UI directly in the thread, an exception may occur. 





### 2) Handler

---

An object for handling inter-thread communication

![image-20210914111117677](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210914111117677.png)






