# LaserboxGcodeSender
An alternative to XCS for sending 3rd party generated gcode to the XTools series of Co2 laser cutters

## Background
Until recently, with the beta of XTool Creative Suite (XCS), users of XTool Co2 lasers were required to relay on XTool's proprietary software, LaserBox, as a gcode generator and sender. In short, the software is a dumpster fire and a source of much angst for owners of these machines. As an answer to thie problem XTool is working on adding support for their Co2 lasers to their new fangled XCS software. Since this software works with their other series of lasers, it is a road well travelled and is more likely to get bug fixes and feature additions. However, anyone that has used XTools created software knows that software development is not their strong suite and I am of the opinion that many of the same type of bugs to be found in the LaserBox will manifest in XCS. However, XTool has added support to XCS to transform and upload gcode generated from third party tools such as LightBurn. While a big step in the right direction the implementation has the following limitations

1. Support for exposing the laser's built in camera, such that it can be used for work placement, is not present and user have to rely on absolute positioning.
2. Support for using the rotary is not present in this workflow.
3. Support for measuring material thickness, to auto adjust focus is not present though there are ways to work around this. 
4. XCS is still a man in the middle and subject to XTools continued lack of software quality.

## GCode translate and send support in XCS
The gcode support in XCS is actually a pretty thin shim of functionality. It ingests a provided gcode file, does some translation, and uploads a zipped version to the machine via the same HTTP call used when gcode is generated from the XCS or LaserBox softwares. Ingest file -> transform -> upload is not a particularly complex software operation and something that can be relatively easily recreated without xtools software. Some of the gcode transformations done by XCS are:

1. Negating X and Y coordinates
    - Reasoning: For some reason XTool decided to use a negative coordinate system for the LaserBox machine. Home, (0,0), is in the left rear and coordinates to the right and forward are negative and coordinates to the back and left are positive.
    
2. Conversion of the provided gcode to an absolute coordinate system.
    - Reasoning: The machine seemingly only works in absolute coordinates and does not appear to have support for relative coordinates.
    
3. Minor formatting changes to the gcode.
    
 
### Gcode Transformation Example: Transformed on the left, input from LightBurn on the right
![transformed gcode](https://user-images.githubusercontent.com/1959884/214913335-6fd0ba51-f6ad-4014-8d45-78c4166a67ac.png)

## Project Goals
1. To provide an alternate solution to XCS's transform and send functionality
2. Provide a workflow with less steps than XCS to upload gcode to the machine. The expected user workflow is 
    - Save source gcode file to designated location on file system
    - Press button on LaserBox to start the job
3. Provide a mechanism to stop a gcode driven project once started. This is missing in XCS's gcode support.
4. To provide a platform for which the limitations of the XCS solution can be addressed. Future goals include
    - Integration with relatively cheap 3rd party cameras that are compatible with LightBurn allowing work placement via camera
    - Rotary support
5. To be responsive to found issues and provide a publicly visible platform to view/record issues.


### Project Structure
The project will consist of a series of folders and a couple of simple daemons that monitor these folders transforming and moving the files between them.

Folders:
1. Input folder: (User provided) the folder on the system for which users will save gcode exported from lightburn
2. Processed folder: the folder that will hold files after having been transformed to gcode compatible with the Laserbox
3. Uploaded folder: Contains copies of files that have been uploaded to the machine.

### Installation
The program is written and Java and requires Java version 17 to be installed on your computer..

1. Download and install the appropriate java distribution ![for your platform](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
2. Download the latest released ![jar file](https://github.com/gsrunion/LaserboxGcodeSender/releases)
3. Open a terminal, navigate to the directory where you downloaded the jar, and run the following command `java -jar .\LaserboxGcodeSender-0.0.X.jar' (use a forward slash on OSX or Linux). I will be adding directions in the near future on how to avoid using the command line to launch.

### Usage
1. Click 'Start Monitoring'
2. Select a folder where you wish to save gcode files output from LightBurn.
3. Follow the ![xtool provided instructions](https://community.xtool.com/#/making/detail/tips/662) for generating gcode (semi) compatible with the Laserbox from LightBurn
4. Save the generated gcode to your previously selected folder. Observe machine beep in response to having been sent the file.
5. Press the button on the machine as you normally would to start a cut.

*NOTE* the usb connection to the machine has to be alive and well for the application to send the file over. Historically the usb connection to the machine has been flakey. However, I plan on adding directions on how to look confirm, by way or your OS, that the machine is alive and well as well as adding indications of machine connectivity inside the application.




