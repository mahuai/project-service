package com.admin.service.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.config.properties
 * @date: Created in 2018/7/16 9:55
 */
/*@Component
@ConfigurationProperties(prefix = "spring.kafka")*/
public class ProducerProperties {

    /**
     * kafka 地址
     */
    public String bootstrapServers;

    /**
     * 在acks配置控制下，其请求被认为是完整的标准。
     * 我们指定的“all”设置将导致阻止完整提交记录，这是最慢但最耐用的设置。
     */
    public String acks;

    /**
     * 如果请求失败，则生产者可以自动重试，但由于我们已指定retries 为0，因此不会。
     */
    public Integer retries;

    /**
     * 生产者为每个分区维护未发送记录的缓冲区。这些缓冲区的大小由batch.sizeconfig 指定。
     * 使这个更大可以导致更多的批处理，但需要更多的内存
     */
    public Integer batchSize;

    /**
     * 默认情况下，即使缓冲区中有其他未使用的空间，也可以立即发送缓冲区。但是，
     * 如果您希望减少可以设置linger.ms为大于0 的请求数。这将指示生产者在发送请求之前等待该毫秒数，
     * 希望更多记录到达以填充同一批次。这类似于TCP中的Nagle算法。例如，在上面的代码片段中，
     * 由于我们将逗留时间设置为1毫秒，因此可能会在单个请求中发送所有100条记录。
     * 但是，如果我们没有填满缓冲区，此设置会为我们的请求增加1毫秒的延迟，等待更多记录到达。
     * 请注意，及时到达的记录通常会一起批处理linger.ms=0因此，在重负载下，无论延迟配置如何都会发生批处理;
     * 但是，将此值设置为大于0的值可以在不受最大负载影响的情况下以较少的延迟为代价导致更少，更有效的请求。
     */
    public Integer lingerMs;

    /**
     * buffer.memory控制提供给生产者用于缓冲总量的存储器。
     * 如果记录的发送速度快于传输到服务器的速度，则此缓冲区空间将耗尽。
     * 当缓冲区空间耗尽时，额外的发送调用将被阻止。阻塞时间的阈值由max.block.ms之后确定它抛出TimeoutException。
     */
    public Integer bufferMemory;

    /**
     *key.serializer和value.serializer指导如何打开键和值对象的用户提供与他们的ProducerRecord成字节。
     * 您可以使用包含的ByteArraySerializer或 StringSerializer简单的字符串或字节类型。
     */
    public String keySerializer;


    public String valueSerializer;


    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public Integer getLingerMs() {
        return lingerMs;
    }

    public void setLingerMs(Integer lingerMs) {
        this.lingerMs = lingerMs;
    }

    public Integer getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(Integer bufferMemory) {
        this.bufferMemory = bufferMemory;
    }


    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }
}
