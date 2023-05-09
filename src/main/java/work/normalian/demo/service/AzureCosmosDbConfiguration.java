package work.normalian.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

import work.normalian.demo.dto.CosmosProperties;


// Refer to an artcile as follows
// https://learn.microsoft.com/en-us/java/api/overview/azure/spring-data-cosmos-readme?view=azure-java-stable
// https://github.com/Azure-Samples/azure-spring-boot-samples/blob/main/cosmos/spring-cloud-azure-starter-data-cosmos/spring-cloud-azure-data-cosmos-aks-sample/src/main/java/spring/cloud/azure/starter/data/cosmos/sample/aks/CosmosSpringConfiguration.java

@Configuration
@EnableCosmosRepositories
@EnableConfigurationProperties(CosmosProperties.class)
public class AzureCosmosDbConfiguration extends AbstractCosmosConfiguration{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AzureCosmosDbConfiguration.class);

    private CosmosProperties properties;

    AzureCosmosDbConfiguration(CosmosProperties properties){
        this.properties = properties;
    }

    private AzureKeyCredential azureKeyCredential;

    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {
        this.azureKeyCredential = new AzureKeyCredential(properties.getKey());
        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
        return new CosmosClientBuilder()
            .endpoint(properties.getUri())
            .credential(azureKeyCredential)
            .directMode(directConnectionConfig, gatewayConnectionConfig);
    }

    @Override
    protected String getDatabaseName() {
        return properties.getDatabase();
    }
    
}
