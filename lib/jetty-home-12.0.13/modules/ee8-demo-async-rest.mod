# DO NOT EDIT THIS FILE - See: https://jetty.org/docs/

[description]
Demo Async Rest webapp

[environment]
ee8

[tags]
demo
webapp

[depends]
ee8-deploy

[files]
basehome:modules/demo.d/ee8-demo-async-rest.properties|webapps/ee8-demo-async-rest.properties
maven://org.eclipse.jetty.ee8.demos/jetty-ee8-demo-async-rest-webapp/${jetty.version}/war|webapps/ee8-demo-async-rest.war
