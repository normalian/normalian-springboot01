# normalian-springboot01

## Frequent use commands for Azure Spring Apps

### Create app under Azure Spring Apps service
This command creates environment to deploy your applications. Note that you have to add "--assign-endpoint true" option if you need to publish your endpoint enternal.
```
az spring app create -g ${resource-group} -s ${springapp-servicename} -n ${springapp-appname} --cpu 1 --memory 2Gi --instance-count 2 --assign-endpoint true
```

### Deploy your app on Azure Spring Apps
```
az spring app deploy -g ${resource-group} -s ${springapp-servicename} -n ${springapp-appname} --artifact-path ./build/libs/demo-0.0.1-SNAPSHOT.jar
```

## Azure AD Authentication for Spring Boot

You have to create service principal on your Azure AD tenant before setup your application, then open ./src/main/resources/application.yml and update 3 parameters as follows. 

```
spring:
 cloud:
   azure:
     active-directory:
       enabled: true
       profile:
         tenant-id: YOUR_AZURE_AD_TENANT_ID
       credential:
         client-id: APPLICATION_OR_CLIENT_ID
         client-secret: CLIENT_SECRET
```

Note that ./src/main/java/work/normalian/demo/DemoApplication.java is added @EnableWebSecurity and @EnableGlobalAuthentication annotations to enable Azure AD authentication. 

Refer to official document and youtube content as follows.
- https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/spring-boot-starter-for-azure-active-directory-developer-guide
- https://www.youtube.com/watch?v=cczyS4D-RDA


## Cosmos DB for Spring Boot

You have to create Cosmos DB on Azure Portal, then pick up endpoint, key, and database name parameters as follows. 

```
spring:
 cloud:
   azure:
     cosmos:
       uri : YOUR_COSMOSDB_ENDPOINT
       key : YOUR_COSMOSDB_ENDPOINT_KEY
       secondaryKey : YOUR_COSMOSDB_ENDPOINT_SECONDARYKEY
       database : YOUR_COSMOSDB_NAME
       queryMetricsEnabled : true
```

CosmosProperties class binds the parameters. AzureCosmosDbConfiguration class addresses all the setting to connect with your CosmosDB instance.


## HTTP request parameter binding for Spring Boot with Thymeleaf
You have to put some additional attributes on html files when you use Thymeleaf as template engine as follows. 

```
<form action="#" th:action="@{/form}" th:object="${restaurant}" method="POST">
  <ul>
    <li>Name: <input type="text" name="name" size="20"></li>
```

The th:action="@{/form}" expression directs the form to POST to the /form endpoint, while the th:object="${restaurant}". Refer to an article below for the details.
- https://spring.io/guides/gs/handling-form-submission/

## References
- https://github.com/actions/setup-java
- https://qiita.com/kaburankattara/items/27a3891512ad2bd935a9
- https://blackbird-blog.com/vsc-springboot-start
