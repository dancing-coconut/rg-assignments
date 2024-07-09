package com.example.customerbatch.config;

import com.example.customerbatch.entity.Customer;
import com.example.customerbatch.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class SpringBatchConfig {
    private CustomerRepository repository;

    @Bean
    public FlatFileItemReader<Customer> reader() {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip((1));
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<Customer> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return lineMapper;
    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> repositoryItemWriter() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();

        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("csv-step", jobRepository)
                .<Customer, Customer>chunk(10, transactionManager)
                .reader(reader())
                .writer(repositoryItemWriter())
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("importCustomers", jobRepository)
                .flow(step1(jobRepository, transactionManager)).end().build();
    }
}
