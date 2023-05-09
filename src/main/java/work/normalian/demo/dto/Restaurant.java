package work.normalian.demo.dto;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Data;

@Data
@Container(containerName = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String gmapUrl;
    private String description;

    @PartitionKey
    private String genre;
}
