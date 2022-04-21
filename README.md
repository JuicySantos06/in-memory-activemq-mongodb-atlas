# Demo MongoDB Atlas & ActiveMQ

## General Information
> The following demo aims at showing how you could integrate a MongoDB Atlas cluster with an in-memory ActiveMQ message broker. 
> We will be leveraging various MongoDB Atlas capabilities like Realm triggers and functions. 
> This demo is intended to showcase functional aspects of such an integration. 
> There are ways to enhance this demo to deliver greater performance but this will not be touched upon during this demo.

* Preparation time: ~30 minutes
* Execution time: ~10 minutes

### Step 1 : Provision a MongoDB Atlas cluster
> Go with the following parameters: dedicated clusters - cloud provider = AWS - region = Paris(eu-west) - cluster tier = M30 (go with the default configuration) - turn off the cloud backup service - cluster name = AtlasMQ, and then click on create cluster. 
> It will take approximately 10-12 min to provision your cluster.

### Step 2 : Provision a MongoDB Atlas cluster
> Click on Browse Collections.
> Click on Add You First Database and then provide the following values: database name = sample_customers, collection name = customers. You can finally click on Create.

### Step 3 :  Insert customer account data into the MongoDB database
> Create the following directory on your laptop (wherever you wish to do so: e.g. Downloads directory for instance): atlas_activemq.
Open a terminal window inside that folder and clone the CRUDScripts GitHub repository. Here is an example of that command: 
```
git clone https://github.com/JuicySantos06/CRUDScripts.git
```
> Go inside the CRUDScripts folder and then open the insert_customer_account file using the following command: 
```
nano insert_customers_account
```
> Go back to the MongoDB Atlas portal and click on Connect.
> Click on Connect your application and then modify the driver and version with the following values: driver = Python, version = 3.12 or later.
> Copy the connection string displayed and paste it into the insert_customer_account file. You just need to paste it to update the MONGODB_ATLAS_URL. Do not forget to change the username and password with the correct values.
> Save the file and exit.
> Change the file extension to .py
> Go and execute the python script using the following command:
```
./insert_customer_account.py
```
> If you encounter any error such as permission denied, you can use the following command to address it: 
```
chmod 755 insert_customer_account.py
```
After that you should be able to run the previous command:
```
./insert_customer_account.py
```
> You should see the following items on your terminal window.
> You can look at your data in MongoDB Atlas to ensure data is rightly sent to your cluster.
> From the main portal, click on Browse Collections.
> At this point, you have a way to automatically insert data into your MongoDB Atlas Cluster.

### Step 4: Provision an EC2 instance on AWS
> Connect to your AWS account using the management console.
> Click on Launch Instances.
> Choose the Amazon Linux 2 AMI (HVM) - Kernel 4.14 and the following instance type t2.micro. 
> There is no need to change the other parameters (number of instances, storage, etc.). We will accept the default values. 
> Add the following tag: Name = in-memory-activemq
> Update the security group configuration by adding the following rules:
```
Allow inbound connection for SSH on 22 and source = 0.0.0.0/0._
Allow inbound connection for Custom TCP Rule on 8282 and source = 0.0.0.0/0.
```
> You can then click on Launch. Ensure you have an existing key pair to connect to that instance, otherwise create one.

### Step 5: Connect to your in-memory-activemq EC2 instance
> Follow the instructions provided by AWS to connect to your instance. Here is an example of how to do it.

### Step 6 : Provision another MongoDB Atlas cluster
> You can go through steps 1 and 2. 
> As an example, we will create a cluster named MQAtlas (because that cluster will automatically be receiving data from ActiveMQ), database name will be sample_customers and collection name will be users.
> You choose whatever values suit you the best. Note that we will be needing that information to feed into the ActiveMQ container which will be running on your EC2 instance.

### Step 7 : Create a MongoDB Data API Key
> Go over your MongoDB Atlas control plan and enable the data API for both AtlasMQ and MQAtlas clusters.
> Do not forget to save the newly created Data API key, we will need it soon after.

### Step 8 : Re-connect to your in-memory-activemq EC2 instance
> Open a terminal window and connect to that instance.
> Go and install Git on your instance by inserting the following commands:
```
sudo yum update -y
sudo yum install git -y
```
> Create a new folder git_repo, go into it and then initialize that local repository:
```
mkdir git_repo
cd git_repo
sudo git init
```
> Clone the in-memory-activemq GitHub repository by using the following command:
```
sudo git clone https://github.com/JuicySantos06/in-memory-activemq.git
```
> Install Apache Maven by issuing the following commands:

### Step 9: Create a Realm Trigger and Function

### Step 10: Full execution of the demo

### Step 11 : ActiveMQ to MongoDB Atlas by leveraging our Data API capabilities
