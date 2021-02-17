# STARS Course Registration System
#### Recreating NTU's BEST course registration system in Java

*Done by: Lim Sheng Jie, Ong Hiok Hian, Koh Yu Xuan, Patria Lim Yun Xuan*

For CZ2002
---

<h2>Table of Contents</h2>

* [Description of Problem](#description-of-problem)
* [Pitch Video](#pitch-video)
* [Solution Architecture](#solution-architecture)
* [Hyperlink to detailed solution](#hyper)
* [Project Roadmap/Proposed timeline](#project-roadmap-proposed-timeline) 
* [Getting started](#getting-started)
* [Running the Tests](#running-the-tests)
* [Features and Limitations](#features-and-limitations)
* [TODO](#todo)

---
---

<h2>Description of Problem</h2>
<p>SCDF responded to more than 2,500 fire calls in 2019, an increase of 7.8% from 2018. 

Team MERCI seeks to address this issue through the MERCI system. The MERCI System tackles problem statement 3 INTEGRATING WITH A SMART ENVIRONMENT
SCDF receives 350 Unattended Cooking Fires, 240 Discarded Items Fires, 1700 Rubbish Chute Fires.
Utilising IBM Cloud Tools and Hardware, Team Merci introduces to you an integrated, comprehensive solution which leverages smart sensors and the Internet of Things  (IoT) to mitigate fires when or before they occur and prevent precious emergency resources from being deployed.
Our solution covers three most common types of fires in the community: household fires resulting from unattended cooking, rubbish chute fires as well as residential fires (like our Hubs). We believe that with this suite of technology, it will definitely help in early prediction and prevention, allowing precious resources to be used for other means. 
Initially, this Merci System is targeted for domestic fires, it comprises 3 main components which tackles the issue of unattended cooking fires in households (top cases SCDF respond to), the issue of fires in discarded items and the issue of rubbish chute fires. We proposed integrating this Merci System in new HDB estates such as the stove come with.</p>

---
<h2>Pitch-Video</h2>

[video link](https://youtu.be/i3Sf6ZVtoys)

<h2>Architecture of Proposed Solution</h2>

Hardware
NodeMCU V3 microcontroller was used in the working prototype, along with a DHT11 temperature sensor. However, the prototype’s sensors are limited in their range and sensitivity. 
The proposed solution will include a microcontroller used  larger suite of low-cost and reliable sensors such as flame, gas sensors.

Software
*Image Recognition*
With the aid of predictive technology using Deep Learning algorithms, a .h5 model was created using a dataset of over 100 images of Fires and Non-fires obtained from Kaggle. We propose a collaboration between SCDF and SPF, allowing our predictive model to be integrated with Neighbourhood watch CCTV cameras. Upon detection of a potential fire (i.e. a confidence score over 0.40), a connection will be established to SCDF HQ through the Dashboard. This new insight gleaned through the Live CCTV footage allows SCDF personnel to make a human judgement before deciding on the mode of deployment.

*Dashboard*
Uses Node-RED, a flow-based development tool for wiring together hardware devices
Saves and retrieves data to and from Google Firebase 

*Improvements on myResponder App*
Uses Flutter to build the front end of myResponder App. Main features include showing a visual workflow of how the App can be used to connect community first responders 
Community first responders are a pillar for fast quick response and we plan to tap on this ready pool of responders to help check on the situation before notifying SCDF. This is to ensure precious resources are not wasted and more easily deployed. 
Furthermore, the uploading of images and text can definitely help in allowing SCDF to gain better sense of the whole situation and make adjustment to deployment changes when necessary

<h2>Detailed Solution</h2>

[detailed solution](https://docs.google.com/document/d/1zixBiHYpchru3Kff5rlpJJp32ObuCSlpOnKgC0mCswE/edit)

<h2>Project Roadmap/Project timeline</h2>

Collaboration roadmap (3 weeks)
Public: Market research will be conducted on households to determine public concerns and feedback regarding our proposed suite of Smart Merci Home Detection Sensors. Furthermore, with regard to integration of models in neighbourhood cameras, research will be done to understand public sentiment to the use of CCTVs for detection of fire. 
SPF: Collaboration will be done with SPF to tap on their wealth of neighbourhood surveillance CCTVs deployed across the island. Footage of CCTV recordings of past fire outbreaks can be obtained for more effective training accuracy, though this will be subject to privacy concerns.

Manufacturing + Integration of Technologies  (2 weeks)
Based on the frequency and location of past incidents, several clusters around Singapore will be involved in our trial. Example locations include areas with high incidence of fires in the community, and areas with a larger elderly population. These trials involving the deployment of fire blankets and sensors in households and the use of predictive modelling in CCTVs will be carried out over the period of a month before a review will be done.

Trial (1 month)
Based on the frequency and location of past incidents, several clusters around Singapore will be involved in our trial. Example locations include areas with high incidence of fires in the community, and areas with a larger elderly population. These trials involving the deployment of fire blankets and sensors in households and the use of predictive modelling in CCTVs will be carried out over the period of a month before a review will be done.

Review of Trial and Nationwide deployment
After the review of trail and nationwide deployment, we will gather feedback to further improve on our system such as addressing the new concerns and also make it more user friendly and targeted. 

<h2>Getting Started</h2>

Node-red
Install Node-red and download the required nodes. 

Application
Download the Zip File titled ‘myResponder’, run it on Android Studio. An apk file is also provided. Should the download fail, a screen recording is also provided to show how it should look like, titled ‘Simulator Screens’. 

Hardware
You’ll have to install the Arduino IDE, as well as packages (links in the code). 
(Optional) Download Node.js, Mosquitto for debugging.
The Arduino IDE code is provided under NodeMCU_IBMIOT. You will need a NodeMCU V3 board, a DHT11 Temperature/Humidity Sensor. 

<h2>Running the tests</h2>

Node-red
- Debugging tools are added to certain nodes
- Simulation nodes are also added to simulate the hardware sensors

CCTV Image Classification
The Public fires.py file contains the Python Script used for training the model. 


<h2>Live Demo</h2>

Shown in video. [Live Demo](https://youtu.be/i3Sf6ZVtoys)

<h2>What your team used to build your solution</h2>

- IBM Watson IOT
- Node-Red
- NodeMCU + Arduino IDE
- Google Firebase [Google Firebase](https://console.firebase.google.com/u/0/project/scdf-node-red/database/scdf-node-red/data)
- Flutter
