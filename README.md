# Demo MongoDB Atlas & ActiveMQ

### General Information
> The following demo aims at showing how you could integrate a MongoDB Atlas cluster with an in-memory ActiveMQ message broker. 
> We will be leveraging various MongoDB Atlas capabilities like Realm triggers and functions. 
> This demo is intended to showcase functional aspects of such an integration. 
> There are ways to enhance this demo to deliver greater performance but this will not be touched upon during this demo.

* Preparation time: ~30 minutes
* Execution time: ~10 minutes

### Step 1 : Provision a MongoDB Atlas cluster
> Go with the following parameters: dedicated clusters - cloud provider = AWS - region = Paris(eu-west) - cluster tier = M30 (go with the default configuration) - turn off the cloud backup service - cluster name = AtlasMQ, and then click on create cluster. 
> It will take approximately 10-12 min to provision your cluster.

<p align="center">
<img width="555" alt="Screenshot 2022-04-21 at 23 38 07" src="https://user-images.githubusercontent.com/84564830/164556366-2143f13c-18b2-40e6-8e66-7a6540ff8c68.png">
<img width="592" alt="Screenshot 2022-04-21 at 23 41 21" src="https://user-images.githubusercontent.com/84564830/164556734-0b14564d-919a-424d-b8d1-7692e50a3f92.png">
</p>

### Step 2 : Provision a MongoDB Atlas cluster
> Click on Browse Collections.
<p align="center">
<img width="638" alt="Screenshot 2022-04-22 at 09 39 37" src="https://user-images.githubusercontent.com/84564830/164633145-72fd4fe0-7740-4193-8068-a86ed9781a4b.png">
<img width="639" alt="Screenshot 2022-04-22 at 09 39 45" src="https://user-images.githubusercontent.com/84564830/164633300-5e3927c4-845c-4341-9e1b-799269d5e2b3.png">
</p>

> Click on Add You First Database and then provide the following values: database name = sample_customers, collection name = customers. You can finally click on Create.
<p align="center">
<img width="366" alt="Screenshot 2022-04-22 at 09 39 54" src="https://user-images.githubusercontent.com/84564830/164633396-51cfb43d-af88-4979-8146-12e358c4ff19.png">
</p>

### Step 3 :  Insert customer account data into the MongoDB database
> Create the following directory on your laptop (wherever you wish to do so: e.g. Downloads directory for instance): atlas_activemq.
> Open a terminal window inside that folder and clone the CRUDScripts GitHub repository. Here is an example of that command: 
```
git clone https://github.com/JuicySantos06/CRUDScripts.git
```

<p align="center">
<img width="644" alt="Screenshot 2022-04-22 at 09 40 55" src="https://user-images.githubusercontent.com/84564830/164635184-9ebf2fc2-e28d-4757-a5d7-4cc86d8c430f.png">
</p>

> Go inside the CRUDScripts folder and then open the insert_customer_account file using the following command: 
```
nano insert_customers_account
```

> Go back to the MongoDB Atlas portal and click on Connect.
<p align="center">
<img width="639" alt="Screenshot 2022-04-22 at 09 41 05" src="https://user-images.githubusercontent.com/84564830/164635340-9dd8f2c3-053b-465e-ba2a-4fa926fc166e.png">
<img width="587" alt="Screenshot 2022-04-22 at 09 41 14" src="https://user-images.githubusercontent.com/84564830/164635458-02984fa4-7305-4754-b73c-b86be54b87bd.png">
</p>

> Click on Connect your application and then modify the driver and version with the following values: driver = Python, version = 3.12 or later.
<p align="center">
<img width="635" alt="Screenshot 2022-04-22 at 09 41 23" src="https://user-images.githubusercontent.com/84564830/164635547-86d5eebd-86c3-4f7e-bab3-d06c298a3ad5.png">
</p>

> Copy the connection string displayed and paste it into the insert_customer_account file. You just need to paste it to update the MONGODB_ATLAS_URL. Do not forget to change the username and password with the correct values.
<p align="center">
<img width="637" alt="Screenshot 2022-04-22 at 09 41 36" src="https://user-images.githubusercontent.com/84564830/164635743-08fed5e4-27e5-448c-8b8f-881589b1a10d.png">
</p>

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
<p align="center">
<img width="642" alt="Screenshot 2022-04-22 at 09 41 46" src="https://user-images.githubusercontent.com/84564830/164635941-5de48c15-9f61-4485-b7ab-92acb081e2f3.png">
</p>

> You can look at your data in MongoDB Atlas to ensure data is rightly sent to your cluster.
> From the main portal, click on Browse Collections.
<p align="center">
<img width="635" alt="Screenshot 2022-04-22 at 09 41 57" src="https://user-images.githubusercontent.com/84564830/164636159-64563a94-1010-4720-b926-f4597c4f8492.png">
<img width="636" alt="Screenshot 2022-04-22 at 09 42 05" src="https://user-images.githubusercontent.com/84564830/164636280-4b3707c1-0302-4497-ac24-34e7acf567dd.png">
</p>

> At this point, you have a way to automatically insert data into your MongoDB Atlas Cluster.

