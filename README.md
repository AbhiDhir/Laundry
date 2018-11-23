## Inspiration 
The laundry system at Jester West dormitory consists of dragging a heavy laundry basket across the hallway only to find that all the laundromats are taken, then bringing it back to the dorm for nothing. We wanted to optimize this system and make it so that we could check the availability remotely. 

## What It Does 
The UT Laundry app checks the availability of the laundromats on each floor and specifies the time left. It sends a notification to the user once the laundry is done and marks it as available. Furthermore, there is a website that shows you the availability of the laundromats without having to download the app.

## How We Built It 
We built the Android Application and the corresponding database through Android Studio and Firebase. When the user first enters the application they are prompted for their floor number which is then saved as a setting. The app then has 3 tabs. The first tab is to display the washers/dryers which are unused, as well as those that are and their corresponding time remaining. The specific database being used is the Cloud Firestone Database. A request is issued to the database, and the app correspondingly parses the information and returns the values. The next tab has the user input to say when they are using the laundry. This is done using Microsoft Azure vision. The user would be required to take a picture of the laundry machine and the application parses the time remaining as well as an ID number using regular expression. This information is then sent to the database to update the washers that are available. 

The Website was built using HTML, CSS, as well as Javascript. This is necessary to display the correct information as well as to update the database every minute to decrement the time left on the machines.


## Challenges We Ran Into
At first, we planned to use QR codes to make each machine unique. After spending hours on developing the code and eventually finishing that section, we found that we could just use Azure to capture a code number. However, we struggled to connect Azure to the database. Furthermore, creating a push notification when the timer ended required an outside server because Firebase would not countdown while it was serverless. We also had difficulty adding Firebase to the website; however, we were able to push through it eventually and even used the website to decrement the times. 

## Accomplishments That We're Proud Of
Although the app is simple, it has a strong foundation to expand upon. We didn't use the QR codes in our project, but we were able to build and understand QR codes in a proactive manner. We were also able to use Azure and experience cognitive science in technology, something we would not have otherwise had access to. Overall, we are proud of our product and the progress we've made throughout the whole Hackathon, especially through the struggles we faced.

## What We Learned
We learned how to create a QR code scanner along with the use of Microsoft Azure Cognitive Sciences Vision API. This was a very long process but was worth the effort as we are now able to use a QR scanner and the Vision API on any of our other projects. Our learning of the Firebase software was very rapid. We able to incorporate many details of a database onto a website that operated through the use of an app. Connecting all these individual things were very important as we now know how each relates to a larger whole. 

## What's Next for UT Laundry
Further improvements to laundry would be to have the azure side of the application fully integrated into our main application. We would also like to make the graphics as well as user interface for the whole app to be improved. In the future we also would ideally move on to an automated approach to updating the availability as that would not require any work for the users. We would also like to add push notifications in the future so that the user is notified once the state of the laundry is different.
