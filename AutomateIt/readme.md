# AutomateIt

AutomateIt is a test automation framework for web applications using the following technologies:
- Selenium 4
- Java 17
- TestNG
- ExtentReport
- Apache Log4J
- Apache POI

## Description
AutomateIt supports the execution of tests on a Remote Grid Setup. It includes YAML manifest files for setting up Selenium Grid 3 on a Kubernetes cluster. This enables QA to deploy Selenium to Kubernetes in a scalable fashion.

## Prerequisites
- You need a working Kubernetes cluster and a properly configured kubectl client. Refer to the Getting Started Guides for details.
- Each of your cluster nodes must have at least 4 CPUs and 3 GB of RAM to work properly. You can start with one master and one worker node.
- All the YAML manifest files can be found under the project's `cluster-setup` directory.

### K8S Deployment
K8S Deployment is used for setting up the Selenium hub.

### K8S ReplicationController
K8S ReplicationController is used for setting up the Chrome/Firefox node.

### K8S Service
A K8S Service of type NodePort is used to access the Selenium Grid outside of the cluster.

## Pod Debugging
Sometimes, it's necessary to debug the flakiness of tests during actual execution. This can be achieved by port forwarding from a given pod.
The default VNC port is 5900. We can do port forwarding for this particular port to any external port. We can also specify the IP address to listen on.


`kubectl port-forward --address 192.168.0.105 pod/selenium-rep-chrome-hgwc9 8888:5900`

**Data Driven Approach**<br>

Each functionality or group of similar functionality is represented and managed in excel worksheet. In Framework, this worksheet is translated to POJO bean class, which will be passed to Test method iteratively through TestNG Dataproviders. Please note that we are using, a Lazy Data provider in TestNG , that loads the data required for a given iteration one set at a time. 
Another advantage of this approach is we don't need to define test method with all column names in method defination, this especially very useful and clean approach when we have multiple columns in excel.

The sample screenshot of Excel worksheet is:

![](./resources/images/Worksheet.png)

The corresponding Bean class can be represented as:

![](./resources/images/BeanAdminUser.png)

The corresponding Test method can be represented as:

![](./resources/images/TestUserSearch.png)

Please note the test parameter is just one POJO Bean object.

