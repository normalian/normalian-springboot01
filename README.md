# normalian-springboot01

## Frequently use commands 

### Create app under Azure Spring Apps service
This command creates environment to deploy your applications. Note that you have to add "--assign-endpoint true" option if you need to publish your endpoint enternal.
```
az spring app create -g ${resource-group} -s ${springapp-servicename} -n ${springapp-appname} --cpu 1 --memory 2Gi --instance-count 2 --assign-endpoint true
```

### Deploy your app on Azure Spring Apps
```
az spring app deploy -g ${resource-group} -s ${springapp-servicename} -n ${springapp-appname} --artifact-path ./build/libs/demo-0.0.1-SNAPSHOT.jar
```

## References
- https://github.com/actions/setup-java
- https://qiita.com/kaburankattara/items/27a3891512ad2bd935a9
- https://blackbird-blog.com/vsc-springboot-start