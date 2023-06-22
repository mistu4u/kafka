This is a simple Kafka producer consumer paradigm.
In this scenario we are expecting a simple producer generating data and
a simple consumer or a group of consumers listening to it.

This is ideal for those scenarios where we just need to move the data and no need to process it
in the kafka pipeline.

We could have used the KStream module but that would have been an overkill for this simple use case.

We are using Spring boot with Kafka Template , generating random data with scheduler and listening to it using
consumer concurrently.