//package com.example.practice.config;
//
//import com.example.practice.score.ScoreRepository;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//@EnableElasticsearchRepositories(basePackageClasses = ScoreRepository.class)
//@Configuration
//public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {
//
//    @Value("${elasticsearch.addr}")
//    String esAddr;
//
//    @Override
//    public RestHighLevelClient elasticsearchClient(){
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo(esAddr).build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//}
