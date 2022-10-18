## observation_planner_for_astroimagej

## Integrates observation planning with AstroImageJ 

README file for AstroImageJ plugin to support observer planning and create radec aperture coordinate files.
<br/>See the User Guide pdf (below) for software setup and user instructions.

<br/><br/>
**Download files:**
- astro_plugins-1.0x.jar: java-8 jar, compiled as an ImageJ plugin to link astap.jar to AIJ plugins menu options.
- planner.jar: java-17 jar, compiled as a java exe with no external dependencies (uber-jar)
- User Guide Observation Planner for AstroImageJ.pdf

Click 'Releases' link on the right side of the repo Code page<br/>
In Releases page, select latest release
<br/>Click link to  User Guide Observation Planner for AstroImageJ.pdf
<br/>Open Assets, click links to astro_plugins-1.0x.jar and planner.jar<br/>

**Software Notes**

astro_plugins-1.0x.jar is an ImageJ plugin, ref: https://imagej.net/Developing_Plugins_for_ImageJ_1.x.. 
The plugin is coped to folder  ./AstroImageJ/Plugins/Astro Apps and invoked through AIJ plugins menu. 
Selecting 'Run Planner App' invokes exe jar: planner.jar
<br/>

**PLANNER.JAR**
- Java 17 application copied to AstroImageJ plugins folder
- Maven build, compiles all dependencies into a single exe jar (uber jar)
- Swing application with FlatLightLaf Look and Feel, ref: https://www.formdev.com/flatlaf/
- tested on WIN7 and WIN10,  expect to be Linux compatible but untested


