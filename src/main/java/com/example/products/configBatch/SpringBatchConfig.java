package com.example.products.configBatch;

import com.example.products.repository.CategoryRepository;
import com.example.products.repository.ClientRepository;
import com.example.products.entity.Client;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;

import java.net.MalformedURLException;

@Configuration
@EnableBatchProcessing
//@AllArgsConstructor
@EnableAutoConfiguration
public class SpringBatchConfig {
   // @Autowired
    private JobBuilderFactory jobBuilderFactory;
   // @Autowired
    private StepBuilderFactory stepBuilderFactory;
  //  @Autowired
    private ClientRepository clientRepository;





    @Autowired
    public SpringBatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ClientRepository clientRepository) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.clientRepository = clientRepository;
    }

    @Bean
    public FlatFileItemReader<Client> reader() throws MalformedURLException {
        FlatFileItemReader<Client> itemReader= new FlatFileItemReader<>();
        itemReader.setResource(new FileUrlResource(this.getClass().getClassLoader().getResource("Clients.csv")));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }
    private LineMapper<Client> lineMapper() {
        DefaultLineMapper<Client> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("firstName","lastName","mobile");
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(Client.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        lineMapper.setLineTokenizer(lineTokenizer);

        return lineMapper;
    }


    @Bean
    public RepositoryItemWriter<Client> writer(){
        RepositoryItemWriter<Client> writer = new RepositoryItemWriter<>();
        writer.setRepository(clientRepository);
        writer.setMethodName("save");
        return writer;
    }



    @Bean
    public ClientProcessor processor(){
        return new ClientProcessor();
    }



    @Bean
    public Step step() throws MalformedURLException {
        return stepBuilderFactory.get("csv-step1").<Client,Client>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job runJob() throws MalformedURLException {
        return jobBuilderFactory.get("importClients")
                .start(step()).build();
    }


}
