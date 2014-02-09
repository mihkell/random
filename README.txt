





Problems:
1) "Main type not spesified" 
Solution is: "It has been workarounded by adding explicitely "com.google.gwt.dev.DevMode" in the "Main class" field on the "Main" tab in the run configuration"
2) "Missing required argument 'module[s]'"
"Run Configurations->Arguments" and add to the end of "Program arguments:" the ".gwt.xml" path without the ".gwt.xml" for example: " com.etsyheroku.EtsyHeroku.EtsyHeroku" my .gwt.xml was in com/etsyheroku/EtsyHeroku/EtsyHeroku.gwt.xml
3) java.lang.NoSuchFieldError: warningThreshold
Use GWT version 2.6.0-rc3