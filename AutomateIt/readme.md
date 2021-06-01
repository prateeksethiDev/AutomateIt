## **AutomateIt**

Test Automation Framework for Web applications using following technologies.
[1] Selenium 3
[2] Java 8
[3] TestNG
[4] ExtentReport
[5] Apache Log4J

**Description**<br>
Supports execution of tests on Remote Grid Setup. Includes yaml manifest files for  Selenium Grid 3 setup on kubernetes cluster.
This will enable QA to deploy Selenium to Kubernetes in a scalable fashion.

**Prerequisites**<br>
Assuming you have a working Kubernetes cluster and a properly configured kubectl client. See the Getting Started Guides for details.
Your cluster nodes must have 4 CPU and 3 GB of RAM each, in order to work properly.
You ca start with one master and one worker node.

All the yaml manifest files can be found under project cluster-setup directory.

>[1] K8S Deployment is used for setting up Selenium hub.<br>
>[2] K8S ReplicationController is used for setting up  chrome/firefox node.<br>
>[3] K8S Service of type NodePort is used to acccess Selenium Grid outside of cluster.<br>