### Step 4: Provision an EC2 instance on AWS
> Connect to your AWS account using the management console.
<p align="center">
<img width="638" alt="Screenshot 2022-04-22 at 11 14 26" src="https://user-images.githubusercontent.com/84564830/164677130-2e53d618-5f22-4033-ba0f-9e764e80f552.png">
</p>

> Click on Launch Instances.
<p align="center">
<img width="642" alt="Screenshot 2022-04-22 at 11 14 41" src="https://user-images.githubusercontent.com/84564830/164677159-6bf47d9c-e5d9-43ff-b485-935e3c2dffe9.png">
</p>

> Choose the Amazon Linux 2 AMI (HVM) - Kernel 4.14 and the following instance type t2.micro. 
> There is no need to change the other parameters (number of instances, storage, etc.). We will accept the default values. 
<p align="center">
<img width="636" alt="Screenshot 2022-04-22 at 11 14 59" src="https://user-images.githubusercontent.com/84564830/164677182-ac4dac05-5718-4a7a-b1ba-e5d79bc8b1af.png">
</p>

> Add the following tag: Name = in-memory-activemq
<p align="center">
<img width="643" alt="Screenshot 2022-04-22 at 11 16 25" src="https://user-images.githubusercontent.com/84564830/164677217-fb1acb0b-2315-4d8e-96d4-91690e21c701.png">
</p>

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
<p align="center">
<img width="638" alt="Screenshot 2022-04-22 at 11 15 51" src="https://user-images.githubusercontent.com/84564830/164677227-4b3f9a01-e075-4cc3-9dcc-479310db1f6b.png">
</p>

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
```
sudo sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/7/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
````
> Update the application.properties file located in: /in-memory-activemq/src/main/resources.
> Insert the correct values for the following elements: **mongodb.atlas.api.key, mongodb.atlas.cluster, mongodb.atlas.datab	ase, mongodb.atlas.collection**.
> The mongodb.atlas.api.key is the api key you previously retrieved from MongoDB Atlas. 
> Note that we are leveraging the latest cluster created (MQAtlas) as the target environment.
<p align="center">
<img width="640" alt="Screenshot 2022-04-22 at 11 22 48" src="https://user-images.githubusercontent.com/84564830/164677652-b132abb4-5e75-4609-ae24-bba4fc1f74fa.png">
</p>

> Go into the repository that you just downloaded and issue the following Maven command:
```
cd $HOME/git_repo/in-memory-activemq
sudo mvn clean package
```
> Install and start Docker by issuing the following commands:
```
sudo yum install docker
sudo systemctl start docker.service
```
> Build the Docker image of the in-memory-activemq container:
```
sudo docker build --tag=in-memory-activemq:latest .
sudo docker images
```
> Let start and run the docker container:
```
sudo docker run -p 8282:8081 in-memory-activemq:latest
```

### Step 9: Create a Realm Trigger and Function
> Go back to your MongoDB Atlas portal and click on Realm.
> Create a new application by clicking on Create a New App and fill in the required information with the following data: name = AtlasToActiveMQ, link your database = AtlasMQ, advanced configuration - app deployment model - local = Frankfurt, select an environment = testing.
> Click on Triggers to create a trigger, then provide the following information: **trigger type = database, name = insertingDocumentToMDB, enabled = on, event ordering = on, cluster name = AtlasMQ, database name = sample_customers, collection name = customers, operation type = insert, full document = on, event type = function, function name = sendingToActiveMQ**.
> And then copy and paste the following code:
```
exports = async function(changeEvent) {
  const fullDocument = changeEvent.fullDocument;
  const response = await context.http.post({
    url: "http://<YOUR_EC2_INSTANCE_PUBLIC_IP>:8282/amq/mdb/publish/",
    body: fullDocument,
    encodeBodyAsJSON: true
  })
  // The response body is a BSON.Binary object. Parse it and return.
  return EJSON.parse(response.body.text());
};
```
> Ensure you have updated the url with the public ip address of the EC2 instance you previously started. 
> You can get it by going back to your AWS portal and connecting to that instance:
> Going back to MongoDB Realm, you can then Save, Review & Deploy your changes.

### Step 10: Full execution of the demo
> Open a terminal window if you have closed the one pointing to the insert_customers_account script that you previously downloaded, and point to the folder containing that script. 
> Go and issue the following command:
```
./insert_customers_account.py
```
> Ensure that you also have displayed the terminal window connected to your EC2 instance as you will be seeing the results of the inserted documents into the in-memory ActiveMQ broker.
> And that’s about it folks. You just showcased a MongoDB Atlas & In-memory ActiveMQ integration by leveraging both Realm triggers and functions.
> But that’s not it at all …

### Step 11 : ActiveMQ to MongoDB Atlas by leveraging our Data API capabilities
> Go over the second MongoDB Atlas cluster you created earlier, the MQAtlas cluster.
> You will see here all the documents that ActiveMQ is pushing towards MongoDB Atlas MQAtlas cluster.
> Now it is the real end. 
> You just showcased: 1) how MongoDB Atlas could be receiving data to be fetched or sent over ActiveMQ and, 2) how ActiveMQ + Atlas Data API could be leveraged to write data to a MongoDB Atlas MQAtlas cluster.

