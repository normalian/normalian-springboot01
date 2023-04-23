# normalian-springboot01

## Frequently use commands 
This command creates environment to deploy your applications. Note that you have to add "--assign-endpoint true" option if you need to publish your endpoint enternal.
```
az spring app create --resource-group ${resource-group} --service ${springapp-servicename} --name ${springapp-appname} --cpu 1 --memory 2Gi --instance-count 2 --assign-endpoint true
```


## References
- https://github.com/actions/setup-java
- https://qiita.com/kaburankattara/items/27a3891512ad2bd935a9
- https://blackbird-blog.com/vsc-springboot-